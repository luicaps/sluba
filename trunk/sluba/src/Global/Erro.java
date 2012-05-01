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
            //Erro 01: Arquivo de entrada nao encontrado.
            case 1:
                System.out.println("sluba: erro fatal: nao ha arquivos de entrada");
                System.out.println("Utilize o parametro -h para ajuda");
                System.out.println("Compilacao interrompida");
        }
        System.exit(1);
    }
}
