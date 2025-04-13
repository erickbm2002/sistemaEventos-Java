package codelitas.eventosgo;

import java.util.ArrayList;

class ValidacionUsuario {

    public static void main(String[] args) {
        MostrarMensajes mensajes = new MostrarMensajes();
        ListasSistemaEvento lista = new ListasSistemaEvento();
        ControlCreaciones controlCreaciones = new ControlCreaciones();
        ValidacionUsuario validacionUsuario = new ValidacionUsuario(lista, mensajes, controlCreaciones);
        System.out.println(validacionUsuario.validarCantidadUsuarios());
    }

    

    //Atributos
    private ListasSistemaEvento lista;
    private MostrarMensajes mensajes;
    private ControlCreaciones controlCreaciones;
    private int usuariosMaximos = 3;
    private int eventosMaximos = 3;

    //Constructor
    public ValidacionUsuario(ListasSistemaEvento pLista, MostrarMensajes pMensajes, ControlCreaciones pControlCreaciones) {
        this.lista = pLista;
        this.mensajes = pMensajes;
        this.controlCreaciones = pControlCreaciones;

    }


    //METODOS
    //Validamos que no se haya superado el limite maximo de usuarios en el sistema.
    public boolean validarCantidadUsuarios() {
        int cantidadUsuarios = this.controlCreaciones.getControlUsuarios();
        if(cantidadUsuarios >= this.usuariosMaximos) {
            this.mensajes.mostrarJOptioneMessage("Se ha alcanzado el limite maximo de usuarios activos permitidos en el sistema");
            return false;
        } else {
            return true;
        }
    }

    public boolean validarUsuarioExistente(String identifiacion) {
        if (this.lista.devolverIdentificacionListaUsuarios().contains(identifiacion)) {
            this.mensajes.mostrarJOptioneMessage("El usuario ya existe");
            return true;
        } else {
            return false;
        }

    }

    public void validarInicioSesion() {
        
    }

    
    //SETTERS Y GETTERS
    
    
}