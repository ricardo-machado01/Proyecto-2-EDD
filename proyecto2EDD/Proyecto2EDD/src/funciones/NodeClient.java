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
class NodeClient {
    private NodeClient next;
    private Class_Client client;
    private int key;

    //Constructor
    public NodeClient(Class_Client client) {
        this.client = client;
        this.key = 0;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }   
    
    public Class_Client getClient() {
        return client;
    }

    public void setClient(Class_Client client) {
        this.client = client;
    }

    public NodeClient getNext() {
        return next;
    }

    public void setNext(NodeClient next) {
        this.next = next;
    }

    
}
