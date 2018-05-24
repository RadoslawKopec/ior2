package model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "teams")
public class Team implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "team_id")
    private int id;


    public Set<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Set<Player> players) {
        this.players = players;
    }

    @OneToMany(mappedBy = "team")
    private Set<Player> players= new HashSet<>(15);


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private String name;

    @OneToOne
    @JoinColumn(name="person_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_coach"))
    private Coach coach;


    public Coach getCoach() {
        return coach;
    }

    public void setCoach(Coach coach) {
        this.coach = coach;
    }
    
    @Override
    public String toString(){

        return name;
    }
}
