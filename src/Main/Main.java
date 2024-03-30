package Main;

import Interfaces.*;

/**
 * Clase Principal del Proyecto.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Main {

    public static void main(String[] args) {
        
        // CARGAMOS LOS HASH TABLES.
        Global.cvsReaderHash();

        // CARGAMOS LOS ARBOLES.
        Global.cvsReaderReservations();
        Global.cvsReaderRoomsHistory();

        // SETEAMOS LA VARIABLE DE DISPONIBILIDAD DE LAS HABITACIONES A FALSE.
        Global.getClients().setUnavailable();

        // CREAMOS LA VENTANA PRINCIPAL.
        Menu menu = new Menu();
        menu.setVisible(true);
    }
}