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
class NodeRoom {
    private NodeRoom next;
    private Class_Room client;
    private int key;

    //Constructor
    public NodeRoom(Class_Room client) {
        this.client = client;
        this.key = 0;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }   
    
    public Class_Room getClient() {
        return client;
    }

    public void setClient(Class_Room client) {
        this.client = client;
    }

    public NodeRoom getNext() {
        return next;
    }

    public void setNext(NodeRoom next) {
        this.next = next;
    }

    
}
