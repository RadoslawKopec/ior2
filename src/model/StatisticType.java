package model;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name = "statisticsType")
public class StatisticType implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ststisticType_id")
    private int id;


    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
        @Override
    public String toString(){

        return description;
    }
}
