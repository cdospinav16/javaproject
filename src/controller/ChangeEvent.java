package controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


import access.participacionDAO;
import model.carrerasModel;
import model.participacionModel;
import view.ControlsPanel;

public class ChangeEvent implements ActionListener{
    private ControlsPanel controlsPanel;
    
    public ChangeEvent(ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;             
    }
    
    @Override
    
    public void actionPerformed (ActionEvent actionEvent){
        if(actionEvent.getSource() == this.controlsPanel.getCbxCarrerasList()){
            participacionDAO participacionDao = new participacionDAO();
            ArrayList<participacionModel> participaciones = null;
            int carrera     = ((carrerasModel)this.controlsPanel.getCbxCarrerasList().getSelectedItem()).getIdCarrera();
            if(carrera == -1){
                participaciones = participacionDao.obtenerParticipaciones();
                participaciones.add(0, new participacionModel(-1, "Todas Las Particiones", -1, -1, -1));
               
                
            } else {
                participaciones = participacionDao.obtenerPresentacionByCarrera(carrera);
                participaciones.add(0, new participacionModel(-1, "Todas las presentaciones", -1, -1, -1));                      
            }   this.controlsPanel.setCbxParticipacionList(participaciones);
        }  
     } 
}
