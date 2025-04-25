package codelitas.eventosgo;

import java.util.ArrayList;


//Se crea una clase cliente que hereda los atributos y metodos de Clase Usuario
public class Cliente extends Usuario {
    //Metodos especificos de clase cliente
    private ArrayList<Entrada> entradasCompradas;
    private int cantidadEntradasCompradas = 0;
    private MostrarMensajes mensajes;

    //Se crea constructor que hereda atributos de la clase Uusuari
    public Cliente(String pNombre, String pIdentificacion, String pCorreo) {
        super(pNombre, pIdentificacion, pCorreo, GenerarID.generarID("USR"));
        this.entradasCompradas = new ArrayList<>();
        this.mensajes = new MostrarMensajes();
    }

    //MEETODOS

    public Entrada comprarEntrada() {
        if(this.cantidadEntradasCompradas < 5) {
            Entrada entrada = new Entrada();
            this.setCantidadEntradasCompradas();
            this.entradasCompradas.add(entrada);
            return entrada;
        } else {
            this.mensajes.mostrarJOptioneMessage("Ha alcanzado el limite maximo de entradas");
            return null;
        }
        
    }

    public boolean asistirEvento(String idEntrada, ArrayList<Entrada> listaEntradas) {
        idEntrada = idEntrada.toUpperCase();
        ArrayList<Entrada> entradasUsuarios = this.getEntradasCompradas();
        for (int i = 0; i < listaEntradas.size(); i++) {
            Entrada entradasGenerales = listaEntradas.get(i);
            if (entradasGenerales.getIdEntrada().equals(idEntrada)) {
                Entrada entradaActual = entradasUsuarios.get(i);
                if(entradaActual.getIdEntrada().equals(idEntrada)) {
                    entradaActual.setUsada();
                }
                return true;
            }
        }
        return false;
    }

    public StringBuilder mostrarDatosEntrada(Entrada entrada, Evento evento) {
        StringBuilder texto = this.mensajes.StringBuilder();
        texto.append("ID Entrada: ").append(entrada.getIdEntrada());
        texto.append("\n");
        texto.append("Nombre de Usuario: ").append(this.getNombre());
        texto.append("\n");
        texto.append("ID Evento: ").append(evento.getIdEvento());
        texto.append("\n");
        texto.append("Recordar guardar el id de entrada para acceder al evento");
        return texto;

    }

    public void mostrarReporteEventos(ListasSistemaEvento listas) {
        Usuario.reportes.generarReporteEventos(listas);
    }

    //Metodos getters y setters
    
    public int getCantidadEntradasCompradas() {
        return this.cantidadEntradasCompradas;
    }

    public void setCantidadEntradasCompradas() {
        this.cantidadEntradasCompradas++;
    }

    public ArrayList<Entrada> getEntradasCompradas() {
        return this.entradasCompradas;
    }

}

