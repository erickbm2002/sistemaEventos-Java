package codelitas.eventosgo;

//Clae que va almacenar todo los menus del sistema
public class MenuSistema {

    public static void main(String[] args) {
        MostrarMensajes mensajes = new MostrarMensajes();
        ListasSistemaEvento listas = new ListasSistemaEvento();
        ControlCreaciones controlCreaciones = new ControlCreaciones();
        ValidacionUsuario validacionUsuario = new ValidacionUsuario(listas, mensajes, controlCreaciones);
        MenuSistema menu = new MenuSistema(mensajes, listas, validacionUsuario, controlCreaciones);
        /* menu.mostrarMenuUsuarios("adm"); */
        /* menu.mostrarIniciarSesion(); */
        menu.menuGenerarEvento();

    }

    // Atributos
    // Array con las opciones del menu principañ
    private String[] opcionesMenu = { "Iniciar Sesión", "Registrarse" };
    // Se crea un array para las opciones de acceso que tendran los Usuarios y los
    // admin
    private String[] opcionesMenuAdmin = { "Crear Evento", "Crear Administrador", "Mostar Reportes",
            "Gestionar Eventos",
            "Gestionar Usuarios" };
    private String[] opcionesMenuCliente = { "Comprar Entrada", "Mostrar Eventos", "Editar Entrada" };
    // Generamos instacias de otras clases que se van a ocupar
    private MostrarMensajes mensajes;
    private ListasSistemaEvento listas;
    private ValidacionUsuario validacionUsuario;
    private ControlCreaciones controlCreaciones;

    // Constructor
    public MenuSistema(MostrarMensajes pmensajes, ListasSistemaEvento pListas, ValidacionUsuario pValidacionUsuario,
            ControlCreaciones pControlCreaciones) {
        this.mensajes = pmensajes;
        this.listas = pListas;
        this.validacionUsuario = pValidacionUsuario;
        this.controlCreaciones = pControlCreaciones;
    }

    // Se muestra el menú principal
    public int mostrarMenuPrincipal() {
        return this.mensajes.mostrarJOptioneInputOpciones("Login", this.opcionesMenu, 0);
    }

    // Se muestra el menú del login
    public void mostrarMenuLogin() {
        int opcionSeleccionada;
        do {
            opcionSeleccionada = this.mostrarMenuPrincipal();
            switch (opcionSeleccionada) {
                case 0:
                    this.mensajes.mostrarJOptioneMessage("Ha ingresado a Iniciar Sesion");
                    this.mostrarIniciarSesion();
                    break;

                case 1:
                    this.mensajes.mostrarJOptioneMessage("Ha ingresado a Registrarse");
                    this.registrarUsuario();
                    break;

                case -1:
                    this.mensajes.mostrarJOptioneMessage("Saliendo del Sistema");
                    break;

                default:
                    break;
            }
        } while (opcionSeleccionada != -1);

    }
 
    //METODOS PARA MOSTRAR INFORMACION

    // Se crea los input para el inicio de sesion
    public void mostrarIniciarSesion() {
        int intentos = 3;

        do {
            String identificacionIngresada = this.mensajes.mostrarJOptioneInput("Ingrese la identifación");
            String idUsuario = this.mensajes.mostrarJOptioneInput("Ingrese el ID-USUARIO").toUpperCase();
            if (this.validacionUsuario.validarInicioSesion(identificacionIngresada, idUsuario)) {
                this.mensajes.mostrarJOptioneMessage("Acceso Permitido");
                return;
            } else {
                this.mensajes.mostrarJOptioneMessage("Datos incorrectos\n Intentelo de nuevo");
                intentos--;

            }
            System.out.println(intentos);
        } while (intentos != 0);
        if (intentos <= 0) {
            this.mensajes.mostrarJOptioneMessage("LIMITE DE INTENTOS ALCANZADOS VOLVIENDO AL MENU PRINCIPAL");
        }

    }

