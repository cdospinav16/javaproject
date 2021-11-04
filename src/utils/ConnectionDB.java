package utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.json.simple.*;
import org.json.simple.parser.*;
import static utils.ConnectionDB.createConnection;




public class ConnectionDB {
    
    public static Connection createConnection(){
        JSONParser parser = new JSONParser();   
        Connection conn = null;
           
        
        //Conectar
        try {
            //String credentials_path = System.getProperty("user.home") + "/Desktop/CODIGO/MisionTic2022/Java/Codigo/retos/reto5/reto5/src/utils/db_credentials.json";
            String credentials_path = System.getProperty("user.home") + "/Desktop/java/reto5/reto5/src/utils/db_credentials.json";
            JSONObject jsonObject = (JSONObject)parser.parse(new FileReader(credentials_path));
            
            
            String host = (String)jsonObject.get("db_ip");
            String port = (String)jsonObject.get("db_port");
            String schema_name = (String)jsonObject.get("db_schema_name");
            String username = (String)jsonObject.get("db_user");
            String password = (String)jsonObject.get("db_password");
            String dbURL = "jdbc:mysql://"+host+":"+port+"/"+schema_name;
                   System.out.println(dbURL);

            conn = DriverManager.getConnection(dbURL, username, password);
            if (conn !=null){
                System.out.println("Concetado");
            } 
        } catch (SQLException | FileNotFoundException ex){
            ex.printStackTrace();
        }   catch (IOException | ParseException ex){
            ex.printStackTrace();
        }       
                return conn;               
} 
    
    public static void main(String[] args){
        createConnection();
        
}
}