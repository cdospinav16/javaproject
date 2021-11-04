
package view;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;
import javax.swing.UIManager;


public class MainWindow extends JFrame{
    public MainWindow(){
        initComponents();
    }
    
private void initComponents(){
    setTitle("MaFia - MVC");
    
    try {
        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());       
    }   catch (Exception e){
            e.printStackTrace();
    }
    ResultsPanel resultsPanel = new ResultsPanel();
    setContentPane(resultsPanel);
    add(new ControlsPanel(resultsPanel));
    
    setSize(1204, 640);
    
    Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
    Dimension frameSize = getSize();
    setLocation((screenSize.width - frameSize.width) / 2,
                (screenSize.height - frameSize.height) / 2);
     
    
    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    setVisible(true);
}
}
