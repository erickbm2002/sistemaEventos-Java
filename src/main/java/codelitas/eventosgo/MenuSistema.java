package codelitas.eventosgo;

import java.util.ArrayList;
import java.util.spi.ResourceBundleProvider;

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
        menu.mostrarMenuPrincipal();

    }

    // Atributos
    // Array con las opciones del menu principañ
    private String[] opcionesMenu = { "Iniciar Sesión", "Registrarse" };
    // Se crea un array para las opciones de acceso que tendran los Usuarios y los
    // admin
    private String[] opcionesMenuAdmin = { "Crear Evento", "Crear Administrador", "Mostrar Reportes",
            "Gestionar Eventos",
            "Gestionar Usuarios" };
    private String[] opcionesMenuCliente = { "Comprar Entrada", "Mostrar Eventos", "Asistir Evento" };
    private String usuarioActual;
    // Generamos instacias de otras clases que se van a ocupar
    private MostrarMensajes mensajes;
    private ListasSistemaEvento listas;
    private ValidacionUsuario validacionUsuario;
    private ControlCreaciones controlCreaciones;
    public ResourceBundleProvider reportes;

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

    // METODOS PARA MOSTRAR INFORMACION

    // Se crea los input para el inicio de sesion
    public void mostrarIniciarSesion() {
        int intentos = 3;
        String identificacionIngresada = "";

        do {
            identificacionIngresada = this.mensajes.mostrarJOptioneInput("Ingrese la identifación");
            String idUsuario = this.mensajes.mostrarJOptioneInput("Ingrese el ID-USUARIO").toUpperCase();
            if (this.validacionUsuario.validarInicioSesion(identificacionIngresada, idUsuario)) {
                this.mensajes.mostrarJOptioneMessage("Acceso Permitido");
                this.mostrarMenuUsuarios(idUsuario);
                this.usuarioActual = identificacionIngresada;
                return;
            } else {
                this.mensajes.mostrarJOptioneMessage("Datos incorrectos\n Intentelo de nuevo");
                intentos--;

            }
        } while (intentos != 0);
        if (intentos <= 0) {
            this.mensajes.mostrarJOptioneMessage("LIMITE DE INTENTOS ALCANZADOS VOLVIENDO AL MENU PRINCIPAL");
        }

    }

    // Se crea metodo para mostrar los menus de los usuarios dependiendo del tipo
    public void mostrarMenuUsuarios(String tipoUsuario) {

        int opcionSeleccionada = 0;
        do {
            if (tipoUsuario.toUpperCase().contains("USR")) {
                opcionSeleccionada = this.mensajes.mostrarJOptioneInputOpciones("MENU CLIENTES",
                        this.opcionesMenuCliente, 0);
            this.generarAccionesCliente(opcionSeleccionada);
            } else if (tipoUsuario.toUpperCase().contains("ADM")) {
                opcionSeleccionada = this.mensajes.mostrarJOptioneInputOpciones("MENU ADMINISTRADOR",
                        this.opcionesMenuAdmin, 0);
                this.generarAccionesAdmin(opcionSeleccionada);

            } else {
                this.mensajes.mostrarJOptioneMessage("ERROR TIPO USUARIO INCORRECTO");
            }
        } while (opcionSeleccionada != -1);
        
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
        texto.append("Correo:").append(cliente.getCorreo());
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
        texto.append("Nombre del evento: ").append(evento.getNombreEventoFormato());
        texto.append("\n");
        texto.append("Id Evento: ").append(evento.getIdEvento());
        texto.append("\n");
        texto.append("Ubicación del Evento: ").append(evento.getUbicacionEvento());
        texto.append("\n");
        texto.append("Fecha y Hora del Evento: ").append(evento.getFecha()).append(" ").append(evento.getHora());
        texto.append("\n");
        texto.append("Tipo de Evento: ").append(evento.getTipoEvento());
        texto.append("\n");
        texto.append("Capacidad del evento: ").append(evento.getCapacidadMaximaEvento());
        return texto;
    }

    

    public StringBuilder mostrarDatosAdminCreado(Administrador AdministradorCreado) {
        StringBuilder texto = this.mensajes.StringBuilder();
        texto.append("Administrador creado exitosamente");
        texto.append("\n");
        texto.append("Nombre:").append(AdministradorCreado.getNombre());
        texto.append("\n");
        texto.append("Identificación:").append(AdministradorCreado.getIdentificacion());
        texto.append("\n");
        texto.append("ID Usuario:").append(AdministradorCreado.getIdUsuario());
        texto.append("\n");
        texto.append("Nota:El ID-USUARIO es necesario para el inicio de Sesion");
        return texto;
    }

    // Metodo que generan acciones en los menu
    //Acciones  cliente
    public void generarAccionesCliente(int opcionSeleecinada) {
        switch (opcionSeleecinada) {
            case 0:
                this.mostrarMenuComprarEntradas();
                break;
            case 1:
                this.mensajes.mostrarJOptioneMessage(Usuario.reportes.generarReporteEventos(this.listas).toString());
                break;
            case 2:
                this.mostrarMenuAsistirEvento();
            default:
                this.mensajes.mostrarJOptioneMessage("Volviendo al menú anterior");
                break;
        }
    }

    public void mostrarMenuAsistirEvento() {
        int intentos = 0;
        int opcionSeleccionada = this.mensajes.mostrarJOptioneInputOpciones("Eventos Disponibles", this.listas.devolverEventosDisponibles(), 0);
        Cliente clienteActual = listas.devolverClienteActual(this.usuarioActual);
        
        ArrayList<Entrada> listaEntradas = listas.getListaEntradas();
        
        while(intentos <= 3) {
            String entradaIngresada = this.mensajes.mostrarJOptioneInput("Ingrese el codigo de la entrada");
            Boolean asistirEvento = clienteActual.asistirEvento(entradaIngresada, listaEntradas);
            if (asistirEvento) {
                this.mensajes.mostrarJOptioneMessage("DISFUTRE DE SU EVENTO");
            } else {
                this.mensajes.mostrarJOptioneMessage("Entrada Incorrecta o entrada ya usada \n intente de nuevo");
                intentos++;
            }
        }
        if(intentos > 3) {
            this.mensajes.mostrarJOptioneMessage("Limite de intentos alcanzados volviendo al menu anterior");
        }
       
    }

    public void mostrarMenuComprarEntradas() {
        int opcionSeleccionada = this.mensajes.mostrarJOptioneInputOpciones("Eventos Disponibles", this.listas.devolverEventosDisponibles(), 0);
        Evento eventoSeleccionado = listas.getListaEvento().get(opcionSeleccionada);
        Cliente clienteActual = listas.devolverClienteActual(this.usuarioActual);
        Entrada entradaComprada = clienteActual.comprarEntrada();
        this.mensajes.mostrarJOptioneMessage(clienteActual.mostrarDatosEntrada(entradaComprada, eventoSeleccionado).toString());
        

    }
    public void generarAccionesAdmin(int opcionSelecconada) {
        switch (opcionSelecconada) {
            case 0:
                this.menuGenerarEvento(this.listas.devolverAdminActual(this.usuarioActual));
                break;
            case 1:
                this.menuGenerarAdmin(this.listas.devolverAdminActual(this.usuarioActual));
                break;
            case 2:
                this.menuGenerarReportes(this.listas.devolverAdminActual(this.usuarioActual));
                break;
            default:
                this.mensajes.mostrarJOptioneMessage("No se seleccionó ninguna opcion\nVolviendo al menu");
                break;
        }
            }
    
    // Se muestra las entradas de texto para crear usuarios
    public void registrarUsuario() {
        if (this.validacionUsuario.validarCantidadUsuarios()) {
            String identificacionUsuario = mensajes.mostrarJOptioneInput("Ingrese la identificación");
            Boolean usuarioExiste = validacionUsuario.validarUsuarioExistente(identificacionUsuario);
            if (!usuarioExiste) {
                String nombreUsuario = mensajes.mostrarJOptioneInput("Ingrese su nombre");
                String correoUsuario = mensajes.mostrarJOptioneInput("Ingrese su correo");
                Cliente cliente = new Cliente(nombreUsuario, identificacionUsuario, correoUsuario);
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
    public void menuGenerarEvento(Administrador administrador) {
        if (this.validacionUsuario.validarCantidadEventos()) {
            String nombreEvento = this.mensajes.mostrarJOptioneInput("Ingrese el nombre del Evento");
            String ubicacionEvento = this.obtenerUbicacionYTipoDesdeIndice(this.mensajes.mostrarJOptioneInputOpciones(
                    "Ubicaciciones Disponibles", this.obtenerUbicacionesYTiposComoString("ubicacion"), 0), "ubicacion");
            String fechaEvento = this.mensajes
                    .mostrarJOptioneInput("Ingrese la fecha del Evento en formato DD/MM/AAAA");
            String horaEvento = this.mensajes.mostrarJOptioneInput("Ingrese la hora del Evento en formato HH:MM");
            String tipoEvento = this.obtenerUbicacionYTipoDesdeIndice(this.mensajes.mostrarJOptioneInputOpciones(
                    "Tipos de Eventos", this.obtenerUbicacionesYTiposComoString("tipoevento"), 0), "tipoevento");
            int capacidadEvento = Integer
                    .parseInt(this.mensajes.mostrarJOptioneInput("Ingrese la capacidad maxima del Evento"));
            Evento evento = administrador.generarEvento(nombreEvento, ubicacionEvento, fechaEvento, horaEvento,
                    tipoEvento,
                    capacidadEvento);
            this.listas.agregarEventoLista(evento);
            this.controlCreaciones.setControlEventos();
            StringBuilder texto = this.mostrarDatosEventoCreado(evento);
            this.mensajes.mostrarJOptioneMessage(texto.toString());
            this.mensajes.eliminarMensaje(texto);
        } else {
            this.mensajes.mostrarJOptioneMessage("Regresando al menu anterior");
        }

    }
    
    //Se crea metodo para generar admin
    public void menuGenerarAdmin(Administrador administradorActual) {
        String identificacionAdmin = this.mensajes.mostrarJOptioneInput("Ingrese la identificación del Admin");
        Boolean adminExiste = this.validacionUsuario.validarUsuarioExistente(identificacionAdmin);
        if (!adminExiste) {
            String nombreAdmin = this.mensajes.mostrarJOptioneInput("Ingrese el nombre del Admin");
            String correoAdmin = this.mensajes.mostrarJOptioneInput("Ingrese el correo del admin");
            Administrador adminCreado = administradorActual.generarAdmin(nombreAdmin, identificacionAdmin, correoAdmin);
            this.listas.agregarAdministradorLista(adminCreado);
            StringBuilder texto = this.mostrarDatosAdminCreado(adminCreado);
            this.mensajes.mostrarJOptioneMessage(texto.toString());
            this.mensajes.eliminarMensaje(texto);


        }
    }

    //Se muestra los input para los reportes
    public void menuGenerarReportes(Administrador adminActual) {
        String[] opcionesReporte = {"Mostrar Reporte Eventos", "Mostrar Reporte Usuarios"};
        int opcionSeleccionada = this.mensajes.mostrarJOptioneInputOpciones("Menu Reportes", opcionesReporte, 0);
        switch (opcionSeleccionada) {
            case 0:
                adminActual.mostrarEventos(this.listas);
                break;
            case 1:
                adminActual.mostrarUsuarios(this.listas);
                break;
            default:
                this.mensajes.mostrarJOptioneMessage("No se ha seleccionado ninguna opcion\nVolviendo al menu anterior");
                break;
        }
    }

    // Metodos para obtener informacion
    // Metodo para pasar los Enums a String para mostrarlos en el menu
    private String[] obtenerUbicacionesYTiposComoString(String datoAMostrar) {
        datoAMostrar = datoAMostrar.toLowerCase();
        if (datoAMostrar.equals("ubicacion")) {
            Evento.UbicacionesEvento[] ubicaciones = Evento.getUbicacionesEvento();
            String[] ubicacionesStr = new String[ubicaciones.length];
            for (int i = 0; i < ubicaciones.length; i++) {
                ubicacionesStr[i] = ubicaciones[i].name().replace("_", " ");
            }
            return ubicacionesStr;
        } else if (datoAMostrar.equals("tipoevento")) {
            Evento.TiposEvento[] tiposDeEventos = Evento.getTiposEvento();
            String[] tiposDeEventosStr = new String[tiposDeEventos.length];
            for (int i = 0; i < tiposDeEventos.length; i++) {
                tiposDeEventosStr[i] = tiposDeEventos[i].name().replace("_", " ");
            }
            return tiposDeEventosStr;
        } else {
            return new String[] { "Error parametro incorrecto" };
        }

    }

    // Metodo para obtener el indice del enum seleccionado por el usuarioi par
    // aguadarlo en el objeto
    private String obtenerUbicacionYTipoDesdeIndice(int indice, String datoAMostrar) {
        datoAMostrar = datoAMostrar.toLowerCase();
        if (datoAMostrar.equals("ubicacion")) {
            Evento.UbicacionesEvento[] ubicaciones = Evento.getUbicacionesEvento();
            if (indice >= 0 && indice < ubicaciones.length) {
                return ubicaciones[indice].name();
            } else {
                this.mensajes.mostrarJOptioneMessage("Ubicación incorrecta");
                return "Ubicacion Incorrecta";
            }
        } else if (datoAMostrar.equals("tipoevento")) {
            Evento.TiposEvento[] tiposEventos = Evento.getTiposEvento();
            if (indice >= 0 && indice < tiposEventos.length) {
                return tiposEventos[indice].name();
            } else {
                this.mensajes.mostrarJOptioneMessage("TIPO DE EVENTO INCORRECTO");
                return "Tipo de enveto incorrecti";
            }
        } else {
            return "ERROR PARAMETRO INCORRECTO";
        }

    }

}
