/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import java.util.ArrayList;

/**
 *
 * @author luiz-mint
 */
public class Erro {

    ArrayList<String> erros;

    public Erro() {
        erros = new ArrayList();
    }

    public void throwError(int error, String component) {

        switch (error) {
            //Erro 01: Arquivo de entrada nao especificado.
            case 1:
                erros.add("sluba: Erro Fatal: nao ha arquivos de entrada");
                printError();
                System.out.println("Utilize o parametro -h para ajuda");
                System.out.println("Compilacao interrompida.");
                System.exit(1);
                break;
            //Erro 02: Arquivo de entrada nao especificado.
            case 2:
                erros.add("sluba: Erro Fatal: Arquivo ou pasta nao existe");
                printError();
                System.out.println("Utilize o parametro -h para ajuda");
                System.out.println("Compilacao interrompida.");
                System.exit(1);
                break;
                
            case 3:
                //Erro 03: Simbo lido pelo Lexico e invalido
                erros.add("Erro linha " + component + ": Simbolo nao reconhecido.");
                break;
            case 4:
                erros.add("Erro linha " + component + ": Uso incorreto do simbolo '\"'.");
                break;
                
        }

        /*
         * System.out.println("Utilize o parametro -h para ajuda");
         * System.out.println("Compilacao interrompida."); System.exit(1);
         */
    }

    public void printError() {
        for (String string : erros) {
            System.out.println(string);
        }
    }
}
