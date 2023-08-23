//Alfredo Fernández (275898) - Manuel Morandi (271568)

package obligatorio;
import java.util.*;
import interfaz.*;
public class Obligatorio {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        
        VentanaMenu vent = new VentanaMenu(sistema);
        vent.setVisible(true);
    }
}
