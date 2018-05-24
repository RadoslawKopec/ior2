package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "arenas")
public class Arena implements Serializable{

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;
    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    private String name;

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    private String address;
    
    @Override
    public String toString(){

        return name;
    }
}
