package Trees;
import Nodes.Node_Room;

/**
 *Clase Arbol de habitaciones.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Tree_Rooms {
     private Node_Room root;

    /**
     * Constructor de la clase Tree_Rooms.
     */
    public Tree_Rooms() {
        this.root = null;
    }
    
    /**
     * Este método se encarga de insertar un nodo dentro del árbol por medio de la recursividad.
     * @param nodo_room Nodo Raíz.
     */
    public void insertar(Node_Room nodo_room) {

        // VALIDAMOS SI LA RAÍZ ESTÁ VACÍA.
        if (this.isEmpty()) {
            this.root = nodo_room;
        } else {
            this.root.insertNodo(nodo_room);
        }
    }
    
    /**
     * Este método busca una habitación por número.
     * @param room_num número de habitación que se desea buscar.
     * @param nodo Nodo raíz del Arbol para poder recorrerlo.
     * @return Retorna el nodo de la habitación deseada.
     */
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
     * Este método busca la habitación de un tipo en específico.
     * @param searchType Tipo de habitación que desea el usuario.
     * @param root Nodo raíz del Arbol para poder recorrerlo.
     * @return Retorna el número de habitación disponible para ese tipo o -1 sino hay disponibilidad.
     */
    public int searchRoomType(String searchType, Node_Room root) {
        int result = -1;
        Node_Room currentNodo = getRoot();
        while (currentNodo != null) {
            if (searchType.equals(currentNodo.getRoom().getType()) && currentNodo.getRoom().isAvailable() == true) {
                result = currentNodo.getRoom().getNumber();
                break;
            }else{
                currentNodo = currentNodo.getRight();
            }
        }
        return result;
    }
 
    // MÉTODO GET.
    public Node_Room getRoot() {
        return root;
    }

    // MÉTODO SET.
    public void setRoot(Node_Room root) {
        this.root = root;
    }
    
    /**
     * Este método comprueba si el Arbol está vacío.
     * @return retorna true si no tiene nodos y false si encuentra al menos uno.
     */
    public boolean isEmpty() {
        return root == null;
    }
}