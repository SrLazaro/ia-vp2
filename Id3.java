import java.util.ArrayList;

import Tipos.Divida;

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

    public No iniciar(){

        No no;

        no = induzirArvore(investimentos, propriedades);

        return no;
  
    }

    public No induzirArvore(ArrayList<Investimento> investimentosL, ArrayList<Atributo> propriedadesL){

        Atributo propriedade = null;
        No no = null;

        no = verificarSeOsInvestimentosSaoDaMesmaClasse(investimentosL);
        if (no == null){
            if(verificarSePropriedadesEstaoVazias()){
                no = retornarDisjuncaoDaClasse();
            }else{
                propriedade = selecionarPropriedade(investimentosL);
                removerPropriedade(propriedade);
                no = processarPropriedade(propriedade);
            }
        }

        return no;

    }

    private No retornarDisjuncaoDaClasse() {

        No no = null;
        String valor = "";
        ArrayList<Registro> registrosSumarizado = new ArrayList<Registro>();
        registrosSumarizado = Sumarizador.sumarizarValoresAtributo(classe, investimentos);

        for (Registro registro : registrosSumarizado) {
            valor = valor + " | " + registro.getValor();
        }
        
        no = new No(valor, null);

        return no;
    }

    private No processarPropriedade(Atributo propriedade) {

        No no = null;
        No novoNo = null;
        ArrayList<Investimento> particao = new ArrayList<Investimento>();
        ArrayList<String> valores = new ArrayList<String>();

        valores = BuscadorValorAtributo.retornarLista(propriedade);

        no = new No(propriedade.getNome());

        for (String valor : valores) {
            
            particao = criarParticao(valor, propriedade);
            novoNo = induzirArvore(particao, propriedades);
            no.adicionarNo(novoNo);

        }
        
        return no;

    }

    private ArrayList<Investimento> criarParticao(String valorParticao, Atributo propriedadeParticao) {

        ArrayList<Investimento> particao = new ArrayList<Investimento>();
        String valor = null;

        for (Investimento investimento : investimentos) {

            valor = BuscadorValorAtributo.retornarValor(propriedadeParticao, investimento);

            if(valor.equals(valorParticao)){
                particao.add(investimento);
            }
            
        }

        return particao;
    }

    private void removerPropriedade(Atributo propriedade) {

        propriedades.removeIf(p -> p.getNome().equals(propriedade.getNome()));

    }

    public No verificarSeOsInvestimentosSaoDaMesmaClasse(ArrayList<Investimento> investimentosL){

        No no = null;
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

        if(saoDaMesmaClasse){
            no = new No(valorAtual, null);
        }

        return no;

    }

    public Boolean verificarSePropriedadesEstaoVazias(){

        boolean propriedadesEstaoVazias = false;

        if(this.propriedades.size() == 0){
            propriedadesEstaoVazias = true;
        }

        return propriedadesEstaoVazias;

    }

    public Atributo selecionarPropriedade(ArrayList<Investimento> investimentosL){

        Atributo propriedade = null;

        Entropia entropia = new Entropia(investimentosL, propriedades, classe);
        entropia.iniciar();
        propriedade = entropia.getMelhorPropriedade();

        return propriedade;

    }

    private void criarPropriedades() {

        propriedades.add(new Atributo("Risco"));
        propriedades.add(new Atributo("HistoriaDeCredito"));
        propriedades.add(new Atributo("Divida"));
        propriedades.add(new Atributo("Garantia"));
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
