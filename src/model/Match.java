package model;


import java.io.Serializable;
import javax.persistence.*;
import java.util.GregorianCalendar;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "matches")
public class Match implements Serializable{

    @OneToMany(mappedBy = "match")
    private Set<Statistic> statistics= new HashSet<>(5);
    public GregorianCalendar getDate() {
        return date;
    }

    public Set<Statistic> getStatistics() {
        return statistics;
    }

    public void setStatistics(Set<Statistic> statistics) {
        this.statistics = statistics;
    }

    public void setDate(GregorianCalendar date) {
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @OneToOne
    @JoinColumn(name="guest_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_guests"),insertable=false, updatable=false)
    private Team guests;

    public Team getGuests() {
        return guests;
    }

    public void setGuests(Team guests) {
        this.guests = guests;
    }

    public Team getHost() {
        return host;
    }

    public void setHost(Team host) {
        this.host = host;
    }

    @OneToOne
    @JoinColumn(name="host_id", foreignKey = @javax.persistence.ForeignKey(name = "FK_host"),insertable=false, updatable=false)
    private Team host;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "match_id")
    private int id;
    private GregorianCalendar date;
    
    @Override
   public String toString(){
       
       return host + " vs " + guests;
   }
}
