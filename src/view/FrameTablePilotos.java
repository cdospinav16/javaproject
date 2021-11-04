package view;

import controller.InitialData;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.pilotosModel;


public class FrameTablePilotos extends JPanel{
    private JTable        tblPilotos;
    
    public FrameTablePilotos(tablePilotos tablePanel){
        this.tblPilotos = tablePanel.getTblPilotos();
        initComponents();
                
    }
    public void initComponents(){
        setLayout(new GridLayout(1,1));
        InitialData initialData = new InitialData();
        
        this.setTblPilotos(initialData.getTblPilotos());
    }
    
    public void setTblPilotos(ArrayList<pilotosModel> pilotos){
        String[] headers = {"ID piloto", "Nombre Piloto", "Millas Recorridas", "Combustible Usado", "Cod Escuderia"};
        this.tblPilotos.removeAll();
        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(headers);
        this.tblPilotos.setModel(tableModel);
        for (int i = 0; i<pilotos.size(); i++){
            tableModel.addRow(pilotos.get(i).toArrayMain());
        }
    }
}
