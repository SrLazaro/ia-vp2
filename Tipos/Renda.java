package Tipos;
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

}
