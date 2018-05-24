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
    public static ArrayList<Equipo> equipo = new ArrayList();

    /**
     * Este merodo sirve para conectarse a la base de datos.
     */
    public static void conectar() {
        try {
            connect = DriverManager.getConnection("jdbc:sqlite:" + url);
            if (connect != null) {
                //System.out.println("Conectado");

            }
        } catch (SQLException ex) {
            System.out.println("No se puede conectar con la base de datos");
        }
    }

    /**
     * Este metodo se encarga de cerrar la conexion con la base de datos.
     */
    public static void cerrar() {
        try {
            connect.close();
            // System.out.println("Cerrado");
        } catch (SQLException ex) {
            System.out.println("No se puede cerrar");
        }
    }

    /**
     * Metodo que se encarga de añadir nuevos datos a la base de datos.
     *
     * @param equipo objecto de la clase Equipo.
     */
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

    /**
     * Metodo que se encarga de borrar un equipo.
     *
     * @param codeq codigo de equipo.
     */
    public static void borrarEquipo(String codeq) {

        try {

            PreparedStatement st = connect.prepareStatement("delete from equipo where codeq=" + "'" + codeq
                    + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que se encarga de actualizar algun dato de un equipo.
     *
     * @param campo campo de la tabla.
     * @param dato nuevo dato que se introduce.
     * @param codeq localizador de equipo.
     */
    public static void actualizarEquipo(String campo, String dato, String codeq) {
        try {
            PreparedStatement st = connect.prepareStatement("update equipo set " + campo + "=" + "'" + dato + "' where codeq='" + codeq + "'");
            st.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Metodo que se encarga de buscar denro de la base de datos.
     *
     * @param codeq codigo de equipo.
     * @return un objecto de tipo Equipo.
     */
    public static Equipo buscar(String codeq) {
        Equipo equipo = null;
        try {
            ResultSet result = null;
            PreparedStatement st = connect.prepareStatement("select * from equipo where codeq='" + codeq + "'");
            result = st.executeQuery();
            equipo = new Equipo(result.getString("codeq"), result.getString("nombre"), result.getString("piloto1"), result.getString("piloto2"));

        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        return equipo;

    }

    /**
     * Metodo que se encarga de mostrar los equipos que hay en la base de datos.
     */
    public static void mostrarEquipos() {
        Funciones.conectar();
        ResultSet result = null;

        try {

            PreparedStatement st = connect.prepareStatement("select * from equipo");
            result = st.executeQuery();
            equipo.clear();

            while (result.next()) {
                equipo.add(new Equipo(result.getString("codeq"), result.getString("nombre"), result.getString("piloto1"), result.getString("piloto2")));
            }

        } catch (SQLException ex) {
            Logger.getLogger(Funciones.class.getName()).log(Level.SEVERE, null, ex);
        }
        Funciones.cerrar();

    }

}
