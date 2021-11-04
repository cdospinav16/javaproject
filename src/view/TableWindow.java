package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class TableWindow extends JFrame {
    public TableWindow(){
        initComponents();                      
    }
    
private void initComponents(){
    setTitle("Tabla Pilotos");
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
    } catch (Exception ex){
        ex.printStackTrace();
    }
    tablePilotos tablepilotos = new tablePilotos();
    setContentPane(tablepilotos);
    add(new FrameTablePilotos((tablepilotos)));
    
    setSize(800, 600);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = getSize();
    setLocation((screenSize.width - frameSize.width) / 2,
                    (screenSize.height - frameSize.height) /2);
    
    setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
    setVisible(true);
          
}
    
}
