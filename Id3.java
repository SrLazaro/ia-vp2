import java.util.ArrayList;

public class Id3 {

    private ArrayList<Investimento> investimentos = new ArrayList<Investimento>();
    private ArrayList<Atributo> propriedades = new ArrayList<Atributo>();
    private Atributo classe;

    public Id3(ArrayList<Investimento> investimentos) {

        this.investimentos = investimentos;
        this.classe = new Atributo("Risco");
        criarPropriedades();

    }

    public Id3(ArrayList<Investimento> investimentos, Atributo classe) {

        this.investimentos = investimentos;
        this.classe = classe;
        criarPropriedades();

    }

    public void iniciar(){

        induzirArvore(investimentos, propriedades);
  
    }

    public ArrayList<Investimento> induzirArvore(ArrayList<Investimento> investimentosL, ArrayList<Atributo> propriedadesL){

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

            valorAtual = BuscadorValorAtributo.retornarValor(classe, investimento);

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

        Entropia entropia = new Entropia(investimentosL, propriedades, classe);
        entropia.iniciar();

    }

    private void criarPropriedades() {

        propriedades.add(new Atributo("Risco"));
       // propriedades.add(new Atributo("HistoriaDeCredito"));
       // propriedades.add(new Atributo("Divida"));
     //   propriedades.add(new Atributo("Garantia"));
        propriedades.add(new Atributo("Renda"));

        propriedades.removeIf(p -> p.getNome().equals(classe.getNome()));

    }

    public ArrayList<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(ArrayList<Investimento> investimentos) {
        this.investimentos = investimentos;
    }
}
