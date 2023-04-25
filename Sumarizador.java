import java.util.ArrayList;

public class Sumarizador {
    
    public static ArrayList<Registro> sumarizarValoresAtributo(Atributo propriedadeL,
    ArrayList<Investimento> investimentosL) {

        String valor = null;
        ArrayList<Registro> registros = new ArrayList<Registro>();
        Registro registroAchado = null;

        for (Investimento investimento : investimentosL) {

            valor = BuscadorValorAtributo.retornarValor(propriedadeL, investimento);

            registroAchado = BuscadorRegistro.verificarSeRegistroExiste(registros, valor);

            if(registroAchado != null){
                registroAchado.adicionarQuantidade();
                registroAchado.adicionarInvestimento(investimento);
            }else{
                registros.add(new Registro(valor, 1, investimento));
            }

        }

        return registros;

    }

}
