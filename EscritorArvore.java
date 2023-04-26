public class EscritorArvore {

    private static String tab = "  |  ";

    public static void exibirArvore(No no){

        escreverNo(no, tab);
        
    }

    private static void escreverNo(No no, String espacamento){

        System.out.println(espacamento + no.getValor());
        espacamento = espacamento + tab;

        if(no.getNos() != null && no.getNos().size() != 0){
            for (No noLocal : no.getNos()) {
                escreverNo(noLocal, espacamento);
            }
        }

    }

}
