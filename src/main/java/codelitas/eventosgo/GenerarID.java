package codelitas.eventosgo;

import javax.swing.JOptionPane;

public class GenerarID {
    // control de consecutivos ID
    private static int consecutivoUsuario = 0;
    private static int consecutivoEntrada = 0;
    private static int consecutivoEvento = 0;
    private int consecutivoADMIN = 0;

    // control de capacidades
    private static int capacidadMaximaUsuarios = 3;
    private static int capacidadMaximaEntradas = 3;
    private static int capacidadMaximaEventos = 3;

    public static String generarID(String tipoID) {
        String idGenerado = "";
        // VALIDAR el tipo de  id a generar
        switch (tipoID) {
            case "USR":
                consecutivoUsuario++;
                idGenerado = String.format("%s-%03d", tipoID, consecutivoUsuario);
                break;
            case "EVT":
                consecutivoEvento++;
                idGenerado = String.format("%s-%03d", tipoID, consecutivoEvento);
                break;
            case "TKT":
                consecutivoEntrada++;
                idGenerado = String.format("%s-%03d", tipoID, consecutivoEntrada);
                break;

            default:
                JOptionPane.showMessageDialog(null, "A ingresado un tipo de ID incorrecto: Tipos de ID:\nUSR,EVT,TKT");
                break;
        }
        return idGenerado;
    }

    public String generarIDAdmnistrador() {
        consecutivoADMIN++;
        String IDGeneradoAdmin = String.format("%s-%02d", "Admin", this.consecutivoADMIN);
        return IDGeneradoAdmin;
    }

    public static void main(String[] args) {
        GenerarID generarID = new GenerarID();
        System.out.println(generarID.generarIDAdmnistrador());
        System.out.println(generarID.generarIDAdmnistrador());
        System.out.println(generarID.generarIDAdmnistrador());
    }

    
    //SIN USAR ACTUALMENTE
    public static void validarCapacidad(String tipoID) {
        switch (tipoID) {
            case "USR":
                if (consecutivoUsuario >= capacidadMaximaUsuarios) {
                    mostrarMensaje("usuarios", capacidadMaximaUsuarios, consecutivoUsuario);
                }
                break;
            case "EVT":
                if (consecutivoEvento >= capacidadMaximaEventos) {
                    mostrarMensaje("eventos", capacidadMaximaEventos, consecutivoEvento);
                }
                break;
            case "TKT":
                if (consecutivoEntrada >= capacidadMaximaEntradas) {
                    mostrarMensaje("entradas", capacidadMaximaEntradas, consecutivoEntrada);
                }
                break;
            default:
                break;
        }
    }

    private static void mostrarMensaje(String tipo, int capacidadMaxima, int consecutivo) {
        JOptionPane.showMessageDialog(null,
                "Ha superado la capacidad máxima de " + tipo + "\nCapacidad: " + capacidadMaxima + " de "
                        + consecutivo + " posibles");
    }

}
