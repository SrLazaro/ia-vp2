import java.util.ArrayList;

public class Entropia {
    
    private ArrayList<Investimento> investimentos = new ArrayList<Investimento>();
    private ArrayList<Atributo> propriedades = new ArrayList<Atributo>();
    private Atributo classe;
    private double entropiaClasse;
    private ArrayList<GanhoInformacao> ganhosInformacao = new ArrayList<GanhoInformacao>();
    private Atributo melhorPropriedade;

    public Entropia(ArrayList<Investimento> investimentos, ArrayList<Atributo> propriedades, Atributo classe) {
        this.investimentos = investimentos;
        this.propriedades = propriedades;
        this.classe = classe;
        this.entropiaClasse = 0;
    }

    public void iniciar(){

        calcularEntropiaDaClasse();
        calcularEntropiasDasPropriedades();
        verificarMelhorGanhoInformacao();

    }

    private void verificarMelhorGanhoInformacao() {

        GanhoInformacao melhorGanhoInformacao = null;

        for (GanhoInformacao ganhoInformacao : ganhosInformacao) {

            if(melhorGanhoInformacao == null){
                melhorGanhoInformacao = ganhoInformacao;
            }else if(melhorGanhoInformacao.getGanho() >
                    ganhoInformacao.getGanho()){
                melhorGanhoInformacao = ganhoInformacao;
            }

        }

        this.melhorPropriedade = melhorGanhoInformacao.getPropriedade();

    }

    private void calcularEntropiasDasPropriedades() {

        double entropiaPropriedade, ganho = 0;

        for (Atributo propriedade : propriedades) {

            entropiaPropriedade = calcularEntropiaDaPropriedade(propriedade);
            ganho = entropiaClasse - entropiaPropriedade;
            ganhosInformacao.add(new GanhoInformacao(propriedade, entropiaPropriedade, ganho));        
            
        }
    }

    private double calcularEntropiaDaPropriedade(Atributo propriedade) {

        double valorEntropia, valorPonderado, qtdRegistros, mediaPonderada = 0;

        ArrayList<Registro> registrosSumarizado = new ArrayList<Registro>();
        registrosSumarizado = Sumarizador.sumarizarValoresAtributo(propriedade, investimentos);        

        qtdRegistros = investimentos.size();

        for (Registro registroSumarizado : registrosSumarizado) {
            
            valorEntropia = calcularEntropiaDoAtributo(registroSumarizado.getInvestimentos());
            valorPonderado = valorEntropia * registroSumarizado.getInvestimentos().size();
            mediaPonderada += valorPonderado;

        }

        mediaPonderada = Calculadora.dividir(mediaPonderada, qtdRegistros);

        return mediaPonderada;
    }


    public void calcularEntropiaDaClasse(){

        this.entropiaClasse = calcularEntropiaDoAtributo(investimentos);

    }

    public double calcularEntropiaDoAtributo(ArrayList<Investimento> investimentosL){

        double valorEntropia = 0;

        ArrayList<Registro> registrosSumarizado = new ArrayList<Registro>();
        registrosSumarizado = Sumarizador.sumarizarValoresAtributo(classe, investimentosL);
        valorEntropia = calcularValorEntropia(registrosSumarizado);

        return valorEntropia;

    }

    private double calcularValorEntropia(ArrayList<Registro> registrosSumarizado) {
        
        double valorEntropiaSumarizada = 0;
        double fracao = 0;
        double log = 0;
        double valorEntropia = 0;

        int totalRegistros = 0;

        for (Registro registro : registrosSumarizado) {
            totalRegistros += registro.getQuantidade();
        }

        try {
            for (Registro registro : registrosSumarizado) {
                
                int quantidade = registro.getQuantidade();
                fracao = Calculadora.dividir(quantidade, totalRegistros);
                log = Calculadora.log(2, fracao);
                valorEntropia = ( (fracao * -1) * log );
                
                if(valorEntropiaSumarizada == 0){
                    valorEntropiaSumarizada = valorEntropia;
                }else{
                    valorEntropiaSumarizada += valorEntropia;
                }
    
            }  
        } catch (Exception e) {
            System.out.println("Erro ao realizar cálculo da Entropia");
        }

        return valorEntropiaSumarizada;

    }


    public ArrayList<Investimento> getInvestimentos() {
        return investimentos;
    }

    public void setInvestimentos(ArrayList<Investimento> investimentos) {
        this.investimentos = investimentos;
    }

    public ArrayList<Atributo> getPropriedades() {
        return propriedades;
    }

    public void setPropriedades(ArrayList<Atributo> propriedades) {
        this.propriedades = propriedades;
    }

    public Atributo getClasse() {
        return classe;
    }

    public void setClasse(Atributo classe) {
        this.classe = classe;
    }

    public double getEntropiaClasse() {
        return entropiaClasse;
    }

    public void setEntropiaClasse(double entropiaClasse) {
        this.entropiaClasse = entropiaClasse;
    }

    public ArrayList<GanhoInformacao> getGanhosInformacao() {
        return ganhosInformacao;
    }

    public void setGanhosInformacao(ArrayList<GanhoInformacao> ganhosInformacao) {
        this.ganhosInformacao = ganhosInformacao;
    }

    public Atributo getMelhorPropriedade() {
        return melhorPropriedade;
    }

    public void setMelhorPropriedade(Atributo melhorPropriedade) {
        this.melhorPropriedade = melhorPropriedade;
    }

}
