package codelitas.eventosgo;

import javax.swing.JOptionPane;

public class GenerarID {
    // control de consecutivos ID
    private static int consecutivoUsuario = 0;
    private static int consecutivoEntrada = 0;
    private static int consecutivoEvento = 0;
    private static int consecutivoADMIN = 0;

    //Se crea metodod para generar el ID correspondeinte segun el tipo de ID que se necesita
    public static String generarID(String tipoID) {
        String idGenerado = "";
        tipoID = tipoID.toUpperCase();
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
            case "ADM":
                consecutivoADMIN++;
                idGenerado = String.format("%s-%03d", tipoID, consecutivoADMIN);
                break;

            default:
                JOptionPane.showMessageDialog(null, "Ha ingresado un tipo de ID incorrecto: Tipos de ID:\nUSR,EVT,TKT");
                break;
        }
        return idGenerado;
    }

    public static void main(String[] args) {
        GenerarID generarID = new GenerarID();
        System.out.println(generarID("usr"));
    }

}
