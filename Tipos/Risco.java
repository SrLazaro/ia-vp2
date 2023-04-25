package Tipos;

import java.util.ArrayList;

public enum Risco {
    
    ALTO("Alto"),
    MODERADO("Moderado"),
    BAIXO("Baixo");

    private String descricao;

    Risco(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ArrayList<String> getListaAtributos(){

        ArrayList<String> listaAtributos = new ArrayList<String>();

        listaAtributos.add(ALTO.getDescricao());
        listaAtributos.add(MODERADO.getDescricao());
        listaAtributos.add(BAIXO.getDescricao());

        return listaAtributos;
    }
    
}
