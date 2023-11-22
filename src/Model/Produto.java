package Model;

import java.util.Hashtable;

public class Produto {
    private String nome;
    private Hashtable<String, Site> sites;

    public Produto(String nome) {
        this.nome = nome;
        this.sites = new Hashtable<>();
    }

    public String getNome() {
        return nome;
    }

    public Hashtable<String, Site> getSites() {
        return sites;
    }
}
