package codelitas.eventosgo;

import java.util.ArrayList;



public class ListasSistemaEvento {
public static void main(String[] args) {
    ListasSistemaEvento listas = new ListasSistemaEvento();
    Administrador admin = new Administrador("Erick", "118580448", "dadadadada", GenerarID.generarID("USR"));
    Administrador admin1 = new Administrador("Erick", "118580448", "dadadadada", GenerarID.generarID("USR"));
    Cliente cliente1 = new Cliente("Erick", "118580448", "dadadadada", GenerarID.generarID("USR"));
    Cliente cliente2Cliente = new Cliente("Erick", "118580448", "dadadadada", GenerarID.generarID("USR"));
    listas.agregarAdministradorLista(admin1);
    listas.agregarAdministradorLista(admin);
    listas.agregarClienteLista(cliente2Cliente);
    listas.agregarClienteLista(cliente1);

    ArrayList<Usuario> listaUnificada = new ArrayList<>();
    listaUnificada = listas.devolverListasUsuariosUnificada();
    System.out.println(listaUnificada.size());;
}

    //Atributops
    public ArrayList<Cliente> listaUsuarios;
    public ArrayList<Administrador> listaAdministradores;
    public ArrayList<Evento> listaEventos;

    //Constructor
    public ListasSistemaEvento() {
        listaUsuarios = new ArrayList<>();
        listaAdministradores = new ArrayList<>();
        listaEventos = new ArrayList<>();
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
        for (int i = 0; i < listaUsuarios.size(); i++) {
            Cliente usuario = listaUsuarios.get(i);
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
    

}

