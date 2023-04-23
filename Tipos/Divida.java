package Tipos;
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
}
