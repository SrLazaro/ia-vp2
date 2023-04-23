package Tipos;
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

}
