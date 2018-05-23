/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hiberApp;

import java.util.HashSet;
import java.util.Set;
import model.*;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author zti
 */
public class DBCreator {
    private  Position bramkarz;
    private  Position obronca;
    private  Position pomocnik;
    private  Position napastnik;

    private  StatisticType gole;
    private  StatisticType spalone;
    private  StatisticType wolne;
    
    private Team baterex;
    private Team tecza;
    
    private  SessionFactory sessionFactory; //= HiberUtil.getSessionFactory(HiberUtil.Mapping.ANN);
    
    public DBCreator(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
    
     private void createStatiscticTypes(){
        gole = new StatisticType();
        spalone= new StatisticType();
        wolne= new StatisticType();

        gole.setDescription("gole");
        spalone.setDescription("spalone");
        wolne.setDescription("wolne");

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(gole);
        session.save(spalone);
        session.save(wolne);

        tx.commit();
        
        session.close();
    }

    private  void createPositions(){
        bramkarz = new Position();
        bramkarz.setName("bramkarz");

        obronca = new Position();
        obronca.setName("obrońca");

        pomocnik = new Position();
        pomocnik.setName("pomocnik");

        napastnik = new Position();
        napastnik.setName("napastnik");

        Session session =  sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(bramkarz);
        session.save(obronca);
        session.save(pomocnik);
        session.save(napastnik);

        tx.commit();

        session.close();
    }

    private  void createBaterex(){

        baterex = new Team();
         baterex.setName("LKS Baterex Nędza");

        Coach c = new Coach();
        c.setName("Marek");
        c.setLastname("Henzel");
        c.setTeam( baterex);

        Set<Player> players = new HashSet<>();
        Player p1 = new Player();
        p1.setName("Mateusz");
        p1.setLastname("Skwirut");
        p1.setPosition(bramkarz);
        p1.setTeam( baterex);
        players.add(p1);

        Player p2 = new Player();
        p2.setName("Szymon");
        p2.setLastname("Maślanka");
        p2.setPosition(pomocnik);
        p2.setTeam( baterex);
        players.add(p2);

        Player p3 = new Player();
        p3.setName("Szymon");
        p3.setLastname("Paskuda");
        p3.setPosition(obronca);
        p3.setTeam( baterex);
        players.add(p1);


        Player p4 = new Player();
        p4.setName("Denis");
        p4.setLastname("Sobik");
        p4.setPosition(napastnik);
        p4.setTeam( baterex);
        players.add(p4);


         baterex.setCoach(c);
         baterex.setPlayers(players);

        Session session =  sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(c);
        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save( baterex);

        tx.commit();

        session.close();
    }

    // poprawic nazwiska
    private  void createTecza(){

        Team t = new Team();
        t.setName("LKS Tęcza Wielowieś");

        Coach c = new Coach();
        c.setName("Piotr");
        c.setLastname("Żaba");
        c.setTeam(t);

        Set<Player> players = new HashSet<>();
        Player p1 = new Player();
        p1.setName("Tomasz");
        p1.setLastname("Musioł");
        p1.setPosition(bramkarz);
        p1.setTeam(t);
        players.add(p1);

        Player p2 = new Player();
        p2.setName("Wojciech");
        p2.setLastname("Gała");
        p2.setPosition(pomocnik);
        p2.setTeam(t);
        players.add(p2);

        Player p3 = new Player();
        p3.setName("Daniel");
        p3.setLastname("osman");
        p3.setPosition(obronca);
        p3.setTeam(t);
        players.add(p1);


        Player p4 = new Player();
        p4.setName("Marcin");
        p4.setLastname("Burda");
        p4.setPosition(napastnik);
        p4.setTeam(t);
        players.add(p4);


        t.setCoach(c);
        t.setPlayers(players);

        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(c);
        session.save(p1);
        session.save(p2);
        session.save(p3);
        session.save(p4);
        session.save(t);

        tecza = t;
        
        tx.commit();

        session.close();
    }
    
    private void createMatch(){
        Match m = new Match();
        
        m.setGuests(tecza);
        m.setHost(baterex);
        
        Statistic s1 = new Statistic();
        s1.setMatch(m);
        s1.setType(gole);
        s1.setValue(4);
        //s1.setTeam(tecza);
        
        Statistic s2 = new Statistic();
        s2.setMatch(m);
        s2.setType(gole);
        s2.setValue(2);
       // s2.setTeam(baterex);
        
        Statistic s3 = new Statistic();
        s3.setMatch(m);
        s3.setType(wolne);
        s3.setValue(5);
      //  s3.setTeam(tecza);
        
        Set<Statistic> st = new HashSet<>();
        st.add(s3);
        st.add(s2);
        st.add(s1);
        
        m.setStatistics(st);
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();
        
        session.save(m);
        session.save(s1);
        session.save(s2);
        session.save(s3);
        
          tx.commit();

        session.close();
    }
    
    public void create(){
        createPositions();
        createBaterex();
        createTecza();
        createMatch();
        Arena a1 = new Arena();
        a1.setName("GOSIR");
        a1.setAddress("kkkkkk");
        
         Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(a1);
   
        tx.commit();

        session.close();
        
    }
}
