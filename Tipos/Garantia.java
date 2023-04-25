package Tipos;

import java.util.ArrayList;

public enum Garantia {

    ADEQUADA("Adequada"),
    NENHUMA("Nenhuma");

    private String descricao;

    Garantia(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ArrayList<String> getListaAtributos(){

        ArrayList<String> listaAtributos = new ArrayList<String>();

        listaAtributos.add(ADEQUADA.getDescricao());
        listaAtributos.add(NENHUMA.getDescricao());

        return listaAtributos;
    }

}
