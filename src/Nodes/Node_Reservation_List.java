/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Nodes;

import Classes.Class_Reservation;

/**
 * Clase para crear Nodos Reservación para las listas enlazadas.
 * @author Nicolas Planas, Ricardo Machado, Andrea Rojas, Luciano Ruiz.
 */
public class Node_Reservation_List {
    private Class_Reservation reservation;
    private Node_Reservation_List next;

    /**
     * Constructor de la clase  Node_Reservation_List.
     * @param reservation Reservación que se desea añadir al nodo.
     */
    public Node_Reservation_List(Class_Reservation reservation) {
        this.reservation = reservation;
        this.next = null;
    }

    //MÉTODOS GET.
    public Class_Reservation getReservation() {
        return reservation;
    }

    public Node_Reservation_List getNext() {
        return next;
    }

    //MÉTODOS SET.
    public void setReservation(Class_Reservation reservation) {
        this.reservation = reservation;
    }

    public void setNext(Node_Reservation_List next) {
        this.next = next;
    }
}
