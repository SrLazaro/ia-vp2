import java.util.ArrayList;

public class BuscadorRegistro {

    public static Registro verificarSeRegistroExiste(ArrayList<Registro> registros, String valor) {

        Registro registroEncontrado = null;

        for (Registro registro : registros) {
            if(registro.getValor().equals(valor)){
                registroEncontrado = registro;
            }
        }

        return registroEncontrado;
    }
    


}
