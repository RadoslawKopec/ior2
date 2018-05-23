package model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;



@Entity
@Table(name = "coaches")
public class Coach extends Person {

    public Coach(){
        
    }
    @OneToOne(fetch = FetchType.LAZY)
    @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
    @JoinColumn(name="team_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_TEAM"))
    private Team team;


    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }
    
    
}
