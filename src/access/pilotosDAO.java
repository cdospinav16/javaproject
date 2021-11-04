
package access;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.pilotosModel;
import utils.ConnectionDB;


public class pilotosDAO {
    private Connection conn = null;
    
    
    public ArrayList<pilotosModel> obtenerPilotos(){
        ArrayList<pilotosModel> pilotos = new ArrayList();
        try {
            if (conn == null)
                conn = ConnectionDB.createConnection();
        
            String sql = "SELECT pilotos.cod_piloto, pilotos.nombre, pilotos.millas_recorridas, escuderia.nombre, escuderia.patrocinador, escuderia.carreras_ganadas,\n" +
                "carreras.nombre_carrera, participacion.fecha,  participacion.posicion\n" +
                "FROM pilotos\n" +
                "join escuderia on cod_escuderia_fk = escuderia.cod_escuderia\n" + 
                "join participacion on participacion.cod_piloto_fk = pilotos.cod_piloto\n" +
                "join carreras on participacion.id_carrera_fk = carreras.id_carrera;";
            
        Statement statement = conn.createStatement();
        ResultSet result = statement.executeQuery(sql);
        while (result.next()){
            pilotosModel piloto = new pilotosModel(result.getInt(1), result.getString(2), result.getDouble(3), 
                    result.getString(4), result.getString(5), result.getInt(6), result.getString(7), result.getString(8), result.getInt(9) );
            pilotos.add(piloto);
        }
        }
            catch (SQLException ex){
                    JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()
                                                    + "\nError :" + ex.getErrorCode());
    } 
        return pilotos;
    }
    
    
    public ArrayList<pilotosModel> obtenerPilotosTabla(){
        ArrayList<pilotosModel> pilotos = new ArrayList();
        try{
            if(conn == null)
                conn = ConnectionDB.createConnection();
            
            String sql = "SELECT cod_piloto, nombre, millas_recorridas, combustible_usado, cod_escuderia_fk FROM pilotos;";
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(sql);
            while (result.next()){
                pilotosModel piloto = new pilotosModel(result.getInt(1), result.getString(2), result.getDouble(3),
                                                            result.getInt(4), result.getInt(5));
                pilotos.add(piloto);                
            }
        }   catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()
                                                + "\nError :" + ex.getMessage());
        }   return pilotos;
    } 
    
    
    
    
    public ArrayList<pilotosModel> obtenerPilotoFiltrado(int idCarrera, int idParticipacion, String participacionFecha, String nombrePiloto) {
        ArrayList<pilotosModel> pilotos = new ArrayList<>();
        int case_ = -1;
        try {
            if (conn == null) {
                conn = ConnectionDB.createConnection();
            }
            String sql = "SELECT pilotos.cod_piloto, pilotos.nombre, pilotos.millas_recorridas, escuderia.nombre, escuderia.patrocinador, escuderia.carreras_ganadas,\n" +
                "carreras.nombre_carrera, participacion.fecha,  participacion.posicion\n" +
                "FROM pilotos\n" +
                "join escuderia on cod_escuderia_fk = escuderia.cod_escuderia\n" +
                "join participacion on participacion.cod_piloto_fk = pilotos.cod_piloto\n" +
                "join carreras on participacion.id_carrera_fk = carreras.id_carrera"
                + " WHERE pilotos.nombre LIKE ?";
            if (idCarrera != -1) {
                if(idParticipacion != -1){
                    sql += " AND participacion.id_participacion=?;";
                    case_ = 1;               
            }   else {
                    sql += " AND participacion.id_carrera_fk=?;";
                    case_ = 2;
                }
        }
            else if (idParticipacion != -1){
                sql += " AND participacion.fecha=?;";
                case_ = 3;
            }
            System.out.println(case_);
            PreparedStatement statement = conn.prepareStatement(sql);
            System.out.println(sql);
            statement.setString(1, "%"+nombrePiloto+"%");
            switch(case_){
                case 1: statement.setInt(2, idParticipacion);   break;
                case 2: statement.setInt(2, idCarrera);         break;
                case 3: statement.setString(2, participacionFecha); break;                                     
            } 
            System.out.println(statement.toString());
            ResultSet result = statement.executeQuery();
            
            while (result.next()){
                pilotosModel pilotosInd = new pilotosModel(result.getInt(1), result.getString(2), result.getDouble(3), result.getString(4), result.getString(5),result.getInt(6),result.getString(7),result.getString(8), result.getInt(9));
                pilotos.add(pilotosInd);
            }                      
    }   catch (SQLException ex){
            JOptionPane.showMessageDialog(null, "Codigo : " + ex.getErrorCode()
                                            + "\nError :" + ex.getMessage());
    } return pilotos;
}
            
    
  
    
    public void agregarPiloto(pilotosModel piloto){
        try{
            if (conn == null){
                conn = ConnectionDB.createConnection();
            
            String sql = "INSERT INTO pilotos(cod_piloto, nombre, millas_recorridas, combustible_usado, cod_escuderia_fk) "
                    + "VALUES (?, ?, ?, ?, ?);";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, piloto.getCodPiloto());
            statement.setString(2, piloto.getNombre());
            statement.setDouble(3, piloto.getMillasRecorridas());
            statement.setInt(4, piloto.getCombustibleUsado());
            statement.setInt(5, piloto.getCodEscuderia());
            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0){
                JOptionPane.showMessageDialog(null, "Registro Agregado de manera exitosa");
                System.out.println("Completado");
            }
            else    
                    JOptionPane.showMessageDialog(null, "Error al agregar el registro");
                    System.out.println("Eror");               
            conn.close();
            } 
        } catch (SQLException ex){
            ex.printStackTrace();        
        }     
    }
    
 
    
    public void eliminarPiloto(int id){
        try {
            if(conn == null)
                conn = ConnectionDB.createConnection();
            String sql = "DELETE FROM pilotos WHERE cod_piloto=?;";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            int rowsDeleted = statement.executeUpdate();
            if  (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(null, "El registro fue borrado exitosamente!");               
                }   
        }   catch (SQLException ex){
                JOptionPane.showMessageDialog(null, "Codigo : "
                                + ex.getErrorCode() + "\nError :" + ex.getMessage() 
                                  + " \nNo puede eliminar la tabla poeque primero debe eliminar el registro con la Llave Foranea"  );
        }       
    }
}
