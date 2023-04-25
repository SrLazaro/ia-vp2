import java.lang.reflect.Method;
import java.util.ArrayList;

import Tipos.Divida;

public class BuscadorValorAtributo {

    private static String getDescricao = "getDescricao";
    private static String getListaAtributos = "getListaAtributos";

    public static String retornarValor(Atributo atributo, Investimento investimento){
        
        String valor = null;

        try {
            // Criando a classe do Atributo
            Object atributoL;

            // Resgatando o Atributo
            Method getMetodoAtributo = investimento.getClass().getMethod(atributo.getNomeMetodo());
            atributoL = getMetodoAtributo.invoke(investimento);

            // Retornando valor
            Method getMetodoDescricao = atributoL.getClass().getMethod(getDescricao);
            valor = (String) getMetodoDescricao.invoke(atributoL);

            
        } catch (Exception e) {
            System.out.println("Erro ao executar método");
        }

        return valor;
    }

    public static ArrayList<String> retornarLista(Atributo atributo) {

        ArrayList<String> listaValores = new ArrayList<String>();

        try {
            // Criando a classe do Atributo
            Object atributoL;

            // Resgatando a Classe
            Class<?> atributoClasse = Class.forName(atributo.getNomeClasse());

            // Retornando Lista com Valores 
            Method getMetodoDescricao = atributoClasse.getMethod(getListaAtributos);
            listaValores = (ArrayList<String>) getMetodoDescricao.invoke(null);

            
        } catch (Exception e) {
            System.out.println("Erro ao executar método");
        }

        return listaValores;
    }
    
}
