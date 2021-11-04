package model;

    


public class pilotosModel {
    private int     codPiloto;
    private String  nombre;
    private double  millasRecorridas;
    private int     combustibleUsado;
    private int     codEscuderia;
   
    private String  nombreEscuderia;
    private String  patrocinadorEscuderia;
    private int     carrerasGanadas;
    private int     idCarrera;
    private String  nombreCarrera;
    private int     idParticipacion;
    private String  participacionFecha;
    private int     posicion;
    
    
//Constructor para manejo interno de la tabla
    public pilotosModel(int codPiloto, String nombre, 
            double millasRecorridas, int combustibleUsado, 
            int codEscuderia){
        this.codPiloto = codPiloto;
        this.nombre = nombre;
        this.millasRecorridas = millasRecorridas;
        this.combustibleUsado = combustibleUsado;
        this.codEscuderia = codEscuderia;
    }
    
//Constructor con fines de proyeccion desde la base de datos

    public pilotosModel(int codPiloto, String nombre, double millasRecorridas, String nombreEscuderia, 
            String patrocinadorEscuderia, int carrerasGanadas, String nombreCarrera, String participacionFecha, int posicion){
        this.codPiloto = codPiloto;
        this.nombre = nombre;
        this.millasRecorridas = millasRecorridas;
        this.nombreEscuderia = nombreEscuderia;
        this.patrocinadorEscuderia = patrocinadorEscuderia;
        this.carrerasGanadas = carrerasGanadas;
        this.nombreCarrera = nombreCarrera;
        this.participacionFecha = participacionFecha;
        this.posicion = posicion;   
    }

    /**
     * @return the codPiloto
     */
    public int getCodPiloto(int codPiloto) {
        return codPiloto;
    }
    
    public int getCodPiloto() {
        return codPiloto;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @return the millasRecorridas
     */
    public double getMillasRecorridas() {
        return millasRecorridas;
    }

    /**
     * @param millasRecorridas the millasRecorridas to set
     */
    public void setMillasRecorridas(double millasRecorridas) {
        this.millasRecorridas = millasRecorridas;
    }

    /**
     * @return the combustibleUsado
     */
    public int getCombustibleUsado() {
        return combustibleUsado;
    }

    /**
     * @param combustibleUsado the combustibleUsado to set
     */
    public void setCombustibleUsado(int combustibleUsado) {
        this.combustibleUsado = combustibleUsado;
    }

    /**
     * @return the codEscuderia
     */
    public int getCodEscuderia() {
        return codEscuderia;
    }

    /**
     * @return the nombreEscuderia
     */
    public String getNombreEscuderia() {
        return nombreEscuderia;
    }

    /**
     * @return the patrocinadorEscuderia
     */
    public String getPatrocinadorEscuderia() {
        return patrocinadorEscuderia;
    }
    
    /**
     * @return the carrerasGanadas
     */
    public int getCarrerasGanadas() {
        return carrerasGanadas;
    }

    /**
     * @return the nombreCarrera
     */
    public String getNombreCarrera() {
        return nombreCarrera;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }
    
    /**
     * @return the participacionFecha
     */
    public String getParticipacionFecha() {
        return participacionFecha;
    }
    
    
     public Object[] toArray(){
       Object[] data = {codPiloto, nombre, millasRecorridas, nombreEscuderia, patrocinadorEscuderia , carrerasGanadas, nombreCarrera, (String)participacionFecha, posicion};
        return data;
    }

     public Object[] toArrayMain(){
       Object[] data = {codPiloto, nombre, millasRecorridas, combustibleUsado, codEscuderia};
        return data;
    }

}
