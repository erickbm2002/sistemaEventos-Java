package codelitas.eventosgo;

public class Evento {

    //atributos
    private String nombreEvento;
    private String idEvento;
    private String ubicacionEvento;
    private String fecha;
    private String hora;
    private String tipoEvento;
    private int capacidadMaximaEvento;

    public static enum UbicacionesEvento {
        ESTADIO_NACIONAL,
        CENTRO_DE_CONVENCIONES,
        PEDREGAL,
        PARQUE_VIVA
    }

    public static enum TiposEvento {
        CONCIERTO,
        ACTIVIDAD_RECREATIVA,
        EVENTO_DEPORTIVO
    }

    //Constructor
    public Evento(String pNombreEvento,String pUbicacionEvento, String pfecha,String phora,
            String pTipoEvento, int pCapacidadMaximaEvento) {
        this.nombreEvento = pNombreEvento.toLowerCase();
        this.idEvento = GenerarID.generarID("EVT");
        this.ubicacionEvento = pUbicacionEvento;
        this.fecha = pfecha;
        this.hora = phora;
        this.tipoEvento = pTipoEvento;
        this.capacidadMaximaEvento = pCapacidadMaximaEvento;
    }

    //getters y setters
    public String getNombreEvento() {
        return nombreEvento;
    }

    public String getNombreEventoFormato() {
        return nombreEvento.substring(0, 1).toLowerCase() + nombreEvento.substring(1);
    }

    public String getIdEvento() {
        return idEvento;
    }

    public String getUbicacionEvento() {
        return ubicacionEvento;
    }

    public static UbicacionesEvento[]  getUbicacionesEvento() {
        UbicacionesEvento[] ubicaciones = UbicacionesEvento.values();
        return ubicaciones;
    }

    public String getFecha() {
        return fecha;
    }

    public String getHora() {
        return hora;
    }

    public String getTipoEvento() {
        return tipoEvento;
    }

    public static TiposEvento[] getTiposEvento() {
        TiposEvento[] tipoEvento = TiposEvento.values();
        return tipoEvento;
    }

    public int getCapacidadMaximaEvento() {
        return capacidadMaximaEvento;
    }

    
}
