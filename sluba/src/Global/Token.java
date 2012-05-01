/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

/**
 *
 * @author jeferson
 */
public class Token {
    String simbolo;
    String Classe;
    String Valor;
    String Tipo;

    public Token() {
    }

    public Token(String simbolo, String Classe, String Valor, String Tipo) {
        this.simbolo = simbolo;
        this.Classe = Classe;
        this.Valor = Valor;
        this.Tipo = Tipo;
    }
    
    public Token (String simbolo, String Classe) {
        this.simbolo = simbolo;
        this.Classe = Classe;
        this.Valor = null;
        this.Tipo = null;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String Classe) {
        this.Classe = Classe;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String Tipo) {
        this.Tipo = Tipo;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String Valor) {
        this.Valor = Valor;
    }

    public String getSimbolo() {
        return simbolo;
    }

    public void setSimbolo(String simbolo) {
        this.simbolo = simbolo;
    }
}
