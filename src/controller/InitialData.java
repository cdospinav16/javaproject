package controller;


import java.util.ArrayList;

import model.carrerasModel;
import model.escuderiaModel;
import model.participacionModel;
import model.pilotosModel;

import access.carrerasDAO;
import access.escuderiaDAO;
import access.participacionDAO;
import access.pilotosDAO;


public class InitialData {
    private ArrayList<carrerasModel>        carreras        = null;
    private ArrayList<escuderiaModel>       escuderias      = null;
    private ArrayList<participacionModel>   participacion   = null;
    private ArrayList<pilotosModel>         pilotos         = null;
    private ArrayList<pilotosModel>         pilotosTable    = null;

      
    
    public InitialData(){
        carrerasDAO carrerasDao = new carrerasDAO();
        this.carreras = carrerasDao.obtenerCarreras();
        this.carreras.add(0, new carrerasModel(-1, "Todas las carreras"));
        
        escuderiaDAO escuderiaDao = new escuderiaDAO();
        this.escuderias = escuderiaDao.obtenerEscuderias();
        this.escuderias.add(0, new escuderiaModel(-1, "Todas las Escuderias"));
        
        participacionDAO participacionDao = new participacionDAO();
        this.participacion = participacionDao.obtenerParticipaciones();
        this.participacion.add(0, new participacionModel(-1, "Todas las Participaciones", -1, -1, -1));
        
        pilotosDAO pilotosDao = new pilotosDAO();
        this.pilotos = pilotosDao.obtenerPilotos();   
        
        this.pilotosTable = pilotosDao.obtenerPilotosTabla();
        
        
    }

    /**
     * @return the carreras
     */
    public ArrayList<carrerasModel> getCarreras() {
        return carreras;
    }

    /**
     * @return the escuderias
     */
    public ArrayList<escuderiaModel> getEscuderias() {
        return escuderias;
    }

    /**
     * @return the participacion
     */
    public ArrayList<participacionModel> getParticipacion() {
        return participacion;
    }

    /**
     * @return the pilotos
     */
    public ArrayList<pilotosModel> getPilotos() {
        return pilotos;
    }
    
    public ArrayList<pilotosModel> getTblPilotos(){
        return pilotosTable;
    }
    
}
