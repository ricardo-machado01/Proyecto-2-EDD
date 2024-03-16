/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package funciones;

/**
 *
 * @author pjroj
 */
public class LinkedListClient {
    private NodeClient head;
    private int size;

    public LinkedListClient() {
        this.head = null;
        this.size = 0;
    }

    public NodeClient getHead() {
        return head;
    }

    public void setHead(NodeClient head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
     public void insertFinal(Class_Client client) {
        NodeClient nodo = new NodeClient(client);
        if (isEmpty()) {
            System.out.println("entro");
            setHead(nodo);
        } else {
            NodeClient pointer = getHead();
            while (pointer.getNext() != null) {
                pointer = pointer.getNext();
            }
            pointer.setNext(nodo);
        }
        size++;
    }
    
    public boolean isEmpty() {
        return getHead() == null;
    }
    
    public void print() {
        NodeClient pointer = getHead();
        while (pointer != null) {
            Class_Client client = pointer.getClient();
            System.out.println("[ "+client.getName()+","+client.getLastname()+","+client.getId()+" ]");
            pointer = pointer.getNext();
        }
    }
}
