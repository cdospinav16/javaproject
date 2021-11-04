package view;

import access.pilotosDAO;
import controller.ClickEvent;
import controller.InitialData;

import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import model.carrerasModel;
import model.escuderiaModel;
import model.participacionModel;
import model.pilotosModel;


public class DeletePiloto extends JFrame implements ActionListener{
    
    private JLabel                     lblCodPiloto;
    private JTextField                 txtCodPiloto;
    private JButton                    btnEliminarPiloto;
    
    public DeletePiloto (){
        initComponents();
    }
        
    public void initComponents(){
        setTitle("Eliminar Pilotos");
        setLayout(new GridLayout(1,2));
        InitialData initialData = new InitialData();
        
        this.lblCodPiloto = new JLabel("Codigo del Piloto");
        add(this.lblCodPiloto);
        
        this.txtCodPiloto = new JTextField();
        add(this.txtCodPiloto);
        
        this.btnEliminarPiloto = new JButton("Eliminar Piloto de BD");
        add(this.btnEliminarPiloto);
        
        this.btnEliminarPiloto.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);       
        
        pack();
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnEliminarPiloto){
            int codPiloto = Integer.parseInt( (String)this.txtCodPiloto.getText());
                       
            pilotosDAO pilotosDao = new pilotosDAO();
            pilotosDao.eliminarPiloto(codPiloto);
            
        }
    }             
}
