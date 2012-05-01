/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

import java.util.ArrayList;

/**
 *
 * @author jeferson
 */
public class Bloco {
    private long id;
    private ArrayList<Bloco> listaDeFilhos;
    private Bloco pai;
    private Hash tabelaSimbolo;

    public Bloco() {
        this.id = -1;
        this.listaDeFilhos = new ArrayList<>();
        this.pai = null;
        this.tabelaSimbolo = new Hash();
    }

    public Bloco(long id, Bloco pai) {
        this.id = id;
        this.listaDeFilhos = new ArrayList<>();
        this.pai = pai;
        this.tabelaSimbolo = new Hash();
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public ArrayList<Bloco> getListaDeFilhos() {
        return listaDeFilhos;
    }

    public void setListaDeFilhos(ArrayList<Bloco> listaDeFilhos) {
        this.listaDeFilhos = listaDeFilhos;
    }

    public Bloco getPai() {
        return pai;
    }

    public void setPai(Bloco pai) {
        this.pai = pai;
    }

    public Hash getTabelaSimbolo() {
        return tabelaSimbolo;
    }

    public void setTabelaSimbolo(Hash tabelaSimbolo) {
        this.tabelaSimbolo = tabelaSimbolo;
    }
}
