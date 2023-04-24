import java.util.ArrayList;

public class Entropia {
    
    private ArrayList<Investimento> investimentos = new ArrayList<Investimento>();
    private ArrayList<Atributo> propriedades = new ArrayList<Atributo>();
    private Atributo classe;
    private int qtdRegistro;

    public Entropia(ArrayList<Investimento> investimentos, ArrayList<Atributo> propriedades, Atributo classe) {
        this.investimentos = investimentos;
        this.propriedades = propriedades;
        this.classe = classe;
    }

    public void iniciar(){

        qtdRegistro = investimentos.size();
        calcularEntropiaDaClasse();

    }

    public void calcularEntropiaDaClasse(){

        ArrayList<Registro> registrosSumarizado = new ArrayList<Registro>();
        registrosSumarizado = sumarizarValoresAtributo(classe, investimentos);
        double entropiaClasse = calcularValorEntropia(registrosSumarizado);

        System.out.println("até aqui tá funcionando kkk");

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
                    valorEntropiaSumarizada -= valorEntropia;
                }
    
            }  
        } catch (Exception e) {
            System.out.println("Erro ao realizar cálculo da Entropia");
        }

        return valorEntropiaSumarizada;

    }

    private ArrayList<Registro> sumarizarValoresAtributo(Atributo propriedadeL,
            ArrayList<Investimento> investimentosL) {

        String valor = null;
        ArrayList<Registro> registros = new ArrayList<Registro>();
        Registro registroAchado = null;

        for (Investimento investimento : investimentosL) {

            valor = BuscadorValorAtributo.retornarValor(propriedadeL, investimento);

            registroAchado = BuscadorRegistro.verificarSeRegistroExiste(registros, valor);

            if(registroAchado != null){
                registroAchado.adicionarQuantidade();
            }else{
                registros.add(new Registro(valor, 1));
            }

        }

        return registros;

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

    public int getQtdRegistro() {
        return qtdRegistro;
    }

    public void setQtdRegistro(int qtdRegistro) {
        this.qtdRegistro = qtdRegistro;
    }

}
