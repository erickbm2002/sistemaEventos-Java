package codelitas.eventosgo;

public class Main {
  public static void main(String[] args) {
    //Se inicializan las clases que se van a usar  
    
    MostrarMensajes mensajes = new MostrarMensajes();
    ListasSistemaEvento lista = new ListasSistemaEvento();
    ControlCreaciones controlCreaciones = new ControlCreaciones();
    ValidacionUsuario validacionUsuario = new ValidacionUsuario(lista, mensajes, controlCreaciones);
    MenuSistema menuSistema = new MenuSistema(mensajes, lista, validacionUsuario, controlCreaciones);
    
    mensajes.mostrarJOptioneMessage("Bienvenido al Sistema\nDerechos Reservados por CODELITAS");
    menuSistema.mostrarMenuLogin();
  }

}
