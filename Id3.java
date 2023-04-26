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

        ArrayList<Investimento> investimentosL = investimentos;
        ArrayList<Atributo> propriedadesL = propriedades;

        no = induzirArvore(investimentosL, propriedadesL);

        return no;
  
    }

    public No induzirArvore(ArrayList<Investimento> investimentosParametro, ArrayList<Atributo> propriedadesParametro){

        Atributo propriedade = null;
        No no = null;

        ArrayList<Investimento> investimentosL = atribuirInvestimento(investimentosParametro);
        ArrayList<Atributo> propriedadesL = atribuirPropriedade(propriedadesParametro);

        no = verificarSeOsInvestimentosSaoDaMesmaClasse(investimentosL);
        if (no == null){
            if(verificarSePropriedadesEstaoVazias(propriedadesL)){
                no = retornarDisjuncaoDaClasse(investimentosL);
            }else{
                propriedade = selecionarPropriedade(investimentosL, propriedadesL);
                propriedadesL = removerPropriedade(propriedadesL, propriedade);
                no = processarPropriedade(propriedade, propriedadesL, investimentosL);
            }
        }

        return no;

    }

    private ArrayList<Atributo> atribuirPropriedade(ArrayList<Atributo> propriedadesParametro) {
        
        ArrayList<Atributo> propriedadesSaida = new ArrayList<Atributo>();

        if(propriedadesParametro != null || propriedadesParametro.size() != 0){
            for (Atributo propriedade : propriedadesParametro) {
                    propriedadesSaida.add(propriedade);
                }
        }


        return propriedadesSaida;

    }

    private ArrayList<Investimento> atribuirInvestimento(ArrayList<Investimento> investimentosParametro) {
        
        ArrayList<Investimento> investimentoSaida = new ArrayList<Investimento>();

        if(investimentosParametro != null || investimentosParametro.size() != 0){
            for (Investimento investimento : investimentosParametro) {
                    investimentoSaida.add(investimento);
                }
        }

        return investimentoSaida;

    }

    private No retornarDisjuncaoDaClasse(ArrayList<Investimento> investimentosL) {

        No no = null;
        String valor = "";
        ArrayList<Registro> registrosSumarizado = new ArrayList<Registro>();
        registrosSumarizado = Sumarizador.sumarizarValoresAtributo(classe, investimentosL);

        for (Registro registro : registrosSumarizado) {
            if(valor.equals("")){
                valor = registro.getValor();
            }else{
                valor = valor + " ~ " + registro.getValor();
            }
        }
        
        no = new No(valor, null);

        return no;
    }

    private No processarPropriedade(Atributo propriedade, ArrayList<Atributo> propriedadesL, ArrayList<Investimento> investimentosL) {

        No no = null;
        No novoNo = null;
        No valorNo = null;
        ArrayList<Investimento> particao = new ArrayList<Investimento>();
        ArrayList<String> valores = new ArrayList<String>();

        valores = BuscadorValorAtributo.retornarLista(propriedade);

        no = new No("* " + propriedade.getNome());

        for (String valor : valores) {

            valorNo = new No("+ " + valor);
            no.adicionarNo(valorNo);

            
            particao = criarParticao(valor, propriedade, investimentosL);
            novoNo = induzirArvore(particao, propriedadesL);
            valorNo.adicionarNo(novoNo);

        }
        
        return no;

    }

    private ArrayList<Investimento> criarParticao(String valorParticao, Atributo propriedadeParticao, ArrayList<Investimento> investimentosParticao) {

        ArrayList<Investimento> particao = new ArrayList<Investimento>();
        String valor = null;

        for (Investimento investimento : investimentosParticao) {

            valor = BuscadorValorAtributo.retornarValor(propriedadeParticao, investimento);

            if(valor.equals(valorParticao)){
                particao.add(investimento);
            }
            
        }

        return particao;
    }

    private ArrayList<Atributo> removerPropriedade(ArrayList<Atributo> propriedadesL, Atributo propriedade) {

        propriedadesL.removeIf(p -> p.getNome().equals(propriedade.getNome()));

        return propriedadesL;

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

    public Boolean verificarSePropriedadesEstaoVazias(ArrayList<Atributo> propriedadesL){

        boolean propriedadesEstaoVazias = false;

        if(propriedadesL.size() == 0){
            propriedadesEstaoVazias = true;
        }

        return propriedadesEstaoVazias;

    }

    public Atributo selecionarPropriedade(ArrayList<Investimento> investimentosL, ArrayList<Atributo> propriedadesL){

        Atributo propriedade = null;

        Entropia entropia = new Entropia(investimentosL, propriedadesL, classe);
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