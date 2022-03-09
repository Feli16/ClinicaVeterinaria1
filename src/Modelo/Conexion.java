/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author nicol
 */
public class Conexion {

    Connection ccn = null;
    Statement st = null;

    /**
     * Método de Conexión
     */
    public Conexion() {
        /**
         * Donde se guarda nuestra base de Datos
         */
        try {
            String rutaFile;
            rutaFile = "./DB//VeterinariaMiMascota.accdb";
            String url = "jdbc:ucanaccess://" + rutaFile;
            ccn = DriverManager.getConnection(url);
            st = ccn.createStatement();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error de Conexión con la BD" + e);
        }

    }

    /**
     * Método que indica la condición de la conexión
     *
     * @return
     */
    public Connection getConnection() {
        return ccn;
    }

    /**
     * Método para hacer desconexión
     */
    public void desconexion() {
        try {
            ccn.close();
            System.exit(0);
        } catch (SQLException e) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE, null, e);
        }
    }
}
