package codelitas.eventosgo;

import java.util.ArrayList;



public class ListasSistemaEvento {
public static void main(String[] args) {
    ListasSistemaEvento listas = new ListasSistemaEvento();
    MostrarMensajes mensajes = new MostrarMensajes();
    ControlCreaciones control = new ControlCreaciones();
    ValidacionUsuario validacionUsuario = new ValidacionUsuario(listas, mensajes,control);
    listas.devolverAdminActual("12345678");

    ArrayList<Usuario> listaUnificada = new ArrayList<>();
    listaUnificada = listas.devolverListasUsuariosUnificada();
    System.out.println(listaUnificada.size());;
    for (int i = 0; i < listaUnificada.size();i++ ) {
        Usuario elemento = listaUnificada.get(i);
        System.out.println(elemento.getNombre());;
        System.out.println("--------------------");
    }

}

    //Atributops
    private ArrayList<Cliente> listaUsuarios;
    private ArrayList<Administrador> listaAdministradores;
    private ArrayList<Evento> listaEventos;

    //Constructor
    public ListasSistemaEvento() {
        listaUsuarios = new ArrayList<>();
        listaAdministradores = new ArrayList<>();
        listaEventos = new ArrayList<>();
        Administrador adminDefault = new Administrador("admin Default", "12345678", "admindefault@gmail.com");
        this.agregarAdministradorLista(adminDefault);
    }
    
    //Metodos
    //Agrega un  usuario cliente a lista
    public void agregarClienteLista(Cliente usuario) {
        listaUsuarios.add(usuario);
    }

    //agrega un  usuario Admnistrador a lista
    public void agregarAdministradorLista(Administrador administrador) {
        listaAdministradores.add(administrador);
    }

    //agrega une vento a lista
    public void agregarEventoLista(Evento evento) {
        listaEventos.add(evento);
    }

    //Metodo para devolvernos las identificaciones de los usuarios
    public ArrayList<String> devolverIdentificacionListaUsuarios() {
        ArrayList<String> identificacionesUsuarios = new ArrayList<>();
        ArrayList<Usuario> listaUnificada = new ArrayList<>();
        listaUnificada = this.devolverListasUsuariosUnificada();
        for (int i = 0; i < listaUnificada.size(); i++) {
            Usuario usuario = listaUnificada.get(i);
            String identificacion = usuario.getIdentificacion();
            identificacionesUsuarios.add(identificacion);
        }
        return identificacionesUsuarios;
    }

    //metodo para devolver la lista de los objetos de usuarios creados
    public ArrayList<Usuario> devolverListasUsuariosUnificada() {
        ArrayList<Usuario> listaUnificada = new ArrayList<>();
        listaUnificada.addAll(this.listaAdministradores);
        listaUnificada.addAll(this.listaUsuarios);
        return listaUnificada;
    }

    //Se obtiene admin actual que esta ingresando
    public Administrador devolverAdminActual(String identificacion) {
        int posicionAdmin = 0;
        for (int i = 0; i < listaAdministradores.size(); i++) {
            Administrador admin = listaAdministradores.get(i);
            String identificacionAdmin = admin.getIdentificacion();
            if (identificacionAdmin.equals(identificacion)) {
                posicionAdmin = i;
            }
        }
        return listaAdministradores.get(posicionAdmin);
        
    }

    // Se obtiene el cliente actual que esta ingresando
    public Cliente devolverClienteActual (String identificacion) {
        int posicionCliente = 0;
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Cliente cliente = listaUsuarios.get(i);
            String identificacionCliente = cliente.getIdentificacion();
            if (identificacionCliente.equals(identificacion)) {
                posicionCliente = i;
            }
        }

        return listaUsuarios.get(posicionCliente);
    }

    public String[] devolverEventosDisponibles() {
        String[] listaEventosDisponibles = new String[listaEventos.size()];
        for (int i = 0; i < listaEventos.size(); i++) {
            Evento evento = listaEventos.get(i);
            listaEventosDisponibles[i] = evento.getNombreEventoFormato();
        }
        return listaEventosDisponibles;
    }

    //Getters y setters
    public ArrayList<Evento> getListaEvento() {
        return this.listaEventos;
    }

    public ArrayList<Cliente> getListaUsuario() {
        return this.listaUsuarios;
    }
    

}

