package model;


import org.hibernate.annotations.Cascade;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "statistic_id")
    private int id;

    @OneToOne
    @JoinColumn(name="statisticType_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_Type"))
    private StatisticType type;

   @ManyToOne
   @Cascade(org.hibernate.annotations.CascadeType.SAVE_UPDATE)
   @JoinColumn(name="match_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_match"))
    private Match match;



    private int value;

//    @ManyToOne
//    @JoinColumn(name="match_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_match"))
//    private Team team;
//    
//    public Team getTeam(){
//        return team;
//    }
//    
//    public void setTeam(Team t){
//        team = t;
//    }
    
    public Match getMatch() {
        return match;
    }

    public void setMatch(Match match) {
        this.match = match;
    }




    public StatisticType getType() {
        return type;
    }

    public void setType(StatisticType type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
    
        @Override
    public String toString(){

        return type + " : " + value;
    }
}
