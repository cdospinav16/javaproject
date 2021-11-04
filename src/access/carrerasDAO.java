package access;

import utils.ConnectionDB;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.carrerasModel;



public class carrerasDAO {
    private Connection conn = null;
   
    public ArrayList<carrerasModel> obtenerCarreras(){
        ArrayList<carrerasModel> carreras = new ArrayList();
        try{
            if (conn == null)
                conn = ConnectionDB.createConnection();
            
            String sql = "SELECT id_carrera, nombre_carrera, capacidad_asistentes, nivel_dificultad, "
                    + "techo_disponible FROM carreras;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            
            while (result.next()){
                carrerasModel carrera = new carrerasModel(result.getInt(1), result.getString(2), result.getInt(3),
                        result.getDouble(4),result.getBoolean(5));
            carreras.add(carrera);
            }
        } catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()
                                            + "\nError :" + ex.getMessage());
            
        } return carreras;
    }           
}
