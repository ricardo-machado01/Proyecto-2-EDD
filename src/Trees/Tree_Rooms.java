package Trees;

import Classes.Class_Room;
import Main.Global;
import Nodes.Node_Room;

/**
 * Clase para crear árbol de habitaciones.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Tree_Rooms {
     private Node_Room root;

    /**
     * Constructor del árbol de habitaciones.
     */
    public Tree_Rooms() {
        this.root = null;
    }
    
    /**
     * Este método se encarga de insertar un nodo dentro del árbol a traves de la recursividad.
     * @param nodo_room 
     */
    public void insertar(Node_Room nodo_room) {

        // VALIDAMOS SI LA RAÍZ ESTÁ VACÍA.
        if (this.isEmpty()) {
            this.root = nodo_room;
        } else {
            this.root.insertNodo(nodo_room);
        }
    }
    
    public Node_Room search(int room_num, Node_Room nodo){
        if (isEmpty()) {
            return null;
        } if (room_num == nodo.getKey()) {
            return nodo;
        } else {
            //Buscando elemento a la izquierda.
            if (room_num < nodo.getKey()) {
                return search(room_num,nodo.getLeft());
            } else {
                return search(room_num,nodo.getRight());
            }
        }
    }

    /**
     * Este metodo busca las habitacion de un tipo en especifico.
     * @param searchType
     * @param root
     * @return 
     */
    public Class_Room searchRoomType(String searchType, Node_Room root) {
        Class_Room result = null;
        Node_Room currentNodo = getRoot();
        
        while (currentNodo != null) {
            if (searchType.equals(currentNodo.getRoom().getType()) && currentNodo.getRoom().getAvailable() == true) {
                result = currentNodo.getRoom();
                break;
            } else {
                currentNodo = currentNodo.getRight();
            }
        }
        return result;
    }

    /**
     * Método para desocupar una habitación.
     * @param room_number
     */
    public void setAvailable(int room_number) {
        Class_Room room = Global.getRooms().search(room_number, this.getRoot()).getRoom();
        room.setAvailability(true);
    }

    // MÉTODO GET.
    public Node_Room getRoot() {
        return root;
    }

    // MÉTODO SET.
    public void setRoot(Node_Room root) {
        this.root = root;
    }
    
    // MÉTODO PARA VALIDAR SI ESTÁ VACÍO.
    public boolean isEmpty() {
        return root == null;
    }
}