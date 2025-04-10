package codelitas.eventosgo;

//Se crea una clase cliente que hereda los atributos y metodos de Clase Usuario
public class Cliente extends Usuario {
    
    public Cliente(String pNombre, String pIdentificacion, String pCorreo, String IDUsuario) {
        super(pNombre, pIdentificacion, pCorreo, IDUsuario);
        this.setRollUsuario(RollUsuario.CLIENTE);
    }
}
