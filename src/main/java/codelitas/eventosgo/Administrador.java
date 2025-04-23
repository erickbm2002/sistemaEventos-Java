package codelitas.eventosgo;

//Se crea una clase Administrador que hereda los atributos y metodos de Clase Usuario
public class Administrador extends Usuario {
    
    public Administrador(String pNombre, String pIdentificacion, String pCorreo, String IDUsuario) {
        super(pNombre, pIdentificacion, pCorreo, IDUsuario);
        this.setRollUsuario(RollUsuario.ADMINISTRADOR);
    }

    //Metodos

    //Metodo para generar eventos
    public void generarEvento(String pNombreEvento, String pUbicacionEvento, String pFechaEvento, String pHoraEvento, String pTipoEvento, int pCapacidadEvento)  {
        Evento evento = new Evento(pNombreEvento, pUbicacionEvento, pFechaEvento, pHoraEvento, pTipoEvento,
                pCapacidadEvento);
    }



}
