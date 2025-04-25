package codelitas.eventosgo;

public class Entrada {
    private String idEntrada;
    private String evento;
    private boolean usada = false;

    public Entrada() {
        this.idEntrada = GenerarID.generarID("TKT");
        this.usada = false;
    }

    public String getIdEntrada() {
        return idEntrada;
    }


    public boolean isUsada() {
        return usada;
    }

    public void setEvento(String nombreEvento) {
        this.evento = nombreEvento;
    }

    public String getEvento () {
        return this.evento;
    }

    public void setUsada() {
        this.usada = true;
    }

}
