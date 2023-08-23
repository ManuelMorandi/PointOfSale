//Alfredo Fernández (275898) - Manuel Morandi (271568)

package obligatorio;
import java.io.Serializable;
import java.util.*;

public class Producto implements Serializable{
    private ArrayList <Categoria> categorias;
    private String nombre;
    private int precio;

    public Producto(String unNombre, int unPrecio){
        this.categorias = new ArrayList<>();
        this.nombre = unNombre;
        this.precio = unPrecio;
    }
    
    public Producto(){
        
    }
    
    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }
    
    public void setCategorias(ArrayList<Categoria> lista){
        categorias = lista;
    }

    public void agregarCategoria(Categoria categoria) {
        this.categorias.add(categoria);
    }
    
    public void eliminarCategoria(Categoria categoria){
        this.categorias.remove(categoria);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }
    
    @Override
    public String toString(){
        return this.nombre+" $"+this.precio;
    }
}

