package view;


import controller.ChangeEvent;
import controller.ClickEvent;
import controller.InitialData;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import model.carrerasModel;
import model.escuderiaModel;
import model.participacionModel;
import model.pilotosModel;

        

public class ControlsPanel extends JPanel {
    private JLabel                          lblcarreras;
    private JComboBox<carrerasModel>        cbxCarrerasList;
    private JLabel                          lblParticipacion;
    private JComboBox<participacionModel>   cbxParticipacionList;                      
    private JLabel                          lblName;
    private JTextField                      txtName;
    private JButton                         btnSearch;
    private JButton                         btnAddPiloto;
    private JButton                         btnDeletePiloto;
    private JButton                         btnTablaPilotos;
    private JTable                          tblResults;

    
    /**
     * Constructor of the ControlsPanel class.
     * @param resultsPanel
     */
    public ControlsPanel(ResultsPanel resultsPanel){
        this.tblResults = resultsPanel.getTblResults();
        initComponents();
    }


    private void initComponents(){
        setLayout(new GridLayout(3,1));
        InitialData initialData = new InitialData();
        
        //Complete pilotos info
        this.setTblResults(initialData.getPilotos());
        
        //Seleccion de escuderias
        this.lblcarreras = new JLabel ("Carreras");
        add(this.getLblcarreras());
        
        this.cbxCarrerasList = new JComboBox();        
        this.cbxCarrerasList.setModel(new DefaultComboBoxModel<>(initialData.getCarreras().toArray(new carrerasModel[initialData.getCarreras().size()])));
        this.cbxCarrerasList.setSelectedIndex(0);
        add(this.getCbxCarrerasList());  
        
        ChangeEvent changeEvent = new ChangeEvent(this);
        this.getCbxCarrerasList().addActionListener(changeEvent);
        
        // Exhibition selection
        this.lblParticipacion = new JLabel("Fecha Participacion");
        add(this.getLblParticipacion());
        
        this.cbxParticipacionList = new JComboBox();
        this.setCbxParticipacionList(initialData.getParticipacion());
        add(this.getCbxParticipacionList());
        
        //Name Pattern
        this.lblName = new JLabel ("Nombre del piloto");
        add(this.getLblName());
        
        this.txtName = new JTextField();
        add(this.getTxtName());
        
        //Search Button
        this.btnSearch = new JButton("Buscar");
        add(this.btnSearch);
        
        ClickEvent clickEvent = new ClickEvent(this);
        this.btnSearch.addActionListener(clickEvent);
        
        //Insert Button
        this.btnAddPiloto = new JButton("Agregar Nuevo Piloto");
        add(this.getBtnAddPiloto());
        this.getBtnAddPiloto().addActionListener(clickEvent);
        
        this.btnDeletePiloto = new JButton("Eliminar Piloto");
        add(this.getBtnDeletePiloto());
        this.getBtnDeletePiloto().addActionListener(clickEvent);
        
        this.btnTablaPilotos = new JButton("Ver Tabla Pilotos");
        add(this.getBtnTablaPilotos());
        this.getBtnTablaPilotos().addActionListener(clickEvent);
           
 }

    /**
     * @return the lblescuderias
     */
    public JLabel getLblcarreras() {
        return lblcarreras;
    }

    
/**
     * @return the cbxCarrerasList
     */
    public JComboBox<carrerasModel> getCbxCarrerasList() {
        return cbxCarrerasList;
    }

    /**
     * @return the lblParticipacion
     */
    public JLabel getLblParticipacion() {
        return lblParticipacion;
    }

    /**
     * @return the cbxParticipacionList
     */
    public JComboBox<participacionModel> getCbxParticipacionList() {
        return cbxParticipacionList;
    }
     

    /**
     * @return the lblName
     */
    public JLabel getLblName() {
        return lblName;
    }

    /**
     * @return the txtName
     */
    public JTextField getTxtName() {
        return txtName;
    }

    /**
     * @return the btnSearch
     */
    public JButton getBtnSearch() {
        return btnSearch;
    }
    
    
    /**
     * @return the tblResults
     */
    public JTable getTblResults() {
        return tblResults;
    }
    
    

    /**
     * @param cbxCarreraList the cbxCarreraList to set
     */
    public void setCbxParticipacionList(ArrayList<participacionModel> participacion) {       
        this.cbxParticipacionList.setModel(new DefaultComboBoxModel<>(participacion.toArray(new participacionModel[participacion.size()])));
        this.getCbxParticipacionList().setSelectedIndex(0);
    }
    
    
    
    /**
     * @param tblResults the tblResults to set
     */
    public void setTblResults(ArrayList <pilotosModel> pilotos) {
        String[] headers = {"ID piloto", "Nombre Piloto", "Millas Recorridas", "Nombre Escuderia",  "Patrocinador", "Carreras Ganadas", "Nombre Carrera", "Fecha Carrera", "Posicion"};
        this.tblResults.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblResults.setModel(tableModel);
        for(int i = 0; i<pilotos.size(); i++){
            tableModel.addRow(pilotos.get(i).toArray());
        }        
    }

    /**
     * @return the btnAddPiloto
     */
    public JButton getBtnAddPiloto() {
        return btnAddPiloto;
    }
    
    public JButton getBtnDeletePiloto(){
        return btnDeletePiloto;
    }
    
    public JButton getBtnTablaPilotos(){
        return btnTablaPilotos;
    }
    
    
}
