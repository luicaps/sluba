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

    public void abrirBloco(long id) {
        Bloco filho = new Bloco(id, this.raiz);
        this.raiz.getListaDeFilhos().add(filho);
        this.raiz = this.raiz.getListaDeFilhos().get(this.raiz.getListaDeFilhos().size() - 1);
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
}
