package Tipos;

import java.util.ArrayList;

public enum Renda {

    ALTA("Acima de $35 mil"),
    MEDIA("$15 a $35 mil"),
    BAIXA("$0 a $15 mil");

    private String descricao;

    Renda(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ArrayList<String> getListaAtributos(){

        ArrayList<String> listaAtributos = new ArrayList<String>();

        listaAtributos.add(ALTA.getDescricao());
        listaAtributos.add(MEDIA.getDescricao());
        listaAtributos.add(BAIXA.getDescricao());

        return listaAtributos;
    }

}
