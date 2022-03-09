/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

 import java.sql.PreparedStatement;
 import java.sql.Connection;
import java.sql.Date;
 import java.sql.ResultSet;
 import java.sql.SQLException;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class CitaDAO {
    
    PreparedStatement ps;
    Connection con;
    Conexion conectar = new Conexion();
    Cita cita = new Cita();
    ResultSet rs;
    
    
    public int agregarCita(Cita citas){
    
    int r = 0;
    String sql = "INSERT INTO Cita(idCita, idDueno, idVeterinario, idUsuario, asunto, fecha, hora, fechaCreacion) VALUES (?,?,?,?,?,?,?,?)" ;
    
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, cita.getIdCita());
            ps.setInt(2, cita.getDueno().getIdDueno());
            ps.setInt(3, cita.getVeterinario().getIdVeterinario());
            ps.setInt(4, cita.getUsuario().getIdUsuario());
            ps.setString(5, cita.getAsunto());
            ps.setString(6, cita.getFechaCita());
            ps.setDate(7, (Date) cita.getHoraCita());
            ps.setDate(8, (Date) cita.getFechaCreacion());
            
        } catch (SQLException e) {
        }
    
    
    return r;
    }
    
    public void filtrarTablaCitas(JTable table, String criterio, String filtro){
    
    String[] titulos = {"idCita", "idDueno", "idVeterinario", "idUsuario", "asunto", "fecha", "hora", "fechaCreacion"};
    String[] registros = new String[8];
    
    String sql = "SELECT Cita.idCita, Dueno.idDueno, Veterinario.idVeterinario, Usuario.idUsuario, Cita.asunto, Cita.fecha, Cita.hora, Cita.fechaCreacion FROM (((Cita "
            + "INNER JOIN Dueno ON Cita.idDueno = Dueno.idDueno)"
            + "INNER JOIN Veterinario ON Cita.idVeterinario = Veterinario.idVeterinario)"
            + "INNER JOIN Usuario ON Cita.idUsuario = Usuario.idUsuario) WHERE" + criterio + "LIKE '%" + filtro + "%'";
        DefaultTableModel model = new DefaultTableModel();
    
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {                
                registros[0] = rs.getString("idCita");
                registros[1] = rs.getString("idDueno");
                registros[2] = rs.getString("idVeterinario");
                registros[3] = rs.getString("idUsuario");
                registros[4] = rs.getString("asunto");
                registros[5] = rs.getString("fecha");
                registros[6] = rs.getString("hora");
                registros[7] = rs.getString("fechaCreacion");
                model.addRow(registros);
            }
          table.setModel(model);           
        } catch (SQLException e) {
        }
    
    }
    
    public int eliminarCita (int idCita){
    int r = 0;
    String sql = "DELETE FROM Cita WHERE idCita=" + idCita;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();
        } catch (SQLException e) {
        }
    return r;
    }

    
    
    
    
}
