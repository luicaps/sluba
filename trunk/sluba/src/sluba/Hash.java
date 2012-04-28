/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package sluba;

import java.util.ArrayList;

/**
 *
 * @author jeferson
 */
public class Hash {
    ArrayList[] chaves;

    public Hash() {
        this.chaves = new ArrayList[8];        
        for(int i = 0; i < this.chaves.length; i++){
            this.chaves[i] = new ArrayList<>();
        }
    }
    
    public void addSimbolo(String simbolo){
        int indice = funcaoHash(simbolo);
        this.chaves[indice].add(simbolo);
    }
    
    public int encontrarSimbolo(String simbolo){
        return funcaoHash(simbolo);
    }
    
    protected int funcaoHash(String palavra){
        long soma = 0;
        for(int i = 0; i < palavra.length(); i++){
            int aux = palavra.charAt(i);
            soma += Math.pow(aux, i);
        }
        return (int) (soma%this.chaves.length);
    }
    
    public void imprimirTabelaHash(){
        for(int i = 0; i < this.chaves.length; i++){
            System.out.printf("chave numero: "+(i+1)+"\n\t");
            for(int j = 0; j < this.chaves[i].size();j++){
                System.out.printf(chaves[i].get(j)+", ");
            }
             System.out.println("");
        }
    }
    
    
}
