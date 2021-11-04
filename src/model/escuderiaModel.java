package model;


public class escuderiaModel {
    private int     codEscuderia;
    private String  nombreEscuderia;
    private String  patrocinador;
    private int     carrerasGanadas;
    private String  fechaIngreso;
    
    
//Constructor para manejo interno de la tabla
    public escuderiaModel(int codEscuderia, String nombreEscuderia, String patrocinador,
            int carrerasGanadas, String fechaIngreso){
        this.codEscuderia = codEscuderia;
        this.nombreEscuderia = nombreEscuderia;
        this.patrocinador = patrocinador;
        this.carrerasGanadas = carrerasGanadas;
        this.fechaIngreso = fechaIngreso;
    }
    public escuderiaModel(int codEscuderia, String nombreEscuderia){
        this.codEscuderia = codEscuderia;
        this.nombreEscuderia = nombreEscuderia;               
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
     * @return the patrocinador
     */
    public String getPatrocinador() {
        return patrocinador;
    }

    /**
     * @return the carrerasGanadas
     */
    public int getCarrerasGanadas() {
        return carrerasGanadas;
    }

    /**
     * @param carrerasGanadas the carrerasGanadas to set
     */
    public void setCarrerasGanadas(int carrerasGanadas) {
        this.carrerasGanadas = carrerasGanadas;
    }

    /**
     * @return the fechaIngreso
     */
    public String getFechaIngreso() {
        return fechaIngreso;
    }

    public String toString(){
       return this.nombreEscuderia;
    }
    
    public Object[] toArray(){
       Object[] data = {codEscuderia, nombreEscuderia, patrocinador, carrerasGanadas, fechaIngreso};
        return data;
    }

    
}
