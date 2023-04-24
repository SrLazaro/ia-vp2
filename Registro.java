import java.util.ArrayList;

public class Registro {
    
    private String valor;
    private int quantidade;
    private ArrayList<Investimento> investimentos = new ArrayList<Investimento>();


    public Registro(String valor, int quantidade, Investimento investimento) {
        this.valor = valor;
        this.quantidade = quantidade;
        adicionarInvestimento(investimento);
    }

    public void adicionarQuantidade(){
        this.quantidade++;
    }

    public void adicionarInvestimento(Investimento investimento){
        this.investimentos.add(investimento);
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

    public ArrayList<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(ArrayList<Investimento> investimentos) {
        this.investimentos = investimentos;
    }
    
}
