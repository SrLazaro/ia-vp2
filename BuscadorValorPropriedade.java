import java.lang.reflect.Method;

public class BuscadorValorPropriedade {

    private static String getDescricao = "getDescricao";

    public static String retornarValor(Propriedade propriedade, Investimento investimento){
        
        String valor = null;

        try {
            // Criando a classe da Propriedade
            Object propriedadeL;

            // Resgatando a Propriedade
            Method getMetodoPropriedade = investimento.getClass().getMethod(propriedade.getNomeMetodo());
            propriedadeL = getMetodoPropriedade.invoke(investimento);

            // Retornando valor
            Method getMetodoDescricao = propriedadeL.getClass().getMethod(getDescricao);
            valor = (String) getMetodoDescricao.invoke(propriedadeL);

            
        } catch (Exception e) {
            System.out.println("Erro ao executar método");
        }

        return valor;
    }
    
}
