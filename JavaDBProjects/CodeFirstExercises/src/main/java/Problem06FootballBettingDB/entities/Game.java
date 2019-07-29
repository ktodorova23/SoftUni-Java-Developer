//package Problem06FootballBettingDB.entities;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "games")
//public class Game extends BaseEntity {
//    @ManyToOne
//    @JoinColumn(name = "home_team")
//    private Team homeTeam;
//    @ManyToOne
//    @JoinColumn(name = "away_team")
//    private Team awayTeam;
//    @Column(name = "home_team_goals")
//    private int homeTeamGoals;
//    @Column(name = "away_team_goals")
//    private int awayTeamGoals;
//    @Column(name = "date_time")
//    private LocalDateTime dateTime;
//    @Column(name = "home_team_win_bet_rate")
//    private double homeTeamWinBetRate;
//    @Column(name = "away_team_win_bet_rate")
//    private double awayTeamWinBetRate;
//    @Column(name = "draw_game_bet_rate")
//    private double drawGameBetRate;
//    @ManyToOne
//    @JoinColumn(name = "round_id")
//    private Round round;
//    @ManyToOne
//    @JoinColumn(name = "competition_id")
//    private Competition competition;
//
//    public Game() {}
//
//    public Team getHomeTeam() {
//        return this.homeTeam;
//    }
//
//    public void setHomeTeam(Team homeTeam) {
//        this.homeTeam = homeTeam;
//    }
//
//    public Team getAwayTeam() {
//        return this.awayTeam;
//    }
//
//    public void setAwayTeam(Team awayTeam) {
//        this.awayTeam = awayTeam;
//    }
//
//    public int getHomeTeamGoals() {
//        return this.homeTeamGoals;
//    }
//
//    public void setHomeTeamGoals(int homeTeamGoals) {
//        this.homeTeamGoals = homeTeamGoals;
//    }
//
//    public int getAwayTeamGoals() {
//        return this.awayTeamGoals;
//    }
//
//    public void setAwayTeamGoals(int awayTeamGoals) {
//        this.awayTeamGoals = awayTeamGoals;
//    }
//
//    public LocalDateTime getDateTime() {
//        return this.dateTime;
//    }
//
//    public void setDateTime(LocalDateTime dateTime) {
//        this.dateTime = dateTime;
//    }
//
//    public double getHomeTeamWinBetRate() {
//        return this.homeTeamWinBetRate;
//    }
//
//    public void setHomeTeamWinBetRate(double homeTeamWinBetRate) {
//        this.homeTeamWinBetRate = homeTeamWinBetRate;
//    }
//
//    public double getAwayTeamWinBetRate() {
//        return this.awayTeamWinBetRate;
//    }
//
//    public void setAwayTeamWinBetRate(double awayTeamWinBetRate) {
//        this.awayTeamWinBetRate = awayTeamWinBetRate;
//    }
//
//    public double getDrawGameBetRate() {
//        return this.drawGameBetRate;
//    }
//
//    public void setDrawGameBetRate(double drawGameBetRate) {
//        this.drawGameBetRate = drawGameBetRate;
//    }
//
//    public Round getRound() {
//        return this.round;
//    }
//
//    public void setRound(Round round) {
//        this.round = round;
//    }
//
//    public Competition getCompetition() {
//        return this.competition;
//    }
//
//    public void setCompetition(Competition competition) {
//        this.competition = competition;
//    }
//}
