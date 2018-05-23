package basededatos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author {Juan Borrajo Rodriguez}
 */
public class Funciones {

    static String url = "E:\\Sqliteman-1.2.2\\F1.db";
    static Connection connect;
    public static ArrayList<Equipo>equipo=new ArrayList();

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
            PreparedStatement st = connect.prepareStatement("insert into equipo (codeq,nombre,piloto1,piloto2) values (?,?,?,?)");
            st.setString(1, equipo.getCodeq());
            st.setString(2, equipo.getNombre());
            st.setString(3, equipo.getPiloto1());
            st.setString(4, equipo.getPiloto2());
            
            st.execute();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public static void borrarEquipo(String codeq){
        
        try {
            
            PreparedStatement st = connect.prepareStatement("delete from equipo where codeq="+"'"+codeq
            +"'");
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void actualizarEquipo(String campo,String dato,String codeq){
        try {
            PreparedStatement st = connect.prepareStatement("update equipo set "+campo+"="+"'"+dato+"' where codeq='"+codeq+"'");
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static Equipo buscar(String codeq){
        Equipo equipo=null;
        try {
            ResultSet result = null;
            PreparedStatement st = connect.prepareStatement("select * from equipo where codeq='"+codeq+"'");
            result = st.executeQuery();
            equipo=new Equipo(result.getString("codeq"),result.getString("nombre"),result.getString("piloto1"),result.getString("piloto2"));
            
            
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }return equipo;
        
    }

    public static void mostrarEquipos() {
        Funciones.conectar();
        ResultSet result = null;
        
        try {

            PreparedStatement st = connect.prepareStatement("select * from equipo");
            result = st.executeQuery();
            equipo.clear();
            
            
            while (result.next()) {
               equipo.add(new Equipo(result.getString("codeq"),result.getString("nombre"),result.getString("piloto1"),result.getString("piloto2")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        Funciones.cerrar();

    }
    
    public static void ver(){
        for (int i = 0; i < equipo.size(); i++) {
            System.out.println(equipo.get(i).toString());
            
        }
    }

    

}
