//Alfredo Fernández (275898) - Manuel Morandi (271568)

package obligatorio;
import java.io.Serializable;
import java.util.*;

public class Cliente implements Serializable{
    private String nombre;
    private String direccion;
    private String telefono;

    public Cliente(){
        
    }
    
    public Cliente(String unNombre, String unaDireccion, String unTelefono){
        this.nombre = unNombre;
        this.direccion = unaDireccion;
        this.telefono = unTelefono;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString(){
        return this.nombre+" ("+this.direccion+" - "+this.telefono+")";
    }
}
