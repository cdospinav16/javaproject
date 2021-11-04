package controller;

import access.pilotosDAO;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import model.pilotosModel;
import model.carrerasModel;
import model.participacionModel;
import view.AddPiloto;
import view.DeletePiloto;
import view.ControlsPanel;
import view.TableWindow;
import view.tablePilotos;

public class ClickEvent implements ActionListener{
    private ControlsPanel controlsPanel;
    
    public ClickEvent (ControlsPanel controlsPanel){
        this.controlsPanel = controlsPanel;
    }
    
    
@Override
    public void actionPerformed (ActionEvent actionEvent){
        if (actionEvent.getSource() == this.controlsPanel.getBtnSearch()){
            int idCarrera               = ((carrerasModel)this.controlsPanel.getCbxCarrerasList().getSelectedItem()).getIdCarrera();
            int idParticipacion         = ((participacionModel)this.controlsPanel.getCbxParticipacionList().getSelectedItem()).getIdParticipacion();
            String dateParticipacion    = ((participacionModel)this.controlsPanel.getCbxParticipacionList().getSelectedItem()).getFecha();
            String pilotoName           = (String)this.controlsPanel.getTxtName().getText();
            
            pilotosDAO pilotosDao = new pilotosDAO();
            ArrayList<pilotosModel> pilotos = pilotosDao.obtenerPilotoFiltrado(idCarrera, idParticipacion, dateParticipacion, pilotoName);
            
            this.controlsPanel.setTblResults(pilotos);
        }
        else if (actionEvent.getSource() == this.controlsPanel.getBtnAddPiloto()){
            AddPiloto addPilotoView = new AddPiloto();
            addPilotoView.setVisible(true);
        }
        else if (actionEvent.getSource() == this.controlsPanel.getBtnDeletePiloto()){
            DeletePiloto deletePilotoView = new DeletePiloto();
            deletePilotoView.setVisible(true);
            }
        else if (actionEvent.getSource() == this.controlsPanel.getBtnTablaPilotos()){
            TableWindow tableWindowvView = new TableWindow();
            tableWindowvView.setVisible(true);
        }
    }
}

