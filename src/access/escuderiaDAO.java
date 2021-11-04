
package access;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.escuderiaModel;
import utils.ConnectionDB;


public class escuderiaDAO {
    private Connection conn = null;
    
    public ArrayList<escuderiaModel> obtenerEscuderias(){
        ArrayList<escuderiaModel> escuderias = new ArrayList();
        
        try {
            if(conn == null)
                conn = ConnectionDB.createConnection();
            
            String sql = "SELECT cod_escuderia, nombre, patrocinador, "
                    + "carreras_ganadas, fecha_ingreso_formula FROM escuderia;";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                escuderiaModel escuderia = new escuderiaModel(result.getInt(1), result.getString(2), result.getString(3),
                         result.getInt(4), result.getString(5));
                escuderias.add(escuderia);
            }
        }   catch (SQLException ex){
               JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()
                                                + "\nError :" + ex.getMessage());
        }   
            return escuderias;     
        } 
    }
    

