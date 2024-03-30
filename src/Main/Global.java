package Main;

import Lists.List_Clients;
import Hashtable.CHashtable;
import Classes.*;
import Nodes.*;
import Trees.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JOptionPane;

/**
 * Clase para crear un objeto de tipo global.
 * @author nicolasplanas
 */
public class Global {
    private static CHashtable clients = new CHashtable(1000);
    private static Tree_Reservations reservations = new Tree_Reservations();
    private static Tree_Rooms rooms = new Tree_Rooms();
    private static String filePathReservations = "\\Users\\pjroj\\OneDrive\\Documents\\Booking_hotel - reservas.csv";
    private static String filePathRooms = "\\Users\\pjroj\\OneDrive\\Documents\\Booking_hotel - habitaciones.csv";
    private static String filePathHistoric = "\\Users\\pjroj\\OneDrive\\Documents\\Booking_hotel - Histórico.csv";
    private static String filePathStatus = "\\Users\\pjroj\\OneDrive\\Documents\\Booking_hotel - estado2.csv";

    /**
     * Este método lee el documento de tipo 'csv' de las reservaciones, crea instancias
     * de tipo 'Class_Client' y 'Class_Reservation' las cuales guarda dentro de un nodo
     * para posteriomente insertalo en el árbol.
     */
    public static void cvsReaderReservations() {
        String line = "";
        int cont = 0;
    
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePathReservations));

            while ((line = br.readLine()) != null) {
                if (cont > 0) {
                    String[] values = line.split(",");
                    Class_Client client = new Class_Client(values[0], values[1], values[2], values[3], values[4], values[6], null, null);
                    Class_Reservation reservation = new Class_Reservation(client, values[5], values[7], values[8]);
                    Node_Reservation nodo_reservation = new Node_Reservation(idInt(client.getId()), reservation);   
                    Global.getReservations().insertar(nodo_reservation);
                }
                cont += 1;
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ups! Algo salio mal con su archivo de reservaciones");
        }
    }

    /**
     * Este método lee el documento de tipo 'csv' de las habitaciones y el histórico, crea instancias
     * de tipo 'Class_Room' y 'Class_Client' las cuales guarda dentro de un nodo
     * para posteriomente insertalo en el árbol.
     */
    public static void cvsReaderRoomsHistory() {
        String line = "";
        String line2 = "";
        
        int cont = 0;
        int cont2 = 0;
        
        try {
            BufferedReader br_historic = new BufferedReader(new FileReader(filePathHistoric));
            BufferedReader br_rooms = new BufferedReader(new FileReader(filePathRooms));

            while ((line = br_rooms.readLine()) != null) {
                List_Clients list = new List_Clients();
                if (cont > 0) {
                    String[] values = line.split(",");
                    Class_Room room = new Class_Room(Integer.parseInt(values[0]), values[1],Integer.parseInt(values[2]), list);
                    Node_Room nodo_room= new Node_Room(room.getNumber(), room);
                    rooms.insertar(nodo_room);
                }
                cont += 1;
            }
            while ((line2 = br_historic.readLine()) != null) {
                Node_Room currentRoom = rooms.getRoot();

                if (cont2 > 0) {
                    String[] values = line2.split(",");
                    Class_Client client = new Class_Client(values[0], values[1], values[2], values[3], values[4], null, values[6], null);
                    Node_Client nodo_client = new Node_Client(client);
                    
                    while (currentRoom.getKey() != Integer.parseInt(nodo_client.getClient().getRoomNumber())) {
                        if (currentRoom.getKey() > Integer.parseInt(nodo_client.getClient().getRoomNumber())) {
                            currentRoom = currentRoom.getLeft();
                        } else {currentRoom = currentRoom.getRight();}
                    } if (currentRoom.getKey() == Integer.parseInt(nodo_client.getClient().getRoomNumber())) {
                        currentRoom.getRoom().getClientHistory().insertBegining(nodo_client);
                        }
                    }
                cont2 += 1;
            }
            br_historic.close();
            br_rooms.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ups! Algo salio mal con su archivo de historico o de habitaciones");
        }
    }

    /**
     * Este método lee el documento de tipo 'csv' de los clientes que se encuentra hospedados
     * actualmente en alguna habitación, crea instancias de tipo 'Class_Client' y las guarda 
     * dentro de un nodo para posteriomente insertalo en un hash table.
     */
    public static void cvsReaderHash() {
        String line = "";
        String roomNum = "";
        String roommates = "";
        String mates = "";
        String client_name = "";
        int cont = 0;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePathStatus));
            //se crea una lista para guardaar las personas que son compañeras de cuarto
            List_Clients listRoommate = new List_Clients();
            
            while ((line = br.readLine()) != null) {
                if (cont > 0) {
                    String[] values = line.split(",");
                    if (!"".equals(values[0])) {
                        Class_Client client = new Class_Client(null, values[1], values[2], values[3], values[4], values[5], values[0], null);
                        clients.addClientTable(client, values[6]);
                        //Si hay usuarios que van juntos este valor se les settear a las siguientes personas con habitación en blanco
                        roomNum = values[0].toString();
                        Node_Client nc = new Node_Client(client);
                        
                        //si la lista tiene solo un cliente, la lista de roommates se resetea
                        if(listRoommate.getSize() == 1 || listRoommate.getSize() == 0){
                            listRoommate.setHead(null);
                            listRoommate.setSize(0);
                            listRoommate.insertBegining(nc);
                        
                        //si la lista tiene más de un cliente
                        }else if(listRoommate.getSize() > 1){
                            //Se leen lo compañeros para crear un String con los nombres de los clientes que comparte un habitación en común
                            Node_Client pointer = listRoommate.getHead();
                            while(pointer != null){
                                if(pointer.getNext() == null){
                                    roommates += pointer.getClient().getName()+" "+pointer.getClient().getLastname();
                                }else{
                                    roommates += pointer.getClient().getName()+" "+pointer.getClient().getLastname()+",";
                                }
                                pointer = pointer.getNext();
                            }
                            String[] mateslist = roommates.split(",");
                            pointer = listRoommate.getHead();
                            
                            //Se agrega a lista de roommates a cada uno de los clientes, sin incluirlo a él mismo en la fila
                            while(pointer != null){
                                client_name = pointer.getClient().getName()+" "+pointer.getClient().getLastname();
                                for (int i = 0; i < (mateslist.length); i++) {
                                    if(!client_name.equals(mateslist[i])){
                                        if(i == (mateslist.length)-1){
                                            mates += mateslist[i];
                                        }else if(client_name.equals(mateslist[i+1]) && (i+1) == (mateslist.length-1)){
                                            mates += mateslist[i];
                                        }else{
                                            mates += mateslist[i]+",";
                                        } 
                                        
                                    }
                                }
                                pointer.getClient().setRoommate(mates);
                                client_name = "";
                                mates = "";
                                pointer = pointer.getNext();
                            }
                            roommates = "";
                            //se reinicia la lista y se inserta el cliente que se leyó que tiene una habitación distinta
                            listRoommate = new List_Clients();
                            listRoommate.insertBegining(nc);
                        }
                    //si se detecta un cliente con habitación vacia se le asigna la habitación del cliente anterior y este se agrega a la lsita de roommates
                    }else if("".equals(values[0])){
                        Class_Client client = new Class_Client(null, values[1], values[2], values[3], values[4], values[5], roomNum, null); 
                        clients.addClientTable(client, values[6]);
                        Node_Client nc = new Node_Client(client);
                        listRoommate.insertBegining(nc);
                    }
                }
                cont += 1;
            }
            br.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "¡Ups! Algo salio mal con su archivo de estado");
        }
    }
    
    /**
     * Este método convierte la cedula de tipo 'String' que recibe del 'csv'
     * y lo convierte en un 'int', al hacerle un 'split(".")' para luego sumar
     * los valores de este array en una variable 'String' vacía la
     * cual se castea a un 'int'.
     * @param value
     * @return 
     */
    private static int idInt(String value) {
        String idStr = "";
        String[] client_id = value.split("\\.");

        for (int i = 0; i < client_id.length; i++) {
            idStr += client_id[i];
        }
        return Integer.parseInt(idStr);
    }

    // MÉTODOS GET.
    public static Tree_Reservations getReservations() {
        return reservations;
    }

    public static Tree_Rooms getRooms() {
        return rooms;
    }

    public static CHashtable getClients() {
        return clients;
    }
}