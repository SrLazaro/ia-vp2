import java.util.ArrayList;

public class Entropia {
    
    private ArrayList<Investimento> investimentos = new ArrayList<Investimento>();
    private ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();
    private Propriedade classe;
    private int qtdRegistro;

    public Entropia(ArrayList<Investimento> investimentos, ArrayList<Propriedade> propriedades, Propriedade classe) {
        this.investimentos = investimentos;
        this.propriedades = propriedades;
        this.classe = classe;
    }

    public void iniciar(){

        qtdRegistro = investimentos.size();
        calcularEntropiaDaClasse();

    }

    public void calcularEntropiaDaClasse(){

        String valor = null;
        ArrayList<Registro> registros = new ArrayList<Registro>();

        for (Investimento investimento : investimentos) {

            valor = BuscadorValorPropriedade.retornarValor(classe, investimento);

            // adicionar uma logica aqui 

            
        }


    }

    public ArrayList<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(ArrayList<Investimento> investimentos) {
        this.investimentos = investimentos;
    }

    public ArrayList<Propriedade> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(ArrayList<Propriedade> propriedades) {
        this.propriedades = propriedades;
    }

    public Propriedade getClasse() {
        return classe;
    }

    public void setClasse(Propriedade classe) {
        this.classe = classe;
    }

    public int getQtdRegistro() {
        return qtdRegistro;
    }

    public void setQtdRegistro(int qtdRegistro) {
        this.qtdRegistro = qtdRegistro;
    }

}
