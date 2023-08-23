//Alfredo Fernández (275898) - Manuel Morandi (271568)

package interfaz;
import java.awt.*;
import java.awt.event.*;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import obligatorio.*;
import java.util.*;
import javax.swing.*;

public class VentanaObligatorio extends javax.swing.JFrame implements Observer{
    
    public VentanaObligatorio(Sistema sistema) {
        this.modelo = sistema;
        initComponents();
        modelo.addObserver(this);
        //Cargamos los productos del pedido
        aux = new ArrayList<>();
        lstProductos.setListData(aux.toArray());
        //Cargamos el combobox de las categorias
        boxCategorias.removeAllItems();
        modelo.ordenarAlfabetico();
        ArrayList<Categoria> lista = modelo.getListaCategorias();
        for(int i=0;i<lista.size();i++){
            boxCategorias.addItem(lista.get(i));
        }
        cerrar();
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        grpCategorias = new javax.swing.ButtonGroup();
        Panel1 = new javax.swing.JPanel();
        btnElegirCliente = new javax.swing.JButton();
        lblPersona = new javax.swing.JLabel();
        lblObservaciones = new javax.swing.JLabel();
        txtObservaciones = new javax.swing.JTextField();
        optAlfabetico = new javax.swing.JRadioButton();
        optPrioridad = new javax.swing.JRadioButton();
        Panel2 = new javax.swing.JPanel();
        btnPedidos = new javax.swing.JButton();
        btnProductos = new javax.swing.JButton();
        btnCategorias = new javax.swing.JButton();
        btnClientes = new javax.swing.JButton();
        Panel3 = new javax.swing.JPanel();
        boxCategorias = new javax.swing.JComboBox();
        Panel4 = new javax.swing.JPanel();
        btnReiniciar = new javax.swing.JButton();
        lblPedido = new javax.swing.JLabel();
        panelProducto = new javax.swing.JPanel();
        Panel6 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstProductos = new javax.swing.JList();
        btnEliminarItem = new javax.swing.JButton();
        btnGrabarPedido = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(new java.awt.GridLayout(3, 3));

        Panel1.setLayout(new java.awt.GridLayout(3, 3));

        btnElegirCliente.setText("Elegir Cliente");
        btnElegirCliente.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnElegirCliente.setMaximumSize(new java.awt.Dimension(200, 50));
        btnElegirCliente.setMinimumSize(new java.awt.Dimension(200, 50));
        btnElegirCliente.setPreferredSize(new java.awt.Dimension(200, 50));
        btnElegirCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnElegirClienteActionPerformed(evt);
            }
        });
        Panel1.add(btnElegirCliente);

        lblPersona.setMaximumSize(new java.awt.Dimension(200, 50));
        lblPersona.setMinimumSize(new java.awt.Dimension(200, 50));
        lblPersona.setPreferredSize(new java.awt.Dimension(200, 50));
        Panel1.add(lblPersona);

        lblObservaciones.setText("Observaciones:");
        lblObservaciones.setMaximumSize(new java.awt.Dimension(200, 50));
        lblObservaciones.setMinimumSize(new java.awt.Dimension(200, 50));
        lblObservaciones.setPreferredSize(new java.awt.Dimension(200, 50));
        Panel1.add(lblObservaciones);
        Panel1.add(txtObservaciones);

        grpCategorias.add(optAlfabetico);
        optAlfabetico.setSelected(true);
        optAlfabetico.setText("Categorias por orden alfabetico");
        optAlfabetico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optAlfabeticoActionPerformed(evt);
            }
        });
        Panel1.add(optAlfabetico);

        grpCategorias.add(optPrioridad);
        optPrioridad.setText("Categorias por orden de Prioridad");
        optPrioridad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                optPrioridadActionPerformed(evt);
            }
        });
        Panel1.add(optPrioridad);

        getContentPane().add(Panel1);

        Panel2.setLayout(new java.awt.GridLayout(1, 0));

        btnPedidos.setText("Ver Pedidos");
        btnPedidos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnPedidos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnPedidosActionPerformed(evt);
            }
        });
        Panel2.add(btnPedidos);

        btnProductos.setText("Productos");
        btnProductos.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnProductosActionPerformed(evt);
            }
        });
        Panel2.add(btnProductos);

        btnCategorias.setText("Categorias");
        btnCategorias.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriasActionPerformed(evt);
            }
        });
        Panel2.add(btnCategorias);

        btnClientes.setText("Clientes");
        btnClientes.setMargin(new java.awt.Insets(0, 0, 0, 0));
        btnClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnClientesActionPerformed(evt);
            }
        });
        Panel2.add(btnClientes);

        getContentPane().add(Panel2);

        Panel3.setLayout(new java.awt.GridLayout(1, 0));

        boxCategorias.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        boxCategorias.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                boxCategoriasItemStateChanged(evt);
            }
        });
        boxCategorias.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                boxCategoriasActionPerformed(evt);
            }
        });
        Panel3.add(boxCategorias);

        getContentPane().add(Panel3);

        Panel4.setLayout(new java.awt.GridLayout(2, 0));

        btnReiniciar.setText("Reiniciar Pedido");
        btnReiniciar.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        btnReiniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnReiniciarActionPerformed(evt);
            }
        });
        Panel4.add(btnReiniciar);

        lblPedido.setBackground(new java.awt.Color(255, 255, 255));
        lblPedido.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblPedido.setText("Pedido");
        lblPedido.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        Panel4.add(lblPedido);

        getContentPane().add(Panel4);

        panelProducto.setLayout(new java.awt.GridLayout(3, 0));
        getContentPane().add(panelProducto);

        Panel6.setLayout(new java.awt.GridLayout(1, 0));

        lstProductos.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Item 1", "Item 2", "Item 3", "Item 4", "Item 5" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jScrollPane1.setViewportView(lstProductos);

        Panel6.add(jScrollPane1);

        btnEliminarItem.setText("Eliminar Item");
        btnEliminarItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarItemActionPerformed(evt);
            }
        });
        Panel6.add(btnEliminarItem);

        btnGrabarPedido.setText("Grabar Pedido");
        btnGrabarPedido.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGrabarPedidoActionPerformed(evt);
            }
        });
        Panel6.add(btnGrabarPedido);

        getContentPane().add(Panel6);

        setBounds(0, 0, 853, 551);
    }// </editor-fold>//GEN-END:initComponents

    private void boxCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_boxCategoriasActionPerformed
        
    }//GEN-LAST:event_boxCategoriasActionPerformed

    private void btnClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClientesActionPerformed
        VentanaAgregarCliente vent = new VentanaAgregarCliente(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_btnClientesActionPerformed

    private void btnCategoriasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriasActionPerformed
        VentanaCategoria vent = new VentanaCategoria(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_btnCategoriasActionPerformed

    private void btnProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnProductosActionPerformed
        VentanaProducto vent = new VentanaProducto(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_btnProductosActionPerformed

    private void btnPedidosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnPedidosActionPerformed
        VentanaPedidos vent = new VentanaPedidos(modelo);
        vent.setVisible(true);
    }//GEN-LAST:event_btnPedidosActionPerformed

    private void btnElegirClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnElegirClienteActionPerformed
        VentanaElegirCliente vent = new VentanaElegirCliente(modelo);
        vent.setVisible(true);
        
    }//GEN-LAST:event_btnElegirClienteActionPerformed

    private void btnReiniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnReiniciarActionPerformed
        modelo.setSeleccionado(new Cliente());
        txtObservaciones.setText("");
        aux = new ArrayList<>();
        lstProductos.setListData(aux.toArray());
        lblPedido.setText("Pedido");
    }//GEN-LAST:event_btnReiniciarActionPerformed

    private void btnEliminarItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarItemActionPerformed
        Producto selec = (Producto)lstProductos.getSelectedValue();
        aux.remove(selec);
        lstProductos.setListData(aux.toArray());
        mostrarInfo();
    }//GEN-LAST:event_btnEliminarItemActionPerformed

    private void btnGrabarPedidoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGrabarPedidoActionPerformed
        try{
            if(modelo.getSeleccionado().getNombre() != null && aux.size() != 0){
                int nro = modelo.getListaPedidos().size() + 1; //Cuento los pedidos que hay y le sumo 1
                int total = 0;
                for(int i=0;i<aux.size();i++){
                    total += aux.get(i).getPrecio();
                }
                Pedido pedido = new Pedido(nro,modelo.getSeleccionado(),total,txtObservaciones.getText());
                pedido.setProductos(aux);
                modelo.agregarPedido(pedido);
                JOptionPane.showMessageDialog(this, "Pedido realizado", "Éxito", JOptionPane.INFORMATION_MESSAGE);
                modelo.setSeleccionado(new Cliente());
                aux = new ArrayList<>();
                lstProductos.setListData(aux.toArray());
                txtObservaciones.setText("");
                lblPedido.setText("Pedido");
            }
            else{
                JOptionPane.showMessageDialog(this, "Pedido no válido", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        catch(java.lang.NullPointerException e){
            JOptionPane.showMessageDialog(this, "Seleccione un cliente", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btnGrabarPedidoActionPerformed

    private void optAlfabeticoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optAlfabeticoActionPerformed
        boxCategorias.removeAllItems();
        modelo.ordenarAlfabetico();
        ArrayList<Categoria> lista = modelo.getListaCategorias();
        for(int i=0;i<lista.size();i++){
            boxCategorias.addItem(lista.get(i));
        }
    }//GEN-LAST:event_optAlfabeticoActionPerformed

    private void optPrioridadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_optPrioridadActionPerformed
        boxCategorias.removeAllItems();
        modelo.ordenarPrioridad();
        ArrayList<Categoria> lista = modelo.getListaCategorias();
        for(int i=0;i<lista.size();i++){
            boxCategorias.addItem(lista.get(i));
        }
    }//GEN-LAST:event_optPrioridadActionPerformed

    private void boxCategoriasItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_boxCategoriasItemStateChanged
        crearBotones();
    }//GEN-LAST:event_boxCategoriasItemStateChanged
    
    public void crearBotones(){
        panelProducto.removeAll();
        panelProducto.setVisible(false);
        panelProducto.setVisible(true);
        Categoria cat = (Categoria)boxCategorias.getSelectedItem();
        ArrayList<Producto> prods = modelo.buscarProductosPorCategoria(cat);
        if(prods.size()>0){
            for(int i=0;i<prods.size();i++){
                JButton nuevo = new JButton(" ");
                nuevo.setMargin(new Insets(-5, -5, -5, -5));
                nuevo.setBackground(Color.BLACK);
                nuevo.setForeground(Color.WHITE);
                nuevo.setText(prods.get(i).toString());
                nuevo.addActionListener(new ProductoListener());
                panelProducto.add(nuevo);
            }
        }
        panelProducto.revalidate();
    }
    
    private class ProductoListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            JButton cual = ((JButton) e.getSource());
            String texto = (String)cual.getText();
            String separator = "$";
            String[] array = texto.split("\\"+separator);
            String nomb = array[0].trim(); //Tenemos el nombre seguido por un espacio, con el trim se lo sacamos
            Producto prod = modelo.buscarProductoPorNombre(nomb);
            aux.add(prod);
            lstProductos.setListData(aux.toArray());
            mostrarInfo();
        }
    }
    
    public void mostrarInfo(){
        int total = 0;
        for(int i=0;i<aux.size();i++){
            total += aux.get(i).getPrecio();
        }
        lblPedido.setText("Pedido "+(modelo.getListaPedidos().size()+1)+" $"+total);
    }
    
    public void cerrar(){
        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent e){
                guardar();
            }
        });
        
    }
    public void guardar(){
        try{
            FileOutputStream arch = new FileOutputStream("datos");
            ObjectOutputStream out = new ObjectOutputStream(arch);
            out.writeObject(modelo);
            out.close();
        }
        catch(java.io.FileNotFoundException ex){
            
        }
        catch(java.io.IOException ex){
            
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Panel1;
    private javax.swing.JPanel Panel2;
    private javax.swing.JPanel Panel3;
    private javax.swing.JPanel Panel4;
    private javax.swing.JPanel Panel6;
    private javax.swing.JComboBox boxCategorias;
    private javax.swing.JButton btnCategorias;
    private javax.swing.JButton btnClientes;
    private javax.swing.JButton btnElegirCliente;
    private javax.swing.JButton btnEliminarItem;
    private javax.swing.JButton btnGrabarPedido;
    private javax.swing.JButton btnPedidos;
    private javax.swing.JButton btnProductos;
    private javax.swing.JButton btnReiniciar;
    private javax.swing.ButtonGroup grpCategorias;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblObservaciones;
    private javax.swing.JLabel lblPedido;
    private javax.swing.JLabel lblPersona;
    private javax.swing.JList lstProductos;
    private javax.swing.JRadioButton optAlfabetico;
    private javax.swing.JRadioButton optPrioridad;
    private javax.swing.JPanel panelProducto;
    private javax.swing.JTextField txtObservaciones;
    // End of variables declaration//GEN-END:variables
    private ArrayList<Producto> aux;
    private Sistema modelo;

    @Override
    public void update(Observable o, Object arg) {
        //Mostramos el cliente seleccionado
        if(modelo.getSeleccionado().getNombre() != null){ //Si no tiene nombre entonces no fue creado por el usuario, no sirve
            lblPersona.setText(modelo.getSeleccionado().toString());
        }
        else{
            lblPersona.setText("");
        }
        //Mostramos la lista de categorias actualizada y los productos
        boxCategorias.removeAllItems();
        modelo.ordenarAlfabetico();
        if(optPrioridad.isSelected()){
            modelo.ordenarPrioridad();
        }
        ArrayList<Categoria> lista = modelo.getListaCategorias();
        for(int i=0;i<lista.size();i++){
            boxCategorias.addItem(lista.get(i));
        }
        crearBotones();
    }
}
