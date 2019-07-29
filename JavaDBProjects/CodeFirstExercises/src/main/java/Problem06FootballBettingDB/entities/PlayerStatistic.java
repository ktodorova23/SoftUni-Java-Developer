//package Problem06FootballBettingDB.entities;
//
//import Problem06FootballBettingDB.embeddables.PlayerGameId;
//
//import javax.persistence.*;
//import java.util.Set;
//
//@Entity(name = "playerGame")
//@Table(name = "player_statistics")
//public class PlayerStatistic {
//
//    @EmbeddedId
//    private PlayerGameId id;
//
//    @Column(name = "scored_goals")
//    private int scoredGoals;
//    @Column(name = "player_assists")
//    private int assists;
//    @Column(name = "played_minutes")
//    private int playedMinutes;
//
//    public PlayerStatistic() {}
//
//    public PlayerGameId getId() {
//        return this.id;
//    }
//
//    public void setId(PlayerGameId id) {
//        this.id = id;
//    }
//
//    public int getScoredGoals() {
//        return this.scoredGoals;
//    }
//
//    public void setScoredGoals(int scoredGoals) {
//        this.scoredGoals = scoredGoals;
//    }
//
//    public int getAssists() {
//        return this.assists;
//    }
//
//    public void setAssists(int assists) {
//        this.assists = assists;
//    }
//
//    public int getPlayedMinutes() {
//        return this.playedMinutes;
//    }
//
//    public void setPlayedMinutes(int playedMinutes) {
//        this.playedMinutes = playedMinutes;
//    }
//}
