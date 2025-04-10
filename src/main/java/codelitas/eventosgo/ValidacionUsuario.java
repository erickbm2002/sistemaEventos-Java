package codelitas.eventosgo;

import java.util.ArrayList;

class ValidacionUsuario {

    public static void main(String[] args) {
        MostrarMensajes mensajes = new MostrarMensajes();
        ListasSistemaEvento lista = new ListasSistemaEvento();
        ValidacionUsuario validacionUsuario = new ValidacionUsuario(lista, mensajes);
        Cliente cliente1 = new Cliente(null, "118580448", null, null);
        lista.agregarClienteLista(cliente1);
        System.out.println(validacionUsuario.validarUsuarioExistente("11454"));
    }

    //Atributos
    
    private String claveAdmin = "Admin1234";
    private int intentosClaveAdmin = 1;
    int intentosMaximos = 3;
    private ListasSistemaEvento lista;
    private MostrarMensajes mensajes;
    private ControlCreaciones controlCreaciones;

    //Constructor
    public ValidacionUsuario(ListasSistemaEvento pLista, MostrarMensajes pMensajes) {
        this.lista = pLista;
        this.mensajes = pMensajes;

    }


    //METODOS
    //Metodo para validar si el usuario tiene acceso a crear un usuario admin
    public boolean autorizarCrearAdmin(String contraseniaIngresada, StringBuilder mensaje, MostrarMensajes menuSistema) {
        boolean acceso = false;
        while (this.intentosClaveAdmin <= 4) {
            //Se valida si alcanzó el limite de intento para mostrar el mensaje
            if (this.intentosClaveAdmin > intentosMaximos) {
                mensaje.append(" Limite de intentos alcanzados volviendo al menú principal\n");
                menuSistema.mostrarJOptioneMessage(mensaje.toString());
                return false;
            }
            //Si la clave es correcta ingresa al if en caso contrario se vuelve a validar en un total de 3 intentos
            if (contraseniaIngresada.equals(this.claveAdmin)) {
            mensaje.replace(0, mensaje.length(), "Acceso validado");
            menuSistema.mostrarJOptioneMessage(mensaje.toString());
            return true;
        } else {
            mensaje.replace(0, mensaje.length(), "Contraseña incorrecta, intente de nuevo");
            mensaje.append("\nIntento ").append(this.intentosClaveAdmin).append(" de ")
                    .append(this.intentosMaximos);
            menuSistema.mostrarJOptioneInput(mensaje.toString());
            this.setIntentosClaveAdmin();
        }
            System.out.println(this.intentosClaveAdmin);

        }
        
        return acceso;
  

    }
    
    public void validarCantidadUsuarios() {
        
    }

    public boolean validarUsuarioExistente(String identifiacion) {
        if (this.lista.devolverIdentificacionListaUsuarios().contains(identifiacion)) {
            this.mensajes.mostrarJOptioneMessage("El usuario ya existe");
            return true;
        } else {
            return false;
        }

    }

    
    //SETTERS Y GETTERS
    public void setIntentosClaveAdmin() {
        this.intentosClaveAdmin++;
    }
    
}