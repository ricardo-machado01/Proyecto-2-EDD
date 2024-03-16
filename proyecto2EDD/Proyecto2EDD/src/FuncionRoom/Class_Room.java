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
class Class_Room {
    private String numero;
    private String tipo;
    private String piso;
    private String disponibilidad;

    public Class_Room(String numero, String tipo, String piso, String disponibilidad) {
        this.numero = numero;
        this.tipo = tipo;
        this.piso = piso;
        this.disponibilidad = disponibilidad;
    }

    public String showInfo() {
        String result = "";
        
        result += "numero: " + numero + "\n";
        result += "tipo: " + tipo + "\n";
        result += "piso: " + piso + "\n";
        result += "disponibilidad: " + disponibilidad + "\n";
        return result;
    }

    // MÉTODOS GET.
    public String getNumero() {
        return numero;
    }

    public String getTipo() {
        return tipo;
    }

    public String getPiso() {
        return piso;
    }

    public String getDisponibilidad() {
        return disponibilidad;
    }


    
    // MÉTODOS SET.
    public void setNumero(String id) {
        this.numero = id;
    }

    public void setTipo(String name) {
        this.tipo = name;
    }

    public void setPiso(String lastname) {
        this.piso = lastname;
    }

    public void setDisponibilidad(String disponibilidad) {
        this.disponibilidad = disponibilidad;
    }


}

