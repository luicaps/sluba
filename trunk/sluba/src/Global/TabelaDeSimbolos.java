/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

/**
 *
 * @author jeferson
 */
public class TabelaDeSimbolos {

    private Bloco raiz;

    public TabelaDeSimbolos() {
        this.raiz = new Bloco();
        this.raiz.setPai(null);
    }

    public TabelaDeSimbolos(Bloco raiz) {
        this.raiz = raiz;
    }

    public void matarTabela() {
        raiz = null;
    }

    public boolean TabelaIsEmpty() {
        if (raiz == null) {
            return true;
        } else {
            return false;
        }
    }

    public void abrirBloco() {
        Bloco filho = new Bloco(this.raiz);
        this.raiz.getListaDeFilhos().add(filho);
        filho.setIdLista(this.raiz.getListaDeFilhos().size()-1);
        this.raiz = filho;
    }

    public void fecharBloco() {
        if (this.raiz.getPai() != null) {
            this.raiz = this.raiz.getPai();
        }
    }

    public void InserirSimbolo(String simbolo, String classe) { //Luiz id
        this.raiz.getTabelaSimbolo().addToken(simbolo, classe);
    }

    public boolean encontrarSimbolo(String simbolo) {
        if (this.raiz.getTabelaSimbolo().encontrarToken(simbolo) == null) {
            return false;
        } else {
            return true;
        }
    }

    public Bloco getRaiz() {
        return raiz;
    }

    public void setRaiz(Bloco raiz) {
        this.raiz = raiz;
    }
}
