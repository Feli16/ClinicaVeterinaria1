/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author nicol
 */
public class MascotaDAO {

    ResultSet rs;
    Connection con;
    PreparedStatement ps;
    Conexion conectar = new Conexion();
    Mascota u = new Mascota();

      public int agregarMascota(Mascota pet) {

        int r = 0;
        String sql = "INSERT INTO Mascota (nombreMascota, genero, tipo, raza, activo) VALUES (?,?,?,?,?)";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pet.getNombreMascota());
            ps.setString(2, pet.getGenero());
            ps.setString(3, pet.getTipo());
            ps.setString(4, pet.getRaza());
            ps.setBoolean(5, pet.isActivo());
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
          public List listaMascota() {
        List<Mascota> datos = new ArrayList<>();
        String sql = "SELECT * FROM Mascota";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Mascota u = new Mascota();
                u.setIdMascota(rs.getInt(1));
                u.setNombreMascota(rs.getString(2));
                u.setGenero(rs.getString(3));
                u.setTipo(rs.getString(4));
                u.setRaza(rs.getString(5));
                u.setActivo(rs.getBoolean(6));
                datos.add(u);
            }
        } catch (SQLException e) {

        }
        return datos;

    }

    public void filtrarTablaPorMascota(JTable table, String filtro) {
        String[] titulos = {"idMascota", "nombreMascota", "genero", "tipo", "raza", "activo"};
        String[] registros = new String[6];
        String sql = "SELECT * FROM Mascota WHERE nombreMascota LIKE '%" + filtro + "%'";
        DefaultTableModel model = new DefaultTableModel();
        model = new DefaultTableModel(null, titulos);
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                //igual que en la BD
                registros[0] = rs.getString("idMascota");
                registros[1] = rs.getString("nombreMascota");
                registros[2] = rs.getString("genero");
                registros[3] = rs.getString("tipo");
                registros[4] = rs.getString("raza");
                registros[5] = rs.getString("activo");
                model.addRow(registros);
            }
            table.setModel(model);

        } catch (SQLException e) {
            System.out.println("ERROR AL BUSCAR DATOS" + e.getMessage());
        }
    }

    public int eliminarMascota(int idMascota) {
        int r = 0;
        String sql = "DELETE FROM Mascota WHERE idMascota=" + idMascota;
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            r = ps.executeUpdate();

        } catch (SQLException e) {
        }
        return r;
    }

    public int actualizarMascota(Mascota pet) {
        int r = 0;
        String sql = "UPDATE Mascota set nombreMascota=?, genero=?, tipo=?, raza=?, activo=? WHERE idMascota=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, pet.getNombreMascota());
            ps.setString(2, pet.getGenero());
            ps.setString(3, pet.getTipo());
            ps.setString(4, pet.getRaza());
            ps.setBoolean(5, pet.isActivo());
            ps.setInt(6, pet.getIdMascota());
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
     public int actualizarMascotaAsignar(Mascota  pet) {
        int r = 0;

        String sql = "UPDATE Mascota set idDueno=? WHERE idMascota=?";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
             ps.setInt(1, pet.getDueno().getIdDueno());
            ps.setInt(2, pet.getIdMascota());
            r = ps.executeUpdate();
            
            if (r == 1) {
                return 1;
            } else {
                return 0;
            }
        } catch (Exception e) {
        }

        return r;
    }

    public void cargarComboMascota(JComboBox combo) {

        combo.removeAllItems();
        combo.addItem("Seleccionar Mascota");
        String sql = "SELECT nombreMascota FROM Mascota";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                combo.addItem(rs.getString("nombreMascota"));
            }
        } catch (SQLException e) {

        }

    }

    public void cargarIdMascota(JComboBox combo, JTextField texto) {

        String sql = "SELECT idMascota FROM Mascota WHERE nombreMascota = '" + combo.getSelectedItem() + "'";
        try {
            con = conectar.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            rs.next();
            texto.setText(String.valueOf(rs.getInt("idMascota")));
        } catch (SQLException e) {
        }
    }

}
