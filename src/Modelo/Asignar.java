/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Valeria
 */
public class Asignar {
    
    int idAsignar;
    private Dueno dueno;
    private Mascota mascota;

    public Asignar() {
    }

    public Asignar(int idAsignar, Dueno dueno, Mascota mascota) {
        this.idAsignar = idAsignar;
        this.dueno = dueno;
        this.mascota = mascota;
    }

    public int getIdAsignar() {
        return idAsignar;
    }

    public void setIdAsignar(int idAsignar) {
        this.idAsignar = idAsignar;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public Mascota getMascota() {
        return mascota;
    }

    public void setMascota(Mascota mascota) {
        this.mascota = mascota;
    }
    
}
