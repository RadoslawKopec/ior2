package model;


import javax.persistence.*;

@Entity
@Table(name = "positions")
public class Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "position_id")
    private int id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
        @Override
    public String toString(){

        return name;
    }
}
