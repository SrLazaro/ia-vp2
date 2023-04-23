package Tipos;
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
    
}
