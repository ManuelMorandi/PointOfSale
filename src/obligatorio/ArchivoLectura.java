package obligatorio;
import java.io.*;
import java.nio.file.*;
import java.util.*;

public class ArchivoLectura {
    private Scanner in;
    private String linea;
    
    public ArchivoLectura(String unNombre){
        try {
            in = new Scanner(Paths.get(unNombre));
        }
        catch(IOException e){
            System.out.println("Error al abrir el archivo");
        }
    }
    
    // Lee una linea y me dice si hay más
    public boolean hayMasLineas(){
        boolean hay = false;
        linea = null;
        if (in.hasNext()){
            linea = in.nextLine();
            hay = true;
        }
        return hay;
    }
    
    // devuelve la última línea leída
    public String linea(){
        return linea;
    }
    
    public void cerrar(){
        in.close();
    }
}
