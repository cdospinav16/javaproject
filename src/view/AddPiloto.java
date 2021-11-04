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


import model.escuderiaModel;
import model.pilotosModel;


public class AddPiloto extends JFrame implements ActionListener{
    private JLabel                     lblCodPiloto;
    private JTextField                 txtCodPiloto;
    private JLabel                     lblNombre;
    private JTextField                 txtNombre;
    private JLabel                     lblMillasRecorridas;
    private JTextField                 txtMillasRecorridas;
    private JLabel                     lblCombustibleUsado;
    private JTextField                 txtCombustibleUsado;
    private JLabel                     lblCodEscuderia;
    private JTextField                 txtCodEscuderia;
    
    private JLabel                     lblEscuderia;
    private JComboBox<escuderiaModel>  cbxEscuderia;
    
    private JButton                    btnInsertPiloto;
    
    public AddPiloto(){
        initComponents();
    }
    public void initComponents(){
        setTitle("Pilotos - Agregar Piloto");
        setLayout(new GridLayout(8,2));
        InitialData initialData = new InitialData();
        
        this.lblCodPiloto = new JLabel("Cod del Piloto");
        add(this.lblCodPiloto);
        this.txtCodPiloto = new JTextField();
        add(this.txtCodPiloto);
        
        this.lblNombre = new JLabel("Nombre del Piloto");
        add(this.lblNombre);
        this.txtNombre = new JTextField();
        add(this.txtNombre);
        
        this.lblMillasRecorridas = new JLabel("Millas Recorridas");
        add(this.lblMillasRecorridas);
        this.txtMillasRecorridas = new JTextField();
        add(this.txtMillasRecorridas);
        
        this.lblCombustibleUsado = new JLabel("Combustible Usado");
        add(this.lblCombustibleUsado);
        this.txtCombustibleUsado = new JTextField();
        add(this.txtCombustibleUsado);
        
        /*this.lblCodEscuderia = new JLabel("Cod Escuderia");
        add(this.lblCodEscuderia);
        this.txtCodEscuderia = new JTextField();
        add(this.txtCodEscuderia);*/
        
        this.lblEscuderia = new JLabel("Seleccione la escuderia:");
        add(this.lblEscuderia);
        
        this.cbxEscuderia = new JComboBox();
        this.cbxEscuderia.setModel(new DefaultComboBoxModel<>(initialData.getEscuderias().toArray(new escuderiaModel[initialData.getEscuderias().size()])));
        this.cbxEscuderia.setSelectedIndex(0);
        add(this.cbxEscuderia);
        
        this.btnInsertPiloto = new JButton("Agregar a BD");
        add(this.btnInsertPiloto);
        
        this.btnInsertPiloto.addActionListener(this);
        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);     
        
        pack();
        setVisible(true);  
    }

    @Override
    public void actionPerformed(ActionEvent actionEvent) {
        if(actionEvent.getSource() == this.btnInsertPiloto) {
            int codPiloto           = Integer.parseInt( (String)this.txtCodPiloto.getText());
            String nombre           = (String)this.txtNombre.getText();
            double millaRecorridas  = Double.parseDouble( (String)this.txtMillasRecorridas.getText());
            int combustibleUsado    = Integer.parseInt( (String)this.txtCombustibleUsado.getText());
            int codEscuderia        = ((escuderiaModel)this.cbxEscuderia.getSelectedItem()).getCodEscuderia();
                    
            
            pilotosModel piloto = new pilotosModel(codPiloto, nombre, millaRecorridas, combustibleUsado, codEscuderia);
            
            pilotosDAO pilotosDAO = new pilotosDAO();
            pilotosDAO.agregarPiloto(piloto);
                        
           
        }
    }              
}
