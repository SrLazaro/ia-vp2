import java.util.ArrayList;

public class No {
    
    private String valor;
    private ArrayList<No> nos = new ArrayList<No>();

    public No() {
    }

    public No(String valor) {
        this.valor = valor;
    }

    public No(String valor, ArrayList<No> nos) {
        this.valor = valor;
        this.nos = nos;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    public ArrayList<No> getNos() {
        return nos;
    }

    public void setNos(ArrayList<No> nos) {
        this.nos = nos;
    }

    public void adicionarNo(No no) {
        this.nos.add(no);
    }

}
