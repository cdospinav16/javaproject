package model;


public class carrerasModel {
    private int     idCarrera;
    private String  nombreCarrera;
    private int     capacidadAsistentes;
    private double  nivelDificultad;
    private boolean techoDisponible;
    
    private String  pilotosNombre;
    private String  posicionParticipacion;
    
//Constructor para manejo interno de la tabla
    public carrerasModel(int idCarrera, String nombreCarrera, int capacidadAsistentes,
            double nivelDificultad, boolean techoDisponible){
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.capacidadAsistentes = capacidadAsistentes;
        this.nivelDificultad = nivelDificultad;
        this.techoDisponible = techoDisponible;
    }
    
//Constructor con fines de proyeccion desde la base de datos
    public carrerasModel(int idCarrera, String nombreCarrera, int capacidadAsistentes,
            double nivelDificultad, boolean techoDisponible, String pilotosNombre, String posicionParticipacion){
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
        this.capacidadAsistentes = capacidadAsistentes;
        this.nivelDificultad = nivelDificultad;
        this.techoDisponible = techoDisponible;
        
        this.pilotosNombre = pilotosNombre;
        this.posicionParticipacion = posicionParticipacion;
    }

    public carrerasModel(int idCarrera, String nombreCarrera){
        this.idCarrera = idCarrera;
        this.nombreCarrera = nombreCarrera;
    }
    /**
     * @return the idCarrera
     */
    public int getIdCarrera() {
        return idCarrera;
    }

    /**
     * @return the nombreCarrera
     */
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    /**
     * @return the capacidadAsistentes
     */
    public int getCapacidadAsistentes() {
        return capacidadAsistentes;
    }

    /**
     * @param capacidadAsistentes the capacidadAsistentes to set
     */
    public void setCapacidadAsistentes(int capacidadAsistentes) {
        this.capacidadAsistentes = capacidadAsistentes;
    }

    /**
     * @return the nivelDificultad
     */
    public double getNivelDificultad() {
        return nivelDificultad;
    }

    /**
     * @return the techoDisponible
     */
    public boolean isTechoDisponible() {
        return techoDisponible;
    }

    /**
     * @return the pilotosNombre
     */
    public String getPilotosNombre() {
        return pilotosNombre;
    }

    /**
     * @return the posicionParticipacion
     */
    public String getPosicionParticipacion() {
        return posicionParticipacion;
    }
    
    public String toString(){
        return this.nombreCarrera;
    }
}
