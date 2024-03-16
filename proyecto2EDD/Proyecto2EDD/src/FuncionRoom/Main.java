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
public class Main {

    public static void main(String[] args) {
//        LinkedListClient c = new LinkedListClient();
        Class_Room p1 = new Class_Room("1", "Lujo","1","Si"); 
        Class_Room p2 = new Class_Room("2", "Medio","2","No"); 
        Class_Room p3 = new Class_Room("3", "Bajo","3","Si"); 
//        c.insertFinal(p1);
//        c.insertFinal(p2);
//        c.insertFinal(p3);
        //c.print();
        HashTableRoom ht = new HashTableRoom();
        ht.push(p1);
        ht.push(p2);
        ht.push(p3);
     //  ht.print();
        ht.BuscarDisponibilidad("Si");
    //    System.out.println(ht.ReturnKey("30578142"));
    }
    
}
