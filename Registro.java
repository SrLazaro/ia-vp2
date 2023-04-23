public class Registro {
    
    private String valor;
    private int quantidade;

    public Registro(String valor, int quantidade) {
        this.valor = valor;
        this.quantidade = quantidade;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

}
