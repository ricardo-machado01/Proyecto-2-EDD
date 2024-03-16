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
public class Main {

    public static void main(String[] args) {
//        LinkedListClient c = new LinkedListClient();
        Class_Client p1 = new Class_Client("30456073", "Andrea","Rojas","@hola", "F", "0414.", "2"); 
        Class_Client p2 = new Class_Client("30578142", "Luciano","Ruiz","@hol", "M", "0412", "2"); 
        Class_Client p3 = new Class_Client("30533334", "Luciano","Ruiz","@ho", "M", "041", "3"); 
//        c.insertFinal(p1);
//        c.insertFinal(p2);
//        c.insertFinal(p3);
        //c.print();
        HashTable ht = new HashTable();
        ht.push(p1);
        ht.push(p2);
        ht.push(p3);
        ht.print();
        
    }
    
}
