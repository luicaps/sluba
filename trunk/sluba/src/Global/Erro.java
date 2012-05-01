/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

/**
 *
 * @author luiz-mint
 */
public class Erro {

    public static void throwError(int error) {

        switch (error) {
            //Erro 01: Arquivo de entrada nao especificado.
            case 1:
                System.out.println("sluba: Erro 01: nao ha arquivos de entrada");
                break;
            //Erro 02: Arquivo de entrada nao especificado.
            case 2:
                System.out.println("sluba: Erro 02: Arquivo ou pasta nao existe");
                break;
        }

        System.out.println("Utilize o parametro -h para ajuda");
        System.out.println("Compilacao interrompida.");
        System.exit(1);
    }
}
