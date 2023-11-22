package Model;

import java.util.ArrayList;
import java.util.List;

public class Site {
    private String nome;
    private List<PrecoData> precoDatas;

    public Site(String nome) {
        this.nome = nome;
        this.precoDatas = new ArrayList<>();
    }

    public String getNome() {
        return nome;
    }

    public List<PrecoData> getPrecoDatas() {
        return precoDatas;
    }
}
