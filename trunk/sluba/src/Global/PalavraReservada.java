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
public class PalavraReservada {

    Hash tabela;

    public PalavraReservada() {
        //Adiciona todas as palavras reservadas na tabela
        tabela = new Hash();
        tabela.addSimbolo("int");
        tabela.addSimbolo("float");
        tabela.addSimbolo("char");
        tabela.addSimbolo("read");
        tabela.addSimbolo("write");
        tabela.addSimbolo("procedure");
        tabela.addSimbolo("if");
        tabela.addSimbolo("for");
        tabela.addSimbolo("inc");
        tabela.addSimbolo("dec");
        tabela.addSimbolo("break");
        tabela.addSimbolo("Start");
        tabela.addSimbolo("Finish");
    }

    public Hash getTabela() {
        return tabela;
    }

    public void setTabela(Hash tabela) {
        this.tabela = tabela;
    }

    public static boolean isValid(char letter) {
        if (letter >= 33) {
            return true;
        } else {
            return false;
        }
    }
}


/*        tabela.addSimbolo("[");
        tabela.addSimbolo("]");
        tabela.addSimbolo("(");
        tabela.addSimbolo(")");
        tabela.addSimbolo("{");
        tabela.addSimbolo("}");
        tabela.addSimbolo(";");
        tabela.addSimbolo("//");
        tabela.addSimbolo("+");
        tabela.addSimbolo("-");
        tabela.addSimbolo("*");
        tabela.addSimbolo("/");
        tabela.addSimbolo("%");
        tabela.addSimbolo("!=");
        tabela.addSimbolo("==");
        tabela.addSimbolo(">");
        tabela.addSimbolo("<");
        tabela.addSimbolo(">=");
        tabela.addSimbolo("<=");
        tabela.addSimbolo("||");
        tabela.addSimbolo("&&");*/