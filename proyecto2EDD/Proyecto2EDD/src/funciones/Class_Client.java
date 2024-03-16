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
class Class_Client {
    private String id;
    private String name;
    private String lastname;
    private String email;
    private String gender;
    private String phone;
    private String room_number;

    public Class_Client(String id, String name, String lastname, String email, String gender, String phone, String room_number) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.gender = gender;
        this.phone = phone;
        this.room_number = room_number;
    }

    public String showInfo() {
        String result = "";
        result += "Nombre y apellido: " + name + " " + lastname + "\n";
        result += "Cédula: " + id + "\n";
        result += "Email: " + email + "\n";
        result += "Género: " + gender + "\n";
        result += "Telefono: " + phone + "\n";
        return result;
    }

    // MÉTODOS GET.
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getGender() {
        return gender;
    }

    public String getPhone() {
        return phone;
    }
    
    public String getRoomNumber() {
        return room_number;
    }
    
    // MÉTODOS SET.
    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    public void setRoomNumber(String room_number) {
        this.room_number = room_number;
    }
}

