/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package basededatos;

/**
 *
 * @author juan_
 */
public class Equipo {
    
    private String codeq,nombre,piloto1,piloto2;

    public Equipo() {
    }

    public Equipo(String codeq, String nombre, String piloto1, String piloto2) {
        this.codeq = codeq;
        this.nombre = nombre;
        this.piloto1 = piloto1;
        this.piloto2 = piloto2;
    }

    public String getCodeq() {
        return codeq;
    }

    public void setCodeq(String codeq) {
        this.codeq = codeq;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPiloto1() {
        return piloto1;
    }

    public void setPiloto1(String piloto1) {
        this.piloto1 = piloto1;
    }

    public String getPiloto2() {
        return piloto2;
    }

    public void setPiloto2(String piloto2) {
        this.piloto2 = piloto2;
    }

    @Override
    public String toString() {
        return "Nombre del equipo : "+nombre
                +"\nPiloto 1 : "+piloto1
                +"\nPiloto 2 : "+piloto2;
    }

    
    
    
    
}
