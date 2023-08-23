//Alfredo Fernández (275898) - Manuel Morandi (271568)

package obligatorio;
import java.io.Serializable;
import java.util.*;

public class Pedido implements Serializable{
    private int numero;
    private Cliente cliente;
    private int total;
    private String datos;
    private ArrayList <Producto> productos;

    public Pedido(int unNumero, Cliente unCliente, int unTotal, String unosDatos){
        this.productos = new ArrayList<>();
        numero = unNumero;
        cliente = unCliente;
        total = unTotal;
        datos = unosDatos;
    }
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int num) {
        this.numero = num;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cli) {
        this.cliente = cli;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int tot) {
        this.total = tot;
    }

    public String getDatos() {
        return datos;
    }

    public void setDatos(String dato) {
        this.datos = dato;
    }

    public ArrayList<Producto> getListaProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> prod) {
        this.productos = prod;
    }
    
    public void agregarProducto(Producto prod) {
        this.productos.add(prod);
    }
    
    @Override
    public String toString(){
        return this.numero+") "+this.cliente.getNombre();
    }
}
