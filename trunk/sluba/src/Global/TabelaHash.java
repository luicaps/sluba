/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Global;

/**
 *
 * @author jeferson
 */
public class TabelaHash extends Hash {

    public void addToken(String simbolo, String classe) {
        Token token = new Token(simbolo, classe);
        int indice = funcaoHash(simbolo);
        this.chaves[indice].add(token);
    }

    public Token encontrarToken(String simbolo) {
        return verificarToken(funcaoHash(simbolo), simbolo);
    }

    /*
     * caso o token não exista ele returna null se não retorna o teken
     */
    protected Token verificarToken(int index, String simbolo) {
        if (this.chaves[index].size() == 1) {
            Token novo = (Token) chaves[index].get(0);
            if (novo.getSimbolo().equals(simbolo)) {
                return novo;
            } else {
                return null;
            }
        } else {
            for (int i = 0; i < this.chaves[index].size(); i++) {
                Token novo = (Token) chaves[index].get(i);
                if (novo.getSimbolo().equals(simbolo)) {
                    return novo;
                }
            }
            return null;
        }
    }
}
