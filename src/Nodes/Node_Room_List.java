/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Classes.Class_Room;

/**
 * Clase para crear nodos de tipo habitación para listas enlazadas.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Node_Room_List {
    
    private Class_Room room;
    private Node_Room_List next;

    /**
     * Constructor de la clase Node_Room_List.
     * @param room Objeto de tipo Room que pertenece como elemento para el nodo.
     */
    public Node_Room_List(Class_Room room) {
        this.room = room;
        this.next = null;
    }

    //MÉTODOS GET.
    public Class_Room getRoom() {
        return room;
    }

    public Node_Room_List getNext() {
        return next;
    }
    
    //MÉTODOS SET.
    public void setRoom(Class_Room room) {
        this.room = room;
    }
    
    public void setNext(Node_Room_List next) {
        this.next = next;
    }
}
