package codelitas.eventosgo;

import java.util.ArrayList;

//clase para generar los reportes
public class Reportes {
    public static void main(String[] args) {
        ListasSistemaEvento lista = new ListasSistemaEvento();
        MostrarMensajes mensajes = new MostrarMensajes();
        Reportes reporte = new Reportes();
        Evento evento = new Evento("Maluma", "null", "null", "null", "null", 200);
        Evento evento2 = new Evento("Otro", "null", "null", "null", "null", 200);
        lista.agregarEventoLista(evento2);
        lista.agregarEventoLista(evento);
        mensajes.mostrarJOptioneMessage(reporte.generarReporteEventos(lista).toString());
        
    }



    //Atributos
    public MostrarMensajes mensajes = new MostrarMensajes();

        public  StringBuilder generarReporteEventos(ListasSistemaEvento listas) {
            ArrayList<Evento> listaEventos = listas.getListaEvento();
            StringBuilder texto = this.mensajes.StringBuilder();

            texto.append("Eventos Disponibles");
            for(int i = 0; i < listaEventos.size(); i++ ) {
                Evento evento = listaEventos.get(i);
                texto.append("\n");
                texto.append("---------------------------");
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
                texto.append("\n");
                texto.append("Cupos disponibles:").append(evento.getEntradasDisponibles()).append(" de ").append(evento.getCapacidadMaximaEvento());
                texto.append("\n");
                texto.append("---------------------------");
            } 
            return texto;
        }

        public StringBuilder generarReporteUsuarios(ListasSistemaEvento listas) {
            ArrayList<Cliente> listaClientes = listas.getListaUsuario();
            StringBuilder texto = this.mensajes.StringBuilder();
            
            texto.append("Usuarios Activos:");
            for (int i = 0; i < listaClientes.size(); i++) {
                Cliente cliente = listaClientes.get(i);
                texto.append("\n");
                texto.append("---------------------------");
                texto.append("\n");
                texto.append("Nombre:").append(cliente.getNombre());
                texto.append("\n");
                texto.append("Identificación:").append(cliente.getIdentificacion());
                texto.append("\n");
                texto.append("Correo:").append(cliente.getCorreo());
                texto.append("\n");
                texto.append("ID Usuario:").append(cliente.getIdUsuario());
                texto.append("\n");
                texto.append("Entradas compradas:").append(cliente.getCantidadEntradasCompradas());
                texto.append("\n");
                texto.append("---------------------------");
            }
            return texto;
        }
}
