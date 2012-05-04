/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Lexico;

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

    public Lexico(TabelaDeSimbolos tb, boolean v) {
        simbolos = tb;
        palavras = new PalavraReservada();
        classeId = "id";
        verbose = v;
    }

    public void readFile(RandomAccessFile raf) throws IOException {
        //Inicia a leitura de arquivo
        char[] line = raf.readLine().toCharArray();
        String palavra = new String();
        while (line != null) {
            for (int i = 0; i < line.length; i++) {
                //Estado 72 - Encontra letra
                if ((line[i] > 64 && line[i] < 91) || (line[i] > 96 && line[i] < 123)) {
                    palavra += line[i];
                }
                //Encontra interrupção
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
                        || (line[i] == '.')) {

                    if (!palavra.equals("")) {
                        //Verifica se é uma palavra reservada 
                        if (!palavras.getTabela().encontrarSimbolo(palavra)) {
                            if (!simbolos.encontrarSimbolo(palavra)) {
                                simbolos.InserirSimbolo(palavra, classeId);
                            }
                        }
                        palavra = "";
                    }
                }

                //Verifica caractere inválido, lógica inversa
                if (!(line[i] >= 33 && line[i] <= 34) // Simbolos: !, "
                        || !(line[i] >= 37 && line[i] <= 43) // Simbolos: %, &, ', (, ), *, +
                        || !(line[i] >= 47 && line[i] <= 57) // Simbolos: /, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9
                        || !(line[i] >= 60 && line[i] <= 62) // Simbolos: <, =, >
                        || !(line[i] >= 65 && line[i] <= 91) // Simbolos: de A a Z, [
                        || !(line[i] == 93) // Simbolo: ]
                        || !(line[i] == 95) // Simbolo: _
                        || !(line[i] >= 97 && line[i] <= 125) // Simbolos: de a a z, {, |, }
                        || !(line[i] >= 9 && line[i] <= 10) // Simbolos: enter, tab
                        ) {
                    //Erro...
                }
            }
            //Fim da linha
            line = raf.readLine().toCharArray();
        }
    }
}
