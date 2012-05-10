/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexico;

import Global.Erro;
import Global.PalavraReservada;
import Global.TabelaDeSimbolos;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 *
 * @author Caps
 */
public class Lexico {

    TabelaDeSimbolos simbolos;
    PalavraReservada palavras;
    String classeId;
    boolean verbose;
    Erro erro;

    public Lexico(TabelaDeSimbolos tb, boolean v, Erro erro) {
        simbolos = tb;
        palavras = new PalavraReservada();
        classeId = "id";
        verbose = v;
        this.erro = erro;
    }

    //Este metodo realiza a leitura completa de arquivo, completando a tabela de simbolos
    public void readFile(RandomAccessFile raf) throws IOException {

        /*
         * Variaveis auxiliares de leitura
         *
         * @line = a leitura de String de cada linha eh lida neste vetor de
         * caracteres, portanto, a leitura do arquivo eh feita linha a linha
         *
         * @palavra = Durate a leitura, o reconhecimento da palavra vai sendo
         * adicionado a esta string, para ser verificada sua validade num
         * momento de interrupcao
         *
         * @j = variavel contador que indica a linha atual do leitor, para
         * feedback de erro.
         *
         * @panic = booleano que indica se a leitura da palavra atual esta em
         * erro, para que seja ignorada ao seu final
         */
        char[] line;
        String palavra = new String();
        int j = 0;
        boolean panic = false;

        if (verbose) {
            System.out.println("\tIniciando a leitura de linhas");
        }
        //Este ciclo While varre o arquivo todo
        while ((raf.length() - raf.getFilePointer()) > 0) {
            //Leitura da linha
            line = raf.readLine().toCharArray();
            j++;

            /*
             * Este for percorre o vetor de caracteres da linha Aqui eh
             * realizada a validacao dos simbolos
             */
            for (int i = 0; i < line.length; i++) {

                /*
                 * Aqui eh verificado se o caracter lido atualmente eh uma letra
                 * maiuscula ou minuscula ou um numero.
                 *
                 * O objetivo eh adiciona-lo na palavra em leitura
                 *
                 * @Erro 5 = Se a palavra estiver iniciando com numeros, ela
                 * deve ser obrigatoriamente numeros. Se houver caracteres gera
                 * um erro.
                 *
                 */
                if ((line[i] > 64 && line[i] < 91) //Letra maiuscula
                        || (line[i] > 96 && line[i] < 123) //Letra minuscula
                        || (line[i] >= 48 && line[i] <= 57) // Numeros
                        ) {

                    //Verifica se foi lido um numero e ao mesmo tempo a palavra esta vazia
                    if (palavra.equals("") && (line[i] >= 48 && line[i] <= 57)) {
                        //Este ciclo while percorre a linha enquanto for lido numeros, para serem ignorados
                        i++;
                        while (line[i] >= 48 && line[i] <= 57 && i < (line.length - 1)) {
                            i++;
                        }

                        //Como foi lido inicialmente um numero, nao pode ser lido uma letra. Este if gera o erro caso haja uma letra, entrando no modo panico.
                        if (((line[i] > 64 && line[i] < 91) || (line[i] > 96 && line[i] < 123))
                                && (line.length > i)) {
                            erro.throwError(5, Integer.toString(j));
                            panic = true;
                        }
                    }

                    //Aqui verifica se foi lido uma letra ou numero e ao mesmo tempo a palavra nao estiver vazia.
                    if ((line[i] > 64 && line[i] < 91)
                            || (line[i] > 96 && line[i] < 123)
                            || (!palavra.equals("") && (line[i] >= 48 && line[i] <= 57))) {
                        palavra += line[i];
                    }
                }

                //Encontra interrupção, para verificar se a palavra esta pronta.
                if ((line[i] == ' ')
                        || (line[i] == 10) // enter
                        || (line[i] == 9) // tab
                        || (line[i] == ';')
                        || (line[i] == '{')
                        || (line[i] == '}')
                        || (line[i] == '(')
                        || (line[i] == ')')
                        || (line[i] == '[')
                        || (line[i] == ']')
                        || (line[i] == '=')
                        || (line[i] == '+')
                        || (line[i] == '-')
                        || (line[i] == '*')
                        || (line[i] == '/')
                        || (line[i] == '%')
                        || (line[i] == '!')
                        || (line[i] == '>')
                        || (line[i] == '<')
                        || (line[i] == '|')
                        || (line[i] == '&')
                        || (line[i] == '"')
                        || (line[i] == ',')
                        || (line[i] == '.')) {

                    //Se a palavra estiver vazia, nao ha o que armazenar, por isto esta verificacao.
                    if (!palavra.equals("")) {

                        //Verifica se é nao uma palavra reservada, se for ignora
                        if (!palavras.getTabela().encontrarSimbolo(palavra)) {
                            //Verifica se o simbolo ja foi inserido anteriormente
                            if (!simbolos.encontrarSimbolo(palavra)) {
                                //Verifica o modo panico, que se estiver ligado, esta palavra deve ser ignorada
                                if (!panic) {
                                    simbolos.InserirSimbolo(palavra, classeId);
                                    if (verbose) {
                                        System.out.println("Simbolo adicionado: " + palavra);
                                    }
                                    //depois da adição de um simbolo for encontrado um chave add bloco
                                    if (line[i] == '{') {
                                        simbolos.abrirBloco();
                                    }
                                    if (verbose) {
                                        System.out.println("Novo bloco identificado");
                                    }
                                    if(line[i] == '}'){
                                        //Se o pai não for nulo existe um bloco acima na hierarquia que será a nova raiz
                                        if(simbolos.getRaiz().getPai() != null){
                                            simbolos.fecharBloco();
                                        }
                                        if(verbose){
                                            System.out.println("Bloco fechado");
                                        }
                                    }
                                }
                            }
                        }
                        palavra = "";
                    }
                    panic = false;
                }

                //Verifica caractere inválido, em lógica inversa
                if (!((line[i] >= 33 && line[i] <= 34) // Simbolos: !, "
                        || (line[i] >= 37 && line[i] <= 43) // Simbolos: %, &, ', (, ), *, +
                        || (line[i] >= 46 && line[i] <= 57) // Simbolos: ., /, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
                        || (line[i] >= 59 && line[i] <= 62) // Simbolos: ;, <, =, >
                        || (line[i] >= 65 && line[i] <= 91) // Simbolos: de A a Z, [
                        || (line[i] == 93) // Simbolo: ]
                        || (line[i] == 95) // Simbolo: _
                        || (line[i] >= 97 && line[i] <= 125) // Simbolos: de a a z, {, |, }
                        || (line[i] >= 9 && line[i] <= 10) // Simbolos: enter, tab
                        || (line[i] == ' ') // Espaco
                        || (line[i] == ',') // virgula
                        || (line[i] == '-') // menos
                        )) {
                    //Se houver uma palavra sendo reconhecida, entra em modo panico
                    panic = true;
                    erro.throwError(3, Integer.toString(j));
                }

                //Verifica String, para ser ignorada
                if (line[i] == 34) { //Simbolo: " 
                    i++;
                    //Percorre ateh encontrar outra aspa
                    while (line[i] != 34) {
                        i++;
                        //Erro caso termine a linha sem encontrar a aspa
                        if (line.length == i) {
                            erro.throwError(4, Integer.toString(j));
                            break;
                        }
                    }
                }

                //Verifica comentario
                if (line[i] == '/') {
                    if (i != (line.length - 1)) {
                        if (line[i++] == '/') {
                            break;
                        } else {
                            //gera erro caso nao encontre outra aspa
                            erro.throwError(6, Integer.toString(j));
                        }
                    } else {
                        erro.throwError(6, Integer.toString(j));
                    }
                }
            }
            
            //Aqui finaliza o for, e a verificacao da linha pode ter finalizada sem ter finalizado a verificacao de algum simbolo
            //Esta verificacao eh a mesma que esta dentro do for
            if (!palavra.equals("")) {
                //Verifica se é uma palavra reservada 
                if (!palavras.getTabela().encontrarSimbolo(palavra)) {
                    if (!simbolos.encontrarSimbolo(palavra)) {
                        if (!panic) {
                            simbolos.InserirSimbolo(palavra, classeId);
                            System.out.println("Simbolo adicionado: " + palavra);
                        } else {
                            panic = false;
                        }
                    }
                }
                palavra = "";
            }
            //Fim da linha
        }
    }
}