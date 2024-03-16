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
public class HashTable {
    private NodeClient[] hashTable;
    private int size;

    public HashTable() {
        this.size = 10001;
        this.hashTable = new NodeClient[this.size];
    }

    public NodeClient[] getHashTable() {
        return hashTable;
    }

    public void setHashTable(NodeClient[] hashTable) {
        this.hashTable = hashTable;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
    
    public void push(Class_Client client) {
        //Funcion para crear el key
        int index = createKey(client.getName(), client.getLastname());;
        NodeClient nclient = new NodeClient(client);
        nclient.setKey(index);
        if(index <= getHashTable().length) {
            if(hashTable[index] == null){
                //System.out.println("es null");
                //System.out.println("[ "+nclient.getClient().getName()+","+nclient.getClient().getLastname()+","+nclient.getClient().getId()+" ]");
                hashTable[index] = nclient;
            }else{
                NodeClient node_pointer = getHashTable()[index];
                //System.out.println("no null");
                while(node_pointer.getNext() != null){
                    //System.out.println("[ "+nclient.getClient().getName()+","+nclient.getClient().getLastname()+","+nclient.getClient().getId()+" ]");
                    node_pointer =  node_pointer.getNext();
                }
                node_pointer.setNext(nclient);
            }
        } else {
            System.out.println("Invalid index");
        }

    }
    
    public void print(){
        for(int i = 0;i < getSize();i++){
            //recibo un node que es la cabeza de un linkedList
            NodeClient node = getHashTable()[i];
            if(node != null){
                System.out.println("index:"+i);
                while(node != null){
                    Class_Client client = node.getClient();
                    System.out.println("[ "+client.getName()+","+client.getLastname()+","+client.getId()+" ]");
                    node = node.getNext();
                }
            }
        }
    }
    
        public String ReturnKey(String key){
        for(int i = 0;i < getSize();i++){
            //recibo un node que es la cabeza de un linkedList
            NodeClient node = getHashTable()[i];
            if(node != null){
                System.out.println("index:"+i);
                while(node != null){
                   
                    Class_Client client = node.getClient();
                    System.out.println("[ "+client.getName()+","+client.getLastname()+","+client.getId()+" ]");
                    node = node.getNext();
                    if(client.getName() == key){
                        return client.getLastname();
                                        
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
//    public NodeClient[] copyArray(int keyValue) {
//        NodeClient[] newArray = new NodeClient[keyValue];
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
