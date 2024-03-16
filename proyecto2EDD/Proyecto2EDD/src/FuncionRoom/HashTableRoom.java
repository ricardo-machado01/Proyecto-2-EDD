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
public class HashTableRoom {
    private NodeRoom[] hashTable;
    private int size;

    public HashTableRoom() {
        this.size = 300;
        this.hashTable = new NodeRoom[this.size];
    }

    public NodeRoom[] getHashTable() {
        return hashTable;
    }

    public void setHashTable(NodeRoom[] hashTable) {
        this.hashTable = hashTable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void push(Class_Room room) {
        //Funcion para crear el key
        int index = Integer.parseInt(room.getNumero());
        NodeRoom nroom = new NodeRoom(room);
        if(index <= getHashTable().length) {
            if(hashTable[index] == null){
                //System.out.println("es null");
                //System.out.println("[ "+nroom.getClient().getTipo()+","+nroom.getClient().getPiso()+","+nroom.getClient().getNumero()+" ]");
                hashTable[index] = nroom;
            }else{
                NodeRoom node_pointer = getHashTable()[index];
                //System.out.println("no null");
                while(node_pointer.getNext() != null){
                    //System.out.println("[ "+nroom.getClient().getTipo()+","+nroom.getClient().getPiso()+","+nroom.getClient().getNumero()+" ]");
                    node_pointer =  node_pointer.getNext();
                }
                node_pointer.setNext(nroom);
            }
        } else {
            System.out.println("Invalid index");
        }

    }
    
    public void print(){
        for(int i = 0;i < getSize();i++){
            //recibo un node que es la cabeza de un linkedList
            NodeRoom node = getHashTable()[i];
            if(node != null){
                System.out.println("index:"+i);
                while(node != null){
                    Class_Room client = node.getClient();
                    System.out.println("[ "+client.getTipo()+","+client.getPiso()+","+client.getNumero()+" ]");
                    node = node.getNext();
                }
            }
        }
    }
    
    public String ReturnKey(String key){
        for(int i = 0;i < getSize();i++){
            //recibo un node que es la cabeza de un linkedList
            NodeRoom node = getHashTable()[i];
            if(node != null){
                System.out.println("index:"+i);
                while(node != null){
                   
                    Class_Room client = node.getClient();
                    System.out.println("[ "+client.getTipo()+","+client.getPiso()+","+client.getNumero()+" ]");
                    node = node.getNext();
                    if(client.getNumero() == key){
                        return client.getPiso();
                                        
                    }                      
                }
            }
        }
        return null;
    }
    public String BuscarDisponibilidad(String key){
        for(int i = 0;i < getSize();i++){
            //recibo un node que es la cabeza de un linkedList
            NodeRoom node = getHashTable()[i];
            if(node != null){
                System.out.println("index:"+i);
                while(node != null){
                   
                    Class_Room room = node.getClient();
                    node = node.getNext();
                    if(room.getDisponibilidad() == key){
                        System.out.println("[ " + room.getNumero()+ " "+room.getDisponibilidad()+" ]");
                                        
                    }                      
                }
            }
        }
        return null;
    }
//    void search(string s)
//    {
//        //Compute the index by using the hash function
//        int index = hashFunc(s);
//        //Search the linked list at that specific index
//        for(int i = 0;i < hashTable[index].size();i++)
//        {
//            if(hashTable[index][i] == s)
//            {
//                cout << s << " is found!" << endl;
//                return;
//            }
//        }
//        cout << s << " is not found!" << endl;
//    }
//    public NodeRoom[] copyArray(int keyValue) {
//        NodeRoom[] newArray = new NodeRoom[keyValue];
//        for (int i = 0; i < getArray().length; i++) {
//            newArray[i] = getArray()[i];
//        }
//        return newArray;
//    }
    
    //Crea un key en base a suma de los valores ASCII de los caracteres 
    public int createKey(String name, String lastname){
        int sum = 0;
        for(int i = 0;i < name.length();++i){
            sum += name.charAt(i) * (i+1);
        }
        for(int i = 0;i < lastname.length();++i){
            sum += lastname.charAt(i) * (i+1);
        }
        
        int index = sum % getSize();
        //System.out.println("index key:"+index);
        return index;
        
    }
    
}
