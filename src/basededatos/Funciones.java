package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Funciones {

    static String url = "E:\\Sqliteman-1.2.2\\F1.db";//"C:\\Users\\Clase\\AppData\\Roaming\\NetBeans\\Derby\\F1.db";
    static Connection connect;

    public static void conectar() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                System.out.println("Conectado");

            }
        } catch (SQLException ex) {
            System.out.println("No se puede conectar con la base de datos");
        }
    }

    public static void cerrar() {
        try {
            connect.close();
            System.out.println("Cerrado");
        } catch (SQLException ex) {
            System.out.println("No se puede cerrar");
        }
    }

    public static void guardarEquipo(Equipo equipo) {
        try {
            PreparedStatement st = connect.prepareStatement("insert into equipo (codeq,nombre) values (?,?)");
            st.setString(1, equipo.getCodeq());
            st.setString(2, equipo.getNombre());
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void mostrarEquipos() {
        

        Equipo equipo = null;
        ResultSet result = null;
        try {

            PreparedStatement st = connect.prepareStatement("select * from equipo");
            result = st.executeQuery();

            //System.out.println(result);
            while (result.next()) {
                System.out.print("codeq: ");
                System.out.println(result.getString("codeq"));

                

                System.out.print("Nombre: ");
                System.out.println(result.getString("Nombre"));
              

               
                System.out.println("=======================");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        

    }

    

}
