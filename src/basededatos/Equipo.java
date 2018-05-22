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
    
    private String codeq,nombre;

    public Equipo() {
    }

    public Equipo(String codeq, String nombre) {
        this.codeq = codeq;
        this.nombre = nombre;
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
    
    
    
}
