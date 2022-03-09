/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.Date;

/**
 *
 * @author nicol
 */
public class Cita {
    
    private int idCita;
    private Dueno dueno;
    private Veterinario veterinario;
    private Usuario usuario;
    private String asunto;
    private String fechaCita;
    private Date horaCita;
    private Date fechaCreacion;

    public Cita() {
    }

    public Cita(int idCita, Dueno dueno, Veterinario veterinario, Usuario usuario, String asunto, String fechaCita, Date horaCita, Date fechaCreacion) {
        this.idCita = idCita;
        this.dueno = dueno;
        this.veterinario = veterinario;
        this.usuario = usuario;
        this.asunto = asunto;
        this.fechaCita = fechaCita;
        this.horaCita = horaCita;
        this.fechaCreacion = fechaCreacion;
    }

    public int getIdCita() {
        return idCita;
    }

    public void setIdCita(int idCita) {
        this.idCita = idCita;
    }

    public Dueno getDueno() {
        return dueno;
    }

    public void setDueno(Dueno dueno) {
        this.dueno = dueno;
    }

    public Veterinario getVeterinario() {
        return veterinario;
    }

    public void setVeterinario(Veterinario veterinario) {
        this.veterinario = veterinario;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getFechaCita() {
        return fechaCita;
    }

    public void setFechaCita(String fechaCita) {
        this.fechaCita = fechaCita;
    }

    public Date getHoraCita() {
        return horaCita;
    }

    public void setHoraCita(Date horaCita) {
        this.horaCita = horaCita;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

  
    
    
}
