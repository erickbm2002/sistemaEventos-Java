package codelitas.eventosgo;

public class Main {
  public static void main(String[] args) {
    //Se inicializan las clases que se van a usar
    
    MostrarMensajes mensajes = new MostrarMensajes();
    ListasSistemaEvento lista = new ListasSistemaEvento();
    ValidacionUsuario validacionUsuario = new ValidacionUsuario(lista, mensajes);
    MenuSistema menuSistema = new MenuSistema(mensajes, lista, validacionUsuario);
    

    Usuario usuario = new Usuario();
    
    mensajes.mostrarJOptioneMessage("Bienvenido al Sistema\nDerechos Reservados por CODELITAS");
    menuSistema.mostrarMenuLogin();
  }

}
