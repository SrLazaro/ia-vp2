import java.lang.reflect.Method;

public class BuscadorValorAtributo {

    private static String getDescricao = "getDescricao";

    public static String retornarValor(Atributo atributo, Investimento investimento){
        
        String valor = null;

        try {
            // Criando a classe do Atributo
            Object atributoL;

            // Resgatando o Atributo
            Method getMetodoPropriedade = investimento.getClass().getMethod(atributo.getNomeMetodo());
            atributoL = getMetodoPropriedade.invoke(investimento);

            // Retornando valor
            Method getMetodoDescricao = atributoL.getClass().getMethod(getDescricao);
            valor = (String) getMetodoDescricao.invoke(atributoL);

            
        } catch (Exception e) {
            System.out.println("Erro ao executar método");
        }

        return valor;
    }
    
}
