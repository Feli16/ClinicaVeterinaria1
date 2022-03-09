/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import Modelo.Dueno;
import Modelo.Mascota;
import Modelo.MascotaDAO;
import Vista.frmMascota;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultBoundedRangeModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ControllerMascota implements ActionListener {

    Dueno dueno = new Dueno();
    MascotaDAO mascotaDao = new MascotaDAO();
    Mascota mascota = new Mascota();
    frmMascota vistaMascota = new frmMascota();
    DefaultTableModel modelo  = new DefaultTableModel();
    public ControllerMascota(frmMascota frm) {
        this.vistaMascota = frm;
        this.vistaMascota.btnGuardar.addActionListener(this);
        this.vistaMascota.btnCancelar.addActionListener(this);
        this.vistaMascota.btnRefrescar.addActionListener(this);
        this.vistaMascota.btnEditar.addActionListener(this);
        this.vistaMascota.btnEliminar.addActionListener(this);
        this.vistaMascota.btnBuscar.addActionListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == vistaMascota.btnGuardar) {
            if (vistaMascota.txtNombre.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe ingresar un nombre");
            } else if (vistaMascota.cmbGenero.getSelectedIndex() == 0) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe seleccionar un genero");
            } else if (vistaMascota.txtRaza.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe ingresar una raza");
            } else if (vistaMascota.txtTipo.getText().isEmpty()) {
                JOptionPane.showMessageDialog(vistaMascota, "Debe ingresar un tipo");

            } else {
                agregarMascota();
              
                
            }
        }
        if (e.getSource() == vistaMascota.btnBuscar) {
            filtrarTablaMascota(vistaMascota.tblDatos, vistaMascota.txtBuscar.getText());
        }

        if (e.getSource() == vistaMascota.btnRefrescar) {
            filtrarTablaMascota(vistaMascota.tblDatos, "");
        }

        if (e.getSource() == vistaMascota.btnEliminar) {
            eliminarMascota();
        }
        if (e.getSource() == vistaMascota.btnEditar) {

        }

    }

    public void agregarMascota() {
        String nombreMascota = vistaMascota.txtNombre.getText();
        String genero = vistaMascota.cmbGenero.getSelectedItem().toString();
        String tipo = vistaMascota.txtTipo.getText();
        String raza = vistaMascota.txtRaza.getText();
        Boolean activo = vistaMascota.cbxActivo.isSelected();
        mascota.setDueno(dueno);
        mascota.setNombreMascota(nombreMascota);
        mascota.setGenero(genero);
        mascota.setTipo(tipo);
        mascota.setRaza(raza);
        mascota.setActivo(activo);

        int r = mascotaDao.agregarMascota(mascota);

        if (r == 1) {
            JOptionPane.showMessageDialog(vistaMascota, "Mascota agregada con éxito");
            filtrarTablaMascota(vistaMascota.tblDatos, "");
             limpiarCampos();
            
           
        } else {
            JOptionPane.showMessageDialog(vistaMascota, "Mascota NO agregada con éxito");
        }

    }

    public void filtrarTablaMascota(JTable table, String filtro) {
        mascotaDao.filtrarTablaPorMascota(vistaMascota.tblDatos, "");
    }

    public void actualizarMascota() {
        if (vistaMascota.txtIdMascota.getText().equals("")) {
            JOptionPane.showMessageDialog(vistaMascota, "Por favor selecione una mascota de la tabla");
        } else {
            int idMascota = Integer.parseInt(vistaMascota.txtIdMascota.getText());
            String nombreMasctoa = vistaMascota.txtNombre.getText();
            String genero = vistaMascota.cmbGenero.getSelectedItem().toString();
            String tipo = vistaMascota.txtTipo.getText();
            Boolean activo = vistaMascota.cbxActivo.isSelected();
            mascota.setIdMascota(idMascota);
            mascota.setNombreMascota(nombreMasctoa);
            mascota.setGenero(genero);
            mascota.setTipo(tipo);
            mascota.setRaza(tipo);
            mascota.setActivo(activo);
            int r = mascotaDao.actualizarMascota(mascota);

            if (r == 1) {
                JOptionPane.showMessageDialog(vistaMascota, "Mascota actualizado con éxito");
                limpiarCampos();
                filtrarTablaMascota(vistaMascota.tblDatos, "");

            } else {
                JOptionPane.showMessageDialog(vistaMascota, "Mascota no fue registrado");
            }

        }
    }

    public void eliminarMascota() {
        int fila = vistaMascota.tblDatos.getSelectedRow();
        if (fila == -1) {
            JOptionPane.showMessageDialog(vistaMascota.tblDatos, "Debe seleccionar un registro");

        } else {
            int id = Integer.parseInt(vistaMascota.tblDatos.getValueAt(fila, 0).toString());
            mascotaDao.eliminarMascota(id);
            JOptionPane.showMessageDialog(vistaMascota.tblDatos, "Mascota Eliminada con éxito ");
            limpiarCampos();
            filtrarTablaMascota(vistaMascota.tblDatos, "");
        }
    }

public void listarMascota(JTable table){
    modelo = (DefaultTableModel) table.getModel();
        table.setModel(modelo);
        limpiarTabla(table, modelo);
         List<Mascota> lista = mascotaDao.listaMascota();
        Object[] objeto = new Object[5];
        for (int i = 0; i < lista.size(); i++) {
            objeto[0] = lista.get(i).getIdMascota();
            objeto[1] = lista.get(i).getNombreMascota();
            objeto[2] = lista.get(i).getGenero();
            objeto[3] = lista.get(i).getTipo();
            objeto[4] = lista.get(i).getRaza();
            objeto[5] = lista.get(i).isActivo();
            modelo.addRow(objeto);
        }

 

        table.setRowHeight(35);
        table.setRowMargin(10);
    
    
    
} public void limpiarTabla(JTable table, DefaultTableModel model) {
        for (int i = 0; i < table.getRowCount(); i++) {
            model.removeRow(i);
            i = i - 1;
        }
    }    
    public void iniciar() {
        limpiarCampos();
        filtrarTablaMascota(vistaMascota.tblDatos, "");
    }

    public void limpiarCampos() {
        vistaMascota.txtIdMascota.setText("");
        vistaMascota.txtIdDueno.setText("");
        vistaMascota.txtNombre.setText("");
        vistaMascota.cmbGenero.setSelectedIndex(0);
        vistaMascota.txtTipo.setText("");
        vistaMascota.txtRaza.setText("");
        vistaMascota.cbxActivo.setSelected(false);
    }

}
