import java.util.ArrayList;

public class Id3 {

    private ArrayList<Investimento> investimentos = new ArrayList<Investimento>();
    private ArrayList<Propriedade> propriedades = new ArrayList<Propriedade>();
    private Propriedade classe;

    public Id3(ArrayList<Investimento> investimentos) {

        this.investimentos = investimentos;
        this.classe = new Propriedade("Risco");
        criarPropriedades();

    }

    public Id3(ArrayList<Investimento> investimentos, Propriedade classe) {

        this.investimentos = investimentos;
        this.classe = classe;
        criarPropriedades();

    }

    public void iniciar(){

        induzirArvore(investimentos, propriedades);
  
    }

    public ArrayList<Investimento> induzirArvore(ArrayList<Investimento> investimentosL, ArrayList<Propriedade> propriedadesL){

        ArrayList<Investimento> investimentoRetorno = new ArrayList<Investimento>();

        if (verificarSeOsInvestimentosSaoDaMesmaClasse(investimentosL)){
            investimentoRetorno = investimentosL;
        }else if(verificarSePropriedadesEstaoVazias()){
            // coloque algum código aqui
        }else{
            selecionarPropriedade(investimentosL);
        }

        return investimentoRetorno;

    }

    public Boolean verificarSeOsInvestimentosSaoDaMesmaClasse(ArrayList<Investimento> investimentosL){

        boolean saoDaMesmaClasse = true;
        String valorAtual = null;
        String valorAnterior = null;

        for (Investimento investimento : investimentosL) {

            valorAtual = BuscadorValorPropriedade.retornarValor(classe, investimento);

            if(valorAnterior == null){
                valorAnterior = valorAtual;
            }

            if(valorAnterior != valorAtual){
                saoDaMesmaClasse = false;
                break;
            }
            
        }

        return saoDaMesmaClasse;

    }

    public Boolean verificarSePropriedadesEstaoVazias(){

        boolean propriedadesEstaoVazias = false;

        return propriedadesEstaoVazias;

    }

    public void selecionarPropriedade(ArrayList<Investimento> investimentosL){

        

    }

    private void criarPropriedades() {

        propriedades.add(new Propriedade("Risco"));
        propriedades.add(new Propriedade("HistoriaDeCredito"));
        propriedades.add(new Propriedade("Divida"));
        propriedades.add(new Propriedade("Garantia"));
        propriedades.add(new Propriedade("Renda"));

        propriedades.removeIf(p -> p.getNome().equals(classe.getNome()));

    }

    public ArrayList<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(ArrayList<Investimento> investimentos) {
        this.investimentos = investimentos;
    }
}
