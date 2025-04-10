package codelitas.eventosgo;

//Se crea una clase Administrador que hereda los atributos y metodos de Clase Usuario
public class Administrador extends Usuario {
    
    public Administrador(String pNombre, String pIdentificacion, String pCorreo, String IDUsuario) {
        super(pNombre, pIdentificacion, pCorreo, IDUsuario);
        this.setRollUsuario(RollUsuario.ADMINISTRADOR);
    }



}
