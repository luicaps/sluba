/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sluba;

import Global.Erro;
import Global.TabelaDeSimbolos;
import Lexico.Lexico;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luiz-mint
 */
public class Sluba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Erro erro = new Erro();
        boolean verbose = false;
        boolean output = false;
        String oPath = null;

        //Tabela de Simbolos
        TabelaDeSimbolos tb = new TabelaDeSimbolos();

        //Arquivo
        File file;
        int f = 1;

        //Verficia se ha arquivo de entrada
        if (args.length == 1) {
            erro.throwError(1, null);
        }

        //help
        if (args[1].compareTo("-h") == 0) {
            System.out.println("Uso: sluba <opcao> <arquivo> <parametro>");
            System.out.println("<opcao> e <parametro> NAO sao obrigatorios\n\n");
            System.out.println("opcao:");
            System.out.println("\t-h\tMostra estas informacoes");
            System.out.println("\t-v \tVerbose: Expressa em texto os processos do compilador");
            System.out.println("\n");
            System.out.println("arquivo:\tarquivo ou diretorio para arquivo a ser compilado");
            System.out.println("\n");
            System.out.println("parametro:\n");
            System.out.println("\t-o <arquivo>\tOutput: Cria o arquivo compilado em diretorio e nome especificos, incluindo extensao");
            System.out.println("\n");
            System.out.println("Spam, Louis and Drumstick corp.");
            System.exit(0);
        }

        //Verbose
        if (args[1].equals("-v")) {
            verbose = true;
            System.out.println("Opcao Verbose ativada.");
            f++;
        }

        //Analisa os parametros de entrada
        for (int i = 2; i < args.length; i++) {
            if (args[i].equals("-o")) {
                output = true;
                oPath = args[i + 1];
            }
        }

        //Abre o arquivo
        if (args[f].substring(0, 1).compareTo("/") == 0) {
            file = new File(args[f]);
        } else {
            file = new File(args[0] + "/" + args[f]);
        }

        //Verifica existencia do arquivo
        if (!file.exists()) {
            erro.throwError(2, null);
        }


        //Verifica se o formato esta correto
        if (!file.getAbsolutePath().substring((file.getAbsolutePath().length() - 3), file.getAbsolutePath().length()).equals("slb")) {
            erro.throwError(0, null);
        }

        //Verbose
        if (verbose) {
            System.out.println("Arquivo de entrada aceito com sucesso para:");
            System.out.println(file.getAbsolutePath());
            System.out.println();
        }

        //Instancia os Modulos
        Lexico lexico = new Lexico(tb, verbose, erro);
        //Inicio de Modulo Lexico
        
        //Caminho statico do arquivo de Tokens
        final String tokenpath = file.getParent() + "/out_token_"+ file.getName().substring(0, (file.getName().length() - 4)) +".slbt";
        
        if (verbose) {
            System.out.println("Iniciando analise lexica:\n\n");
        }
        try {
            lexico.readFile(new RandomAccessFile(file, "r"), tokenpath);
        } catch (IOException ex) {
            Logger.getLogger(Sluba.class.getName()).log(Level.SEVERE, null, ex);
        }

        //Imprime erros
        erro.printError();
    }
}
