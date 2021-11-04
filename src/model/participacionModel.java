package model;


public class participacionModel {
    private int     idParticipacion;
    private String  fecha;
    private int     posicion;
    private int     idCarreraFk;
    private int     codPilotoFk;
    
    public participacionModel(int idParticipacion, String fecha, int posicion, int idCarreraFk, 
            int codPilotoFk){
        this.idParticipacion = idParticipacion;
        this.fecha = fecha;
        this.posicion = posicion;
        this.codPilotoFk = codPilotoFk;
        this.idCarreraFk = idCarreraFk;
        
    }

    /**
     * @return the idParticipacion
     */
    public int getIdParticipacion() {
        return idParticipacion;
    }

    /**
     * @return the fecha
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * @return the posicion
     */
    public int getPosicion() {
        return posicion;
    }

    /**
     * @return the idCarreraFk
     */
    public int getIdCarreraFk() {
        return idCarreraFk;
    }

    /**
     * @return the codPilotoFk
     */
    public int getCodPilotoFk() {
        return codPilotoFk;
    }
    
    public String toString(){
        return this.fecha;
    }
    
}
