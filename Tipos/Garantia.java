package Tipos;
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

}
