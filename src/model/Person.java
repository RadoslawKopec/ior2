package model;


import java.io.Serializable;
import javax.persistence.*;

/**
 *
 * @author Skrobol Bartłomiej
 */

@Entity
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
@Table(name="persons")
public abstract class Person implements Serializable{

    private String name;
    private String lastname;
public Person(){
    
}
    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "person_id")
    int id;

    public void setId(int id){
        this.id = id;
    }
    
    public int getId(){
        return id;
    }
    public void setName(String im){
        name = im;
    }
    
    public void setLastname(String naz){
        lastname = naz;
    }
    
    public String getName(){
        return name;
    }
    
    public String getLastname(){
        return lastname;
    }
    
        @Override
    public String toString(){

        return name + " " + lastname;
    }
}
