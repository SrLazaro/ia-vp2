import Tipos.Divida;
import Tipos.Garantia;
import Tipos.HistoriaDeCredito;
import Tipos.Renda;
import Tipos.Risco;

public class Investimento {
    
    private Risco risco;
    private HistoriaDeCredito historiaDeCredito;
    private Divida divida;
    private Garantia garantia;
    private Renda renda;

    public Investimento(Risco risco, HistoriaDeCredito historiaDeCredito, Divida divida, Garantia garantia,
            Renda renda) {
        this.risco = risco;
        this.historiaDeCredito = historiaDeCredito;
        this.divida = divida;
        this.garantia = garantia;
        this.renda = renda;
    }

    public Risco getRisco() {
        return risco;
    }

    public void setRisco(Risco risco) {
        this.risco = risco;
    }

    public Divida getDivida() {
        return divida;
    }

    public void setDivida(Divida divida) {
        this.divida = divida;
    }

    public Garantia getGarantia() {
        return garantia;
    }

    public void setGarantia(Garantia garantia) {
        this.garantia = garantia;
    }

    public Renda getRenda() {
        return renda;
    }

    public void setRenda(Renda renda) {
        this.renda = renda;
    }

    public HistoriaDeCredito getHistoriaDeCredito() {
        return historiaDeCredito;
    }

    public void setHistoriaDeCredito(HistoriaDeCredito historiaDeCredito) {
        this.historiaDeCredito = historiaDeCredito;
    }    

}
