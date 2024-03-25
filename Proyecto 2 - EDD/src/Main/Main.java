package Main;
import Interfaces.*;

/**
 * Clase Principal del Proyecto.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Main {

    public static void main(String[] args) {
        
        //Cargamos los hash tables.
        Global.cvsReaderHash();
        
        // Cargamos los datos y creamos los arboles.
        Global.cvsReaderReservations();
        Global.cvsReaderRoomsHistory();
        
        //Convertimos a False a las habitaciones que no se encuentra disponibles.
        Global.getClients().notAvailableRooms();

        // Creamos la ventana principal.
        W w = new W();
        w.setVisible(true);
    }
}