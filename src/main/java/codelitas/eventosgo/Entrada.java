package codelitas.eventosgo;

public class Entrada {
    private String idEntrada;
    private String usuario;
    private String evento;
    private boolean usada;

    public Entrada(String idEntrada, String usuario, String evento) {
        this.idEntrada = idEntrada;
        this.usuario = usuario;
        this.evento = evento;
        this.usada = false;
    }


    public boolean validarEntrada() {
        return !usada;
    }

    public void entradaUsada() {
        if (!usada) {
            usada = true;
        } else {
            System.out.println("La entrada ya fue vendida");
        }
    }

    public String detallesEntrada() {
        return "ID " + idEntrada + "\n" +
                "Usuario " + usuario + "\n" +
                "Evento " + evento + "\n" +
                "Usada " + (usada ? "Si" : "No");
    }

    public String getIdEntrada() {
        return idEntrada;
    }

    public String getUsuario() {
        return usuario;
    }

    public String getEvento() {
        return evento;
    }

    public boolean isUsada() {
        return usada;
    }

}
