public class GanhoInformacao {
    
    Atributo propriedade;
    double entropia;
    double ganho;

    public GanhoInformacao(Atributo propriedade, double entropia, double ganho) {
        this.propriedade = propriedade;
        this.entropia = entropia;
        this.ganho = ganho;
    }
    public Atributo getPropriedade() {
        return propriedade;
    }
    public void setPropriedade(Atributo propriedade) {
        this.propriedade = propriedade;
    }
    public double getEntropia() {
        return entropia;
    }
    public void setEntropia(double entropia) {
        this.entropia = entropia;
    }
    public double getGanho() {
        return ganho;
    }
    public void setGanho(double ganho) {
        this.ganho = ganho;
    }

    //

    

}
