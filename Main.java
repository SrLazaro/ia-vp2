import java.util.ArrayList;

import Tipos.Divida;
import Tipos.Garantia;
import Tipos.HistoriaDeCredito;
import Tipos.Renda;
import Tipos.Risco;

public class Main{

    public static ArrayList<Investimento> investimentos = new ArrayList<Investimento>();
    public static Id3 id3;
    public static No no;

    public static void main(String[] args) {

        criarHistoricoDeInvestimentos();
        id3 = new Id3(investimentos);
        no = id3.iniciar();

        EscritorArvore.exibirArvore(no);

    }

    public static void criarHistoricoDeInvestimentos(){

        investimentos.add(new Investimento(Risco.ALTO, HistoriaDeCredito.RUIM, Divida.ALTA, Garantia.NENHUMA, Renda.BAIXA));
        investimentos.add(new Investimento(Risco.ALTO, HistoriaDeCredito.DESCONHECIDA, Divida.ALTA, Garantia.NENHUMA, Renda.MEDIA));
        investimentos.add(new Investimento(Risco.MODERADO, HistoriaDeCredito.DESCONHECIDA, Divida.BAIXA, Garantia.NENHUMA, Renda.MEDIA));
        investimentos.add(new Investimento(Risco.ALTO, HistoriaDeCredito.DESCONHECIDA, Divida.BAIXA, Garantia.NENHUMA, Renda.BAIXA));
        investimentos.add(new Investimento(Risco.BAIXO, HistoriaDeCredito.DESCONHECIDA, Divida.BAIXA, Garantia.NENHUMA, Renda.ALTA));
        investimentos.add(new Investimento(Risco.BAIXO, HistoriaDeCredito.DESCONHECIDA, Divida.BAIXA, Garantia.ADEQUADA, Renda.ALTA));
        investimentos.add(new Investimento(Risco.ALTO, HistoriaDeCredito.RUIM, Divida.BAIXA, Garantia.NENHUMA, Renda.BAIXA));
        investimentos.add(new Investimento(Risco.MODERADO, HistoriaDeCredito.RUIM, Divida.BAIXA, Garantia.ADEQUADA, Renda.ALTA));
        investimentos.add(new Investimento(Risco.BAIXO, HistoriaDeCredito.BOA, Divida.BAIXA, Garantia.NENHUMA, Renda.ALTA));
        investimentos.add(new Investimento(Risco.BAIXO, HistoriaDeCredito.BOA, Divida.ALTA, Garantia.ADEQUADA, Renda.ALTA));
        investimentos.add(new Investimento(Risco.ALTO, HistoriaDeCredito.BOA, Divida.ALTA, Garantia.NENHUMA, Renda.BAIXA));
        investimentos.add(new Investimento(Risco.MODERADO, HistoriaDeCredito.BOA, Divida.ALTA, Garantia.NENHUMA, Renda.MEDIA));
        investimentos.add(new Investimento(Risco.BAIXO, HistoriaDeCredito.BOA, Divida.ALTA, Garantia.NENHUMA, Renda.ALTA));
        investimentos.add(new Investimento(Risco.ALTO, HistoriaDeCredito.RUIM, Divida.ALTA, Garantia.NENHUMA, Renda.MEDIA));
    
    }

}
