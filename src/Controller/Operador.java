package Controller;

import Model.PrecoData;
import Model.Produto;
import Model.Site;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

public class Operador {
    private Hashtable<String, Produto> produtos;

    public Operador() {
        produtos = new Hashtable<>();
    }

    public void addProduto(String nomeProduto, String nomeSite, double preco, String data) {
        Produto produto = produtos.get(nomeProduto);
        if (produto == null) {
            produto = new Produto(nomeProduto);
            produtos.put(nomeProduto, produto);
        }

        Site site = produto.getSites().get(nomeSite);
        if (site == null) {
            site = new Site(nomeSite);
            produto.getSites().put(nomeSite, site);
        }

        site.getPrecoDatas().add(new PrecoData(preco, data));
    }

    public PrecoData menorPrecoProduto(String nomeProduto) {
        Produto produto = produtos.get(nomeProduto);
        if (produto == null) {
            return null;
        }

        PrecoData menorPrecoData = null;
        for (Site site : produto.getSites().values()) {
            for (PrecoData precoData : site.getPrecoDatas()) {
                if (menorPrecoData == null || precoData.getPreco() < menorPrecoData.getPreco()) {
                    menorPrecoData = precoData;
                }
            }
        }
        return menorPrecoData;
    }

    public List<PrecoData> historicoPrecoProduto(String nomeProduto) {
        Produto produto = produtos.get(nomeProduto);
        if (produto == null) {
            return null;
        }

        ArrayList<PrecoData> historico = new ArrayList<>();
        for (Site site : produto.getSites().values()) {
            historico.addAll(site.getPrecoDatas());
        }
        return historico;
    }
}
