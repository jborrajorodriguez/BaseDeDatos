
package basededatos;



/**
 *
 * @author Juan Borrajo Rodriguez
 */
public class BaseDeDatos {

    
    public static void main(String[] args) {
        Funciones.conectar();
        //Funciones.mostrarEquipos();
      //Funciones.guardarEquipo(new Equipo("3","Renault","Nico Hulkenberg","Carlos Sainz"));
       //Funciones.actualizarEquipo("piloto2","Juan Borrajo","3");
       //Funciones.mostrarEquipos();
       //Funciones.borrarEquipo("3");
       Funciones.mostrarEquipos();
        Funciones.cerrar();
       
        
    }

}
