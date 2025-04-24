package codelitas.eventosgo;

public class Usuario {
    private String nombre;
    private String identificacion;
    private String correo;
    private String idUsuario;
  
    //Constructor
    public Usuario(String pNombre, String pidentificacion, String pcorreo, String pidUsuario) {
        this.nombre = pNombre;
        this.identificacion = pidentificacion;
        this.correo = pcorreo;
        this.idUsuario = pidUsuario;
    }

    public Usuario() {
        
    }

    



    // metodos
    public void mostrarDatos() {

    }

    //sin usar
    public void comprarEntrada() {

    }

    // getters y setters
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
        this.identificacion = identificacion;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }


    
    

    

}
