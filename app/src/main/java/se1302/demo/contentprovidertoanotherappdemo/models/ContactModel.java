package se1302.demo.contentprovidertoanotherappdemo.models;

import java.io.Serializable;

public class ContactModel implements Serializable {
    private String Id, Name, phone;

    public ContactModel() {
    }

    public ContactModel(String id, String name, String phone) {
        Id = id;
        Name = name;
        this.phone = phone;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
