//Alfredo Fernández (275898) - Manuel Morandi (271568)

package interfaz;
import java.io.*;
import java.util.*;
import javax.swing.*;
import obligatorio.*;

public class VentanaMenu extends javax.swing.JFrame {
    
    public VentanaMenu(Sistema sistema) {
        modelo = sistema;
        initComponents();
        btnArchivo.setEnabled(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        radVacio = new javax.swing.JRadioButton();
        radArchivo = new javax.swing.JRadioButton();
        radGuardado = new javax.swing.JRadioButton();
        btnIniciar = new javax.swing.JButton();
        btnArchivo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        buttonGroup1.add(radVacio);
        radVacio.setText("Iniciar con sistema vacío");
        radVacio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radVacioActionPerformed(evt);
            }
        });

        buttonGroup1.add(radArchivo);
        radArchivo.setText("Iniciar con datos precargados de archivo");
        radArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radArchivoActionPerformed(evt);
            }
        });

        buttonGroup1.add(radGuardado);
        radGuardado.setSelected(true);
        radGuardado.setText("Iniciar con los datos de la ejecución previa");
        radGuardado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                radGuardadoActionPerformed(evt);
            }
        });

        btnIniciar.setText("Iniciar");
        btnIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIniciarActionPerformed(evt);
            }
        });

        btnArchivo.setText("Archivo");
        btnArchivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnArchivoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(radArchivo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 53, Short.MAX_VALUE)
                        .addComponent(btnArchivo))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(radVacio)
                            .addComponent(radGuardado))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnIniciar)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(radVacio)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(radArchivo)
                    .addComponent(btnArchivo))
                .addGap(18, 18, 18)
                .addComponent(radGuardado)
                .addGap(18, 18, 18)
                .addComponent(btnIniciar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIniciarActionPerformed
        if(radGuardado.isSelected()){
            try{
                FileInputStream arch = new FileInputStream("datos");
                ObjectInputStream in = new ObjectInputStream(arch);
                modelo = (Sistema)in.readObject();
                in.close();
            }
            catch(FileNotFoundException e){
                
            }
            catch(IOException e){
                
            }
            catch(ClassNotFoundException e){
                
            }
        }
        else if(radArchivo.isSelected()){
            ArchivoLectura arch = new ArchivoLectura(archivo);
            arch.hayMasLineas();
            int cantClientes = Integer.parseInt(arch.linea().split(";")[0]);
            for(int i=0;i<cantClientes;i++){
                arch.hayMasLineas();
                String linea = arch.linea();
                String[] array = linea.split(";");
                String nomb = array[0];
                String dir = array[1];
                String tel = array[2];
                Cliente cliente = new Cliente(nomb,dir,tel);
                modelo.agregarCliente(cliente);
            }
            arch.hayMasLineas();
            int cantCategorias = Integer.parseInt(arch.linea().split(";")[0]);
            for(int i=0;i<cantCategorias;i++){
                arch.hayMasLineas();
                String linea = arch.linea();
                String[] array = linea.split(";");
                String nomb = array[0];
                String desc = array[1];
                int prioridad = Integer.parseInt(array[2]);
                Categoria categoria = new Categoria(nomb,desc,prioridad);
                modelo.agregarCategoria(categoria);
            }
            arch.hayMasLineas();
            int cantProductos = Integer.parseInt(arch.linea().split(";")[0]);
            for(int i=0;i<cantProductos;i++){
                arch.hayMasLineas();
                String linea = arch.linea();
                String[] array = linea.split(";");
                String nomb = array[0];
                int precio = Integer.parseInt(array[1]);
                Producto prod = new Producto(nomb,precio);
                ArrayList<Categoria> lista = new ArrayList<>();
                for(int j=2;j<array.length;j++){
                    String nombre = array[j];
                    Categoria cat = modelo.buscarCategoria(nombre);
                    lista.add(cat);
                }
                prod.setCategorias(lista);
                modelo.agregarProducto(prod);
            }
            
        }
        VentanaObligatorio vent = new VentanaObligatorio(modelo);
        vent.setVisible(true);
        dispose();
    }//GEN-LAST:event_btnIniciarActionPerformed

    private void btnArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnArchivoActionPerformed
        try{
            JFileChooser fileChooser = new JFileChooser();
            fileChooser.showOpenDialog(fileChooser);
            String ruta = fileChooser.getSelectedFile().getAbsolutePath();
            archivo = ruta;
        }
        catch(java.lang.NullPointerException e){
            
        }
    }//GEN-LAST:event_btnArchivoActionPerformed

    private void radArchivoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radArchivoActionPerformed
        btnArchivo.setEnabled(true);
    }//GEN-LAST:event_radArchivoActionPerformed

    private void radGuardadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radGuardadoActionPerformed
        btnArchivo.setEnabled(false);
    }//GEN-LAST:event_radGuardadoActionPerformed

    private void radVacioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_radVacioActionPerformed
        btnArchivo.setEnabled(false);
    }//GEN-LAST:event_radVacioActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnArchivo;
    private javax.swing.JButton btnIniciar;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JRadioButton radArchivo;
    private javax.swing.JRadioButton radGuardado;
    private javax.swing.JRadioButton radVacio;
    // End of variables declaration//GEN-END:variables
    private Sistema modelo;
    private String archivo;
}
