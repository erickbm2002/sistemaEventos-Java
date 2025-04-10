package codelitas.eventosgo;

import javax.swing.JOptionPane;

public class MostrarMensajes {
    

    public String mostrarJOptioneInput(String mensaje) {
        return JOptionPane.showInputDialog(mensaje);
    }

    public void mostrarJOptioneMessage(String mensaje) {
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void eliminarMensaje(StringBuilder mensaje) {
        mensaje.delete(0, mensaje.length());

    }

    public int mostrarJOptioneInputOpciones(String titulo, String[] lista, int indexLista) {
        return JOptionPane.showOptionDialog(null, "Seleccione una opción", titulo, JOptionPane.DEFAULT_OPTION,
                JOptionPane.INFORMATION_MESSAGE, null, lista, lista[indexLista]);
    }
    
    public StringBuilder StringBuilder() {
        StringBuilder texto = new StringBuilder();
        return texto;
    }

    public StringBuilder eliminarStringBuffer(StringBuilder texto) {
        texto.delete(0, texto.length());
        return texto;
    }

}
