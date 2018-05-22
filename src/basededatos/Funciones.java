package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Funciones {
    
    static String url="C:\\Users\\Clase\\AppData\\Roaming\\NetBeans\\Derby\\Formula1";
    static Connection conect;
    
    
    public static void conectar(){
        try {
            conect=DriverManager.getConnection("jdbc:sqlite:"+url);
            if (conect!=null) {
                System.out.println("Conectado");
                
            }
        } catch (SQLException ex) {
            System.out.println("No se puede conectar con la base de datos");
        }
    }
    
    public static void cerrar(){
        try {
            conect.close();
        } catch (SQLException ex) {
            System.out.println("No se puede cerrar");
        }
    }

}
