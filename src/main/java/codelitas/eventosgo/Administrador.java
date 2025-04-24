package codelitas.eventosgo;

//Se crea una clase Administrador que hereda los atributos y metodos de Clase Usuario
public class Administrador extends Usuario {

    //ATRIBUTS PRPOPIOS
    
    
    
    public Administrador(String pNombre, String pIdentificacion, String pCorreo) {
        super(pNombre, pIdentificacion, pCorreo, GenerarID.generarID("ADM"));
    }

    //Metodos

    //Metodo para generar eventos
    public Evento generarEvento(String pNombreEvento, String pUbicacionEvento, String pFechaEvento, String pHoraEvento,
            String pTipoEvento, int pCapacidadEvento) {
        Evento evento = new Evento(pNombreEvento, pUbicacionEvento, pFechaEvento, pHoraEvento, pTipoEvento,
                pCapacidadEvento);
        return evento;
    }
    
    //Metodo par cread admin

    public Administrador generarAdmin(String pNombre, String pIdentificacion, String pCorreo) {
        Administrador administrador = new Administrador(pNombre, pIdentificacion, pCorreo);
        return administrador;
    }

    public void mostrarEventos(ListasSistemaEvento listas) {
        Usuario.mensajes.mostrarJOptioneMessage(Usuario.reportes.generarReporteEventos(listas).toString());
    }

    public void mostrarUsuarios(ListasSistemaEvento listas) {
        Usuario.mensajes.mostrarJOptioneMessage(Usuario.reportes.generarReporteUsuarios(listas).toString());
    }



}
