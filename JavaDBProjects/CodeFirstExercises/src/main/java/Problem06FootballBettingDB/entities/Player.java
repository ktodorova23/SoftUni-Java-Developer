//package Problem06FootballBettingDB.entities;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "players")
//public class Player extends BaseEntity {
//    private String name;
//    @Column(name = "squad_number")
//    private int squadNumber;
//    @ManyToOne
//    @JoinColumn(name = "team_id")
//    private Team team;
//    @ManyToOne
//    @JoinColumn(name = "position_id")
//    private Position position;
//    @Column(name = "is_injured")
//    private boolean isInjured;
//
//
//
//    public Player() {}
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public int getSquadNumber() {
//        return this.squadNumber;
//    }
//
//    public void setSquadNumber(int squadNumber) {
//        this.squadNumber = squadNumber;
//    }
//
//    public Team getTeam() {
//        return this.team;
//    }
//
//    public void setTeam(Team team) {
//        this.team = team;
//    }
//
//    public Position getPosition() {
//        return this.position;
//    }
//
//    public void setPosition(Position position) {
//        this.position = position;
//    }
//
//    public boolean isInjured() {
//        return this.isInjured;
//    }
//
//    public void setInjured(boolean injured) {
//        isInjured = injured;
//    }
//}
