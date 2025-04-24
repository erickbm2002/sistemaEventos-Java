package codelitas.eventosgo;

public class ControlCreaciones {
    private int controlUsuarios = 0;
    private int controlEventos = 0;
    private int controlEntradas = 0;

    //CONSTRUCTORES
    //Metodo vacio
    public ControlCreaciones() {

    }

    public ControlCreaciones(int entradasMaximas) {
        this.controlEntradas = entradasMaximas;
    }


    //GETTER Y SETTER
    public int getControlUsuarios() {
        return controlUsuarios;
    }

    public void setControlUsuarios() {
        this.controlUsuarios++;
    }

    public int getControlEventos() {
        return controlEventos;
    }

    public void setControlEventos() {
        this.controlEventos++;
    }

    public int getControlEntradas() {
        return controlEntradas;
    }

    public void setControlEntradas(int controlEntradas) {
        this.controlEntradas = controlEntradas;
    }

}
