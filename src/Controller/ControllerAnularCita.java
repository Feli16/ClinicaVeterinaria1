/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;
import Helpers.Helpers;
import Modelo.CitaDAO;
import Modelo.Mascota;
import Modelo.MascotaDAO;
import Vista.frmAnularCitas;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JOptionPane;
import javax.swing.JTable;
/**
 *
 * @author nicol
 */
public class ControllerAnularCita implements ActionListener{
    
    Mascota mascota = new Mascota();
    frmAnularCitas vistaAnular = new frmAnularCitas();
    CitaDAO citaDao = new CitaDAO();
    MascotaDAO mascotaDAO = new MascotaDAO();
    Helpers help = new Helpers();

    @Override
    public void actionPerformed(ActionEvent e) {
      /*  if (e.getSource() == vistaAnular.btnBuscar) {
            filtrarTablaVentas(vistaAnular.tableAnularVentas, vistaAnular.cbVariables.getSelectedItem().toString(), vistaAnular.txtFiltro.getText());
        }
        if (e.getSource() == vistaAnular.btnAnular) {
        }
        if (e.getSource() == vistaAnular.btnRefrescar) {
        }*/
    }
    
    /*public controllerAnularCita(frmAnularCitas frm) {
        this.vistaAnular.btnBuscar.addActionListener(this);
        this.vistaAnular.btnAnular.addActionListener(this);
        this.vistaAnular.btnRefrescar.addActionListener(this);
    }

    public void filtrarTablaCitas(JTable table, String criterio, String filtro) {

        citaDao.filtrarTablaCitas(table, criterio, filtro);
        help.centrarCeldas(table);

    }

    public void iniciar() {

        filtrarTablaCitas(vistaAnular.tablaAnular, "");

    }

    public void eliminarCita() {
        int fila = vistaAnular.tablaAnular.getSelectedRow();

        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaAnular, "Debe seleccionar un registro");
        } else {
            int idCita = Integer.parseInt((String) vistaAnular.tablaAnular.getValueAt(fila, 0));
            int idMascota = Integer.parseInt((String) vistaAnular.tablaAnular.getvalueAt(fila, 1));
            int r = citaDao.eliminarCita(idCita);
            if (r == 1) {
                JOptionPane.showMessageDialog(vistaAnular, "Cita anulada con exito");
                filtrarTablaCitas(vistaAnular.tablaAnular, "");
            }

        }

    }

    public void actualizarMascotaPorVenta(String idMascota) {
        boolean activo = false;
        mascota.setIdMascota(idMascota);
        mascota.setActivo(activo);

        int r = mascotaDAO.actualizarMascota(mascota);

        if (r != 1) {
            JOptionPane.showMessageDialog(vistaAnular, "Error");
        }

    }*/
    
}
