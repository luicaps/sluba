/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sluba;

import Global.Erro;
import Global.PalavraReservada;
import java.io.File;

/**
 *
 * @author luiz-mint
 */
public class Sluba {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean verbose = false;
        boolean output = false;
        String oPath = null;

        //Verficia se ha arquivo de entrada
        if (args.length == 1) {
            Erro.throwError(1);
        }

        //help
        if (args[1].compareTo("-h") == 0) {
            System.out.println("Uso: sluba <opcao> <arquivo> <parametro>");
            System.out.println("<opcao> e <parametro> NAO sao obrigatorios\n\n");
            System.out.println("opcao:");
            System.out.println("\t-h\tMostra estas informacoes");
            System.out.println("\n");
            System.out.println("arquivo:\tarquivo ou diretorio para arquivo a ser compilado");
            System.out.println("\n");
            System.out.println("parametro:\n");
            System.out.println("\t-o arquivo\tOutput: Cria o arquivo compilado em diretorio e nome especificos, incluindo extensao");
            System.out.println("\t-v \t\tVerbose: Expressa em texto os processos do compilador");
            System.out.println("\n");
            System.out.println("Spam, Louis and Drumstick corp.");
            System.exit(0);
        }


        //Abre o arquivo
        File file;
        if (args[1].substring(0, 1).compareTo("/") == 0) {
            file = new File(args[1]);
        } else {
            file = new File(args[0] + "/" + args[1]);
        }
         
        //Verifica existencia do arquivo
        if (!file.exists()) {
            Erro.throwError(2);
        }

        System.out.println(file.getName().split("."));
        System.out.println(file.getName());
        
        //Analisa os parametros de entrada
        for (int i = 2; i < args.length; i++) {
            if (args[i].equals("-o")) {
                output = true;
                oPath = args[i + 1];
            } else {
                if (args[i].equals("-v")) {
                    verbose = true;
                }
            }
        }

        //Verbose
        if(verbose) {
            System.out.println("Arquivo de entrada aceito com sucesso para:");
            System.out.println(file.getAbsolutePath());
            System.out.println();
        }
        
        //Inicio de Modulo Lexico
        System.out.println("Iniciando analise lexica:\n\n");

    }
}
