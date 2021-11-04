package view;

import controller.InitialData;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.nio.file.Files;
import java.util.ArrayList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import model.pilotosModel;


public class tablePilotos extends JPanel{
    private JTable  tblpilotos;
    private JScrollPane jspPane;
    
    public tablePilotos(){
        //this.tblpilotos = getTblPilotos();
        initComponents();
    }
    
    private void initComponents(){
        
        InitialData initialData = new InitialData();
        this.tblpilotos = new JTable();
        this.tblpilotos.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        
        this.jspPane = new JScrollPane(this.tblpilotos);
        add(jspPane, BorderLayout.CENTER);
        setPreferredSize(new Dimension(1020, 800));                                 
    }
    
    public JTable getTblPilotos(){
        return tblpilotos;
    }
    
    public void setTblPilotos(JTable tblPilotos){
        this.tblpilotos = tblPilotos;
    }                         
}


