package model;

import javax.persistence.*;

@Entity
@Table(name = "statisticsType")
public class StatisticType {
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
