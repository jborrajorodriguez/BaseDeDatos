
package basededatos;

/**
 *
 * @author Juan Borrajo Rodriguez
 */
public class BaseDeDatos {

    
    public static void main(String[] args) {
        Funciones.conectar();
        Funciones.mostrarEquipos();
        Funciones.guardarEquipo(new Equipo("3","Renault"));
        Funciones.mostrarEquipos();
        Funciones.cerrar();
    }

}
