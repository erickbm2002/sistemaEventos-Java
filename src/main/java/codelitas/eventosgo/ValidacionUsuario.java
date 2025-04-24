package codelitas.eventosgo;

import java.util.ArrayList;

class ValidacionUsuario {

    public static void main(String[] args) {
        MostrarMensajes mensajes = new MostrarMensajes();
        ListasSistemaEvento lista = new ListasSistemaEvento();
        ControlCreaciones controlCreaciones = new ControlCreaciones();
        ValidacionUsuario validacionUsuario = new ValidacionUsuario(lista, mensajes, controlCreaciones);

        Cliente cliente = new Cliente(null, "118580448", null);
        lista.agregarClienteLista(cliente);
        System.out.println(validacionUsuario.validarInicioSesion("118580448", "USR-001"));

    }

    // Atributos
    private ListasSistemaEvento lista;
    private MostrarMensajes mensajes;
    private ControlCreaciones controlCreaciones;
    private int usuariosMaximos = 200;
    private int eventosMaximos = 1;

    // Constructor
    public ValidacionUsuario(ListasSistemaEvento pLista, MostrarMensajes pMensajes,
            ControlCreaciones pControlCreaciones) {
        this.lista = pLista;
        this.mensajes = pMensajes;
        this.controlCreaciones = pControlCreaciones;

    }

    // METODOS
    ///Metodo para validar la cantidad de objetos creados
    // Validamos que no se haya superado el limite maximo de usuarios en el sistema.
    public boolean validarCantidadUsuarios() {
        int cantidadUsuarios = this.controlCreaciones.getControlUsuarios();
        if (cantidadUsuarios >= this.usuariosMaximos) {
            this.mensajes.mostrarJOptioneMessage(
                    "Se ha alcanzado el limite maximo de usuarios activos permitidos en el sistema");
            return false;
        } else {
            return true;
        }
    }

    //Validamos que no se haya superado el limite maximo de eventos en el sistema
    public boolean validarCantidadEventos() {
        int cantidadEventos = this.controlCreaciones.getControlEventos();
        if (cantidadEventos >= this.eventosMaximos) {
            this.mensajes.mostrarJOptioneMessage(
                    "Se ha alcanzado el limite maximo de eventos activos permitidos en el sistema");
            return false;
        } else {
            return true;
        }
    }


    //Metodos para validar accesos de 
    public boolean validarUsuarioExistente(String identifiacion) {
        if (this.lista.devolverIdentificacionListaUsuarios().contains(identifiacion)) {
            this.mensajes.mostrarJOptioneMessage("El usuario ya existe");
            return true;
        } else {
            return false;
        }

    }

    public boolean validarInicioSesion(String identificacionIngresada, String idUsuarioIngresada) {
        ArrayList<Usuario> listaUnificada = this.lista.devolverListasUsuariosUnificada();
        for (int i = 0; i < listaUnificada.size(); i++) {
            Usuario usuario = listaUnificada.get(i);
            if (usuario.getIdentificacion().equals(identificacionIngresada)
                    && usuario.getIdUsuario().equals(idUsuarioIngresada)) {
                return true;
            }
        }
        return false;
    }

    // SETTERS Y GETTERS

}