package codelitas.eventosgo;

import java.util.ArrayList;

//Se crea una clase cliente que hereda los atributos y metodos de Clase Usuario
public class Cliente extends Usuario {
    //Metodos especificos de clase cliente
    private ArrayList<String> idsEntradasCompradas;
    private int cantidadEntradasCompradas = 0;

    //Se crea constructor que hereda atributos de la clase Uusuari
    public Cliente(String pNombre, String pIdentificacion, String pCorreo, String IDUsuario) {
        super(pNombre, pIdentificacion, pCorreo, IDUsuario);
        this.setRollUsuario(RollUsuario.CLIENTE);
        this.idsEntradasCompradas = new ArrayList<>();
    }

    //Metodos getters y setters
    public ArrayList<String> getIDSEntradasCompradas() {
        return this.idsEntradasCompradas;
    }

    public void setIDSEntradasCompradas(String idEntrada) {
        this.idsEntradasCompradas.add(idEntrada);
    }

    public int getCantidadEntradasCompradas() {
        return this.cantidadEntradasCompradas;
    }

    public void setCantidadEntradasCompradas() {
        this.cantidadEntradasCompradas++;
    }

    public static void main(String[] args) {
        Cliente cliente = new Cliente("Erick", "118484", "sadaddad", GenerarID.generarID("USR"));
        System.out.println(cliente.getCantidadEntradasCompradas());
        cliente.setCantidadEntradasCompradas();
        cliente.setCantidadEntradasCompradas();
        System.out.println(cliente.getCantidadEntradasCompradas());
        cliente.setIDSEntradasCompradas("USR-4454");
        cliente.setIDSEntradasCompradas("USR-4545");
        cliente.setIDSEntradasCompradas("USR-441454");
        System.out.println(cliente.getIDSEntradasCompradas());
        for (int i = 0; i < cliente.getIDSEntradasCompradas().size(); i++) {
            System.out.println(cliente.getIDSEntradasCompradas().get(i));
        }

    }
}

