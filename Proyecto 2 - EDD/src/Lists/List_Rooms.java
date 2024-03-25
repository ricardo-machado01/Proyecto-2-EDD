package Lists;

import Classes.Class_Room;
import Nodes.Node_Room_List;

/**
 * Clase para crear Lista de habitaciones.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class List_Rooms {
    private Node_Room_List head;
    int size;

    /**
     * Constructor de la clase List_Rooms.
     */
    public List_Rooms() {
        this.head = null;
        this.size = 0;
    }
    
    /**
     * Método para insertar al inicio.
     * @param room Habitación que se desea insertar en la lista.
     */
    public void insert(Class_Room room) {
        Node_Room_List newnodo = new Node_Room_List(room);
        if(isEmpty()) {
            setHead(newnodo);
        } else {
            Node_Room_List aux = getHead();
            while (aux.getNext() != null) {
                aux = aux.getNext();
            }
            aux.setNext(newnodo);
        }
        size ++;
    }
    
    /**
     * Método para imprimir la lista de habitaciones.
     * @return Retorna un String con los atributos de las habitación contaneados.
     */
    public String print() {
        Node_Room_List currentNodo = getHead();
        String result = "LISTA:\n";
        
        while (currentNodo != null) {
            result += Integer.toString(currentNodo.getRoom().getNumber()) + "\n";
            currentNodo = currentNodo.getNext();
        }
        return result;
    }
    
    // MÉTODOS GET.
    public Node_Room_List getHead() {
        return head;
    }

    public int getSize() {
        return size;
    }

    // MÉTODOS SET.
    public void setHead(Node_Room_List head) {
        this.head = head;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public boolean isEmpty() {
        return head == null;
    }
}
