package access;

import utils.ConnectionDB;
import model.participacionModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;


public class participacionDAO {
    private Connection conn = null;
    
    public ArrayList<participacionModel> obtenerParticipaciones(){
        ArrayList<participacionModel> participaciones = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.createConnection();
            
            String sql = "SELECT id_participacion, fecha, posicion, id_carrera_fk, cod_piloto_fk "
                    + "FROM participacion;";
            
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                participacionModel participacion = new participacionModel(result.getInt(1), result.getString(2),
                        result.getInt(3), result.getInt(4), result.getInt(5));
                participaciones.add(participacion);
            }          
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()
                                            + "\nError  :" + ex.getMessage());
            
    } return participaciones;
    }
    
    
        public ArrayList<participacionModel>obtenerPresentacionByCarrera(int idCarrera){
            ArrayList<participacionModel> participaciones = new ArrayList();
            try {
                if (conn == null)
                    conn = ConnectionDB.createConnection();
                String sql = "SELECT id_participacion, cod_piloto_fk, fecha, posicion, id_carrera_fk FROM participacion"
                        + " WHERE id_carrera_fk =?;";
                PreparedStatement statement = conn.prepareStatement(sql);
                statement.setInt(1, idCarrera);
                ResultSet result = statement.executeQuery();
                
                while (result.next()){
                    participacionModel participacion = new participacionModel(result.getInt(1), result.getString(2), result.getInt(3), result.getInt(4), result.getInt(5));
                    participaciones.add(participacion);
                }               
            }   catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()
                                                + "\nError :" + ex.getMessage());
            } return participaciones;
        }   
}
