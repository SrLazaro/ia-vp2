package Tipos;

import java.util.ArrayList;

public enum Divida {

    ALTA("Alta"),
    BAIXA("Baixa");

    private String descricao;

    Divida(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ArrayList<String> getListaAtributos(){

        ArrayList<String> listaAtributos = new ArrayList<String>();

        listaAtributos.add(ALTA.getDescricao());
        listaAtributos.add(BAIXA.getDescricao());

        return listaAtributos;
    }

}
