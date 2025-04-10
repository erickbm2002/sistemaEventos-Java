package codelitas.eventosgo;
import javax.swing.JOptionPane;

//Clae que va almacenar todo los menus del sistema
public class MenuSistema {

    public static void main(String[] args) {
        MostrarMensajes mensajes = new MostrarMensajes();
        ListasSistemaEvento listas = new ListasSistemaEvento();
        ValidacionUsuario validacionUsuario = new ValidacionUsuario(listas, mensajes);
        MenuSistema menu = new MenuSistema(mensajes, listas, validacionUsuario);
        menu.opcionSeleccionada = menu.mostrarMenuPrincipal();
        menu.mostrarMenuLogin(menu.opcionSeleccionada);

    }

    //Atributos
    // Array con las opciones del menu principañ
    private String[] opcionesMenu = { "Iniciar Sesión", "Registrarse" };
    // Se crea un array para las opciones de acceso que tendran los Usuarios y los
    // admin
    private String[] opcionesMenuAdmin = { "Crear Evento", "Crear Administrador", "Mostar Reportes",
            "Gestionar Eventos",
            "Gestionar Usuarios" };
    int opcionSeleccionada;
    //Recibimos una instancia de la clase MostrarMensajes
    private MostrarMensajes mensajes;
    private ListasSistemaEvento listas;
    private ValidacionUsuario validacionUsuario;

    //Constructor
    public MenuSistema(MostrarMensajes pmensajes, ListasSistemaEvento pListas, ValidacionUsuario pValidacionUsuario) {
        this.mensajes = pmensajes;
        this.listas = pListas;
        this.validacionUsuario = pValidacionUsuario;
    }

    // Se muestra el menú principal
    public int mostrarMenuPrincipal() {
        do {
            return this.mensajes.mostrarJOptioneInputOpciones("Login", opcionesMenu, 0);
        } while (this.opcionSeleccionada < 0);

    }

    //Se muestra el menú del login
    public void mostrarMenuLogin(int opcionSeleccionada) {

        switch (opcionSeleccionada) {
            case 0:
                this.mensajes.mostrarJOptioneMessage("Ha ingresado a Iniciar Sesion");
                break;

            case 1:
                this.mensajes.mostrarJOptioneMessage("Ha ingresado a Registra");
                this.registrarUsuario();

            case -1:
                this.mensajes.mostrarJOptioneMessage("Saliendo del Sistema");

                break;

            default:
                break;
        }
    }

    //Se muestra las entradas de texto para crear usuarios
    public void registrarUsuario() {

        String identificacionUsuario = mensajes.mostrarJOptioneInput("Ingrese la identificación");
        Boolean usuarioExiste = validacionUsuario.validarUsuarioExistente(identificacionUsuario);
        if (!usuarioExiste) {
            String nombreUsuario = mensajes.mostrarJOptioneInput("Ingrese su nombre");
            String correoUsuario = mensajes.mostrarJOptioneInput("Ingrese su correo");
            Cliente cliente = new Cliente(nombreUsuario, identificacionUsuario, correoUsuario,
                    GenerarID.generarID("USR"));
            listas.agregarClienteLista(cliente);
        } else {
            mensajes.mostrarJOptioneMessage("Regresando al menú anterior");
        }

    }

    //Getter y setter
    public int opcionSeleccionada() {
        return this.opcionSeleccionada;
    }
}


