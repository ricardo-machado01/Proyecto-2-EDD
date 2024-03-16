/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package FuncionRoom;

import funciones.*;

/**
 *
 * @author pjroj
 */
public class LinkedListClient {
    private NodeRoom head;
    private int size;

    public LinkedListClient() {
        this.head = null;
        this.size = 0;
    }

    public NodeRoom getHead() {
        return head;
    }

    public void setHead(NodeRoom head) {
        this.head = head;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
     public void insertFinal(Class_Room client) {
        NodeRoom nodo = new NodeRoom(client);
        if (isEmpty()) {
            System.out.println("entro");
            setHead(nodo);
        } else {
            NodeRoom pointer = getHead();
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
        NodeRoom pointer = getHead();
        while (pointer != null) {
            Class_Room client = pointer.getClient();
            System.out.println("[ "+client.getTipo()+","+client.getPiso()+","+client.getNumero()+" ]");
            pointer = pointer.getNext();
        }
    }
}