    // Se crea metodo para mostrar los menus de los usuarios dependiendo del tipo
    public void mostrarMenuUsuarios(String tipoUsuario) {
        if (tipoUsuario.toUpperCase().contains("USR")) {
            this.mensajes.mostrarJOptioneInputOpciones("MENU CLIENTES", this.opcionesMenuCliente, 0);
        } else if (tipoUsuario.toUpperCase().contains("ADM")) {
            this.mensajes.mostrarJOptioneInputOpciones("MENU ADMINISTRADOR", this.opcionesMenuAdmin, 0);
        } else {
            this.mensajes.mostrarJOptioneMessage("ERROR");
        }
    }

    // Se genera un metodo para imprimir la informacion la informaicon del cliente
    // mostrado
    public StringBuilder mostrarDatosUsuarioCreado(Cliente cliente) {
        StringBuilder texto = this.mensajes.StringBuilder();
        texto.append("Usuario creado exitosamente");
        texto.append("\n");
        texto.append("Nombre:").append(cliente.getNombre());
        texto.append("\n");
        texto.append("Identificación:").append(cliente.getIdentificacion());
        texto.append("\n");
        texto.append("ID Usuario:").append(cliente.getIdUsuario());
        texto.append("\n");
        texto.append("Nota:El ID-USUARIO es necesario para el inicio de Sesion");
        return texto;
    }

    public StringBuilder mostrarDatosEventoCreado(Evento evento) {
        StringBuilder texto = this.mensajes.StringBuilder();
        texto.append("Evento Creado exitosamente");
        texto.append("\n");
        texto.append("Nombre del evento: ").append(evento.getNombreEvento());
        texto.append("\n");
        texto.append("Id Evento: ").append(evento.getIdEvento());
        texto.append("\n");
        texto.append("Ubicación del Evento: ").append(evento.getUbicacionEvento());
        texto.append("\n");
        texto.append("Fecha y Hora del Evento: ").append(evento.getFecha()).append(" ").append(evento.getHora());
        texto.append("\n");
        texto.append("Tipo de Evento").append(evento.getTipoEvento());
        texto.append("\n");
        texto.append("Capacidad del evento").append(evento.getCapacidadMaximaEvento());
        return texto;
    }

    // Metodo que generan acciones en los menu
    // Se muestra las entradas de texto para crear usuarios
    public void registrarUsuario() {
        if (this.validacionUsuario.validarCantidadUsuarios()) {
            String identificacionUsuario = mensajes.mostrarJOptioneInput("Ingrese la identificación");
            Boolean usuarioExiste = validacionUsuario.validarUsuarioExistente(identificacionUsuario);
            if (!usuarioExiste) {
                String nombreUsuario = mensajes.mostrarJOptioneInput("Ingrese su nombre");
                String correoUsuario = mensajes.mostrarJOptioneInput("Ingrese su correo");
                Cliente cliente = new Cliente(nombreUsuario, identificacionUsuario, correoUsuario,
                        GenerarID.generarID("USR"));
                this.listas.agregarClienteLista(cliente);
                this.controlCreaciones.setControlUsuarios();
                StringBuilder texto = this.mostrarDatosUsuarioCreado(cliente);
                this.mensajes.mostrarJOptioneMessage(texto.toString());
                this.mensajes.eliminarMensaje(texto);

            } else {
                mensajes.mostrarJOptioneMessage("Regresando al menú anterior");
            }
        }

    }

    // Se muestra las entradas de texto para crear Eventos
    public void menuGenerarEvento() {
        String nombreEvento = this.mensajes.mostrarJOptioneInput("Ingrese el nombre del Evento");
        int seleccionUbicacion = this.mensajes.mostrarJOptioneInputOpciones("Ubicaciones Disponibles",this.obtenerUbicacionesComoString() ,
                0);
        System.out.println(nombreEvento);
        System.out.println(seleccionUbicacion);
    }

    //Metodos para obtener informacion 
    private String[] obtenerUbicacionesComoString() {
        Evento.UbicacionesEvento[] ubicaciones = Evento.getUbicacionesEvento();
        String[] ubicacionesStr = new String[ubicaciones.length];
        for (int i = 0; i < ubicaciones.length; i++) {
            ubicacionesStr[i] = ubicaciones[i].name().replace("_", " ");
        }
        return ubicacionesStr;
    }

}
