package Tipos;

import java.util.ArrayList;

public enum HistoriaDeCredito {

    BOA("Boa"),
    DESCONHECIDA("Desconhecida"),
    RUIM("Ruim");

    private String descricao;

    HistoriaDeCredito(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public static ArrayList<String> getListaAtributos(){

        ArrayList<String> listaAtributos = new ArrayList<String>();

        listaAtributos.add(BOA.getDescricao());
        listaAtributos.add(DESCONHECIDA.getDescricao());
        listaAtributos.add(RUIM.getDescricao());

        return listaAtributos;
    }

}
