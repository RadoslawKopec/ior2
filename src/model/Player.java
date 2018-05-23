package model;


import javax.persistence.*;

@Entity
@Table(name="players")
public class Player extends Person {


    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="team_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_team"))
    private Team team;


    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="position_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_position"))
    private Position position;


    public Team getTeam() {
        return team;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
}
