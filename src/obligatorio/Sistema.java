//Alfredo Fernández (275898) - Manuel Morandi (271568)

package obligatorio;
import java.io.Serializable;
import java.util.*;

public class Sistema extends Observable implements Serializable{
    private ArrayList<Producto> listaProductos;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Categoria> listaCategorias;
    private ArrayList<Pedido> listaPedidos;
    private Cliente seleccionado;
    
    public Sistema(){
        this.listaProductos = new ArrayList<>();
        this.listaClientes = new ArrayList<>();
        this.listaCategorias = new ArrayList<>();
        this.listaPedidos = new ArrayList<>();
        this.seleccionado = new Cliente();
    }

    public ArrayList<Producto> getListaProductos() {
        return listaProductos;
    }

    public void agregarProducto(Producto producto) {
        this.listaProductos.add(producto);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Cliente> getListaClientes() {
        return listaClientes;
    }

    public void agregarCliente(Cliente cliente) {
        this.listaClientes.add(cliente);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void agregarCategoria(Categoria categoria) {
        this.listaCategorias.add(categoria);
        setChanged();
        notifyObservers();
    }

    public ArrayList<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void agregarPedido(Pedido pedido) {
        this.listaPedidos.add(pedido);
        setChanged();
        notifyObservers();
    }

    public Cliente getSeleccionado() {
        return seleccionado;
    }

    public void setSeleccionado(Cliente seleccionado) {
        this.seleccionado = seleccionado;
        setChanged();
        notifyObservers();
    }
    
    public boolean existeCliente(String unNombre){
        boolean retorno = false;
        ArrayList<Cliente> lista = this.getListaClientes();
        for(int i=0;i<lista.size();i++){
            if(unNombre.equals(lista.get(i).getNombre())){
                retorno = true;
            }
        }
        return retorno;
    }
    
    public boolean existeCategoria(String unaDescripcion){
        boolean retorno = false;
        ArrayList<Categoria> lista = this.getListaCategorias();
        for(int i=0;i<lista.size();i++){
            if(unaDescripcion.equals(lista.get(i).getDescripcion())){
                retorno = true;
            }
        }
        return retorno;
    }
    
    public boolean existeProducto(String unNombre){
        boolean retorno = false;
        ArrayList<Producto> lista = this.getListaProductos();
        for(int i=0;i<lista.size();i++){
            if(unNombre.equals(lista.get(i).getNombre())){
                retorno = true;
            }
        }
        return retorno;
    }
    
    public ArrayList<Cliente> buscarClientes(String texto){
        ArrayList<Cliente> lista = new ArrayList<>();
        for(int i=0;i<this.listaClientes.size();i++){
            if(this.listaClientes.get(i).getNombre().toUpperCase().contains(texto.toUpperCase())){
                lista.add(this.listaClientes.get(i));
            }
        }
        return lista;
    }
    
    public ArrayList<Producto> buscarProductosPorCategoria(Categoria cat){
        ArrayList<Producto> lista = new ArrayList<>();
        for(int i=0;i<this.listaProductos.size();i++){
            ArrayList<Categoria> cats = this.listaProductos.get(i).getCategorias();
            if(cats.indexOf(cat) != -1){ //Si no esta, devuelve -1
                lista.add(this.listaProductos.get(i));
            }
        }
        return lista;
    }
    
    public Producto buscarProductoPorNombre(String nombre){
        Producto prod = new Producto();
        for(int i=0;i<this.listaProductos.size();i++){
            if(this.listaProductos.get(i).getNombre().toUpperCase().equals(nombre.toUpperCase())){ 
                prod = this.listaProductos.get(i);
            }
        }
        return prod;
    }
    
    public Categoria buscarCategoria(String nombre){
        Categoria cat = new Categoria();
        for(int i=0;i<this.listaCategorias.size();i++){
            if(this.listaCategorias.get(i).getDescripcion().toUpperCase().equals(nombre.toUpperCase())){ 
                cat = this.listaCategorias.get(i);
            }
        }
        return cat;
    }
    
    public void ordenarAlfabetico(){
        Collections.sort(getListaCategorias(), new Comparator<Categoria>(){
                    public int compare(Categoria prim, Categoria seg){
                        return prim.getDescripcion().toUpperCase().compareTo(seg.getDescripcion().toUpperCase());
                    }
        });
    }
    public void ordenarPrioridad(){
        Collections.sort(getListaCategorias(), new Comparator<Categoria>(){
                    public int compare(Categoria prim, Categoria seg){
                        return prim.getPrioridad()-seg.getPrioridad();
                    }
        });
    }
}
