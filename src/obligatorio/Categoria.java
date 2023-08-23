//Alfredo Fernández (275898) - Manuel Morandi (271568)

package obligatorio;

import java.io.Serializable;

public class Categoria implements Serializable{
    private String descripcion;
    private String detalle;
    private int prioridad;

    public Categoria(String unaDescripcion, String unDetalle, int unaPrioridad){
        this.descripcion = unaDescripcion;
        this.detalle = unDetalle;
        this.prioridad = unaPrioridad;
    }
    
     public Categoria(){
         
     }
    
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public int getPrioridad() {
        return prioridad;
    }

    public void setPrioridad(int prioridad) {
        this.prioridad = prioridad;
    }
    
    @Override
    public String toString(){
        return this.descripcion;
    }
}
