public class Atributo {
    
    private String nome;
    private String nomeClasse;
    private String nomeMetodo;

    public Atributo(String nome, String nomeMetodo, String nomeClasse) {
        this.nome = nome;
        this.nomeClasse = nomeClasse;
        this.nomeMetodo = nomeMetodo;
    }

    public Atributo(String nome) {
        this.nome = nome;
        this.nomeClasse = "Tipos." + nome;
        this.nomeMetodo = "get" + nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeClasse() {
        return nomeClasse;
    }

    public void setNomeClasse(String nomeClasse) {
        this.nomeClasse = nomeClasse;
    }

    public String getNomeMetodo() {
        return nomeMetodo;
    }

    public void setNomeMetodo(String nomeMetodo) {
        this.nomeMetodo = nomeMetodo;
    }

}
