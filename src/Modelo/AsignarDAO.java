/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Valeria
 */
public class AsignarDAO {

    ResultSet rs;

    PreparedStatement ps;
    Connection con;
    Conexion conectar = new Conexion();
    Asignar asignar = new Asignar();

    public int agregarAsignacion( Asignar asignar) {
        int r = 0;
        String sql = "INSERT INTO Asignar (idAsignar, idDueno, idMascota) VALUES (?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, asignar.getIdAsignar());
            ps.setInt(2, asignar.getDueno().getIdDueno());
            ps.setInt(3, asignar.getMascota().getIdMascota());
            r = ps.executeUpdate();
            if (r == 1) {
                return 1;

            } else {
                return 0;
            }

        } catch (SQLException e) {
        }
        return r;
    }
public void filtrarTablaAsignar(JTable table, String criterio, String filtro) {
        String[] titulos = {"idAsignar", "idDueno", "idMascota",};
        String[] registros = new String[3];
        String sql = "SELECT Asignar.idAsignar, Dueno.idDueno, Mascota.idMascota, Venta.IdCliente"
                + "FROM (((Asignar "
                + "INNER JOIN Dueno ON Asignar.idDueno = Dueno.idDueno) "
                + "INNER JOIN Mascota ON Asignar.idMascota = Mascota.idMascota) WHERE " + criterio + " LIKE '%" + filtro + "%'";
        DefaultTableModel model = new DefaultTableModel(null, titulos);
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                registros[0] = rs.getString("idAsignar");
                registros[1] = rs.getString("idDueno");
                registros[2] = rs.getString("idMascota");
                model.addRow(registros);
            }
            table.setModel(model);
        } catch (SQLException e) {
        }
}
    
 public int eliminarAsignar(int idAsignar){
        int r = 0;
        String sql = "DELETE FROM Asignar WHERE idAsginar=" + idAsignar;
        try {
            con = conectar.getConnection();
            ps= con.prepareStatement(sql);
            r = ps.executeUpdate();
            
        } catch (Exception e) {
        }
        return r;
    
        
}
}
