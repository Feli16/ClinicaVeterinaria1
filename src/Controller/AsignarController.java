/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Vista.frmAsignar;
import Modelo.Asignar;
import Modelo.AsignarDAO;
import Modelo.Dueno;
import Modelo.Mascota;
import java.awt.event.ActionEvent;
import java.text.ParseException;
import javax.swing.JOptionPane;
import Modelo.DuenoDAO;
import Modelo.MascotaDAO;
import java.awt.event.ActionListener;

/**
 *
 * @author Valeria
 */
public class AsignarController {

    Asignar asignar = new Asignar();
    AsignarDAO asignarDao = new AsignarDAO();
    Dueno dueno = new Dueno();
    Mascota mascota = new Mascota();
    DuenoDAO duenoDAO = new DuenoDAO();
    MascotaDAO mascotaDAO = new MascotaDAO();
    frmAsignar vistaAsignar = new frmAsignar();

    public AsignarController(frmAsignar frm) {
        this.vistaAsignar = frm;
        this.vistaAsignar.btnGuardar.addActionListener((ActionListener) this);
        this.vistaAsignar.btnCancelar.addActionListener((ActionListener) this);
     
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaAsignar.btnGuardar) {
            if (vistaAsignar.cmbNombreDueno.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(vistaAsignar, "Debe seleccionar un Nombre");
            } else if (vistaAsignar.cmbNombreMascota.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(vistaAsignar, "Debe seleccionar un Nombre de la Mascota");
            } else {
                try {
                    agregarAsigacion();
                } catch (ParseException ex) {
                }
            }
        }
        if (e.getSource() == vistaAsignar.btnCancelar) {
            if (e.getSource() == vistaAsignar.btnCancelar) {

            }

        }
    }

    public void agregarAsigacion() throws ParseException {
        Integer idDueno = Integer.valueOf(vistaAsignar.txtIdDueno.getText());
        Integer idMascota = Integer.valueOf(vistaAsignar.txtIdMascota.getText());

        mascota.setIdMascota(idMascota);
        dueno.setIdDueno(idDueno);

        asignar.setDueno(dueno);
        asignar.setMascota(mascota);

        int r = asignarDao.agregarAsignacion(asignar);
        if (r == 1) {
            JOptionPane.showMessageDialog(vistaAsignar, "Relacion agrgada con exito");
            actualizarAsignacion();
            limpiarCampos();
        }

    }

    public void actualizarAsignacion() {

        int idDueno = Integer.parseInt(vistaAsignar.txtIdDueno.getText());
        int idMascota = Integer.parseInt(vistaAsignar.txtIdMascota.getText());

        dueno.setIdDueno(idDueno);
        mascota.setIdMascota(idMascota);
        int r = mascotaDAO.actualizarMascotaAsignar(mascota);
        if (r != 1) {
            JOptionPane.showMessageDialog(vistaAsignar, "Error");

        }

    }

    public void cargarComboMascota() {
        mascotaDAO.cargarComboMascota(vistaAsignar.cmbNombreDueno);
    }

    public void cargarComboDueno() {
        duenoDAO.cargarComboDueno(vistaAsignar.cmbNombreDueno);
    }

    public void iniciar() {
        limpiarCampos();

    }

    public void limpiarCampos() {
        vistaAsignar.txtIdDueno.setText("");
        vistaAsignar.txtIdMascota.setText("");
        cargarComboDueno();
        cargarComboMascota();
    }
}
