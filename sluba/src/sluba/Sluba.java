/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sluba;

import Global.PRes;
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

        
        if (args.length == 1) {
            System.out.println("sluba: erro fatal: nao ha arquivos de entrada");
            System.out.println("Utilize o parametro -h para ajuda");
            System.out.println("Compilacao interrompida");
            System.exit(1);
        }
        
        //help
        if(args[1].compareTo("-h")==0) {
            
        }
        
        File file;
        
        if(args[1].substring(0, 1).compareTo("/")==0) {
            file = new File(args[1]);
        } else {
            file = new File(args[0]+"/"+args[1]);
        }
        
        for (int i = 2; i < args.length; i++) {
            //analisa os parametros
        }
    }
}