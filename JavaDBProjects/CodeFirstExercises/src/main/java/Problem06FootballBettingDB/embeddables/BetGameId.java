//package Problem06FootballBettingDB.embeddables;
//
//import Problem06FootballBettingDB.entities.Bet;
//import Problem06FootballBettingDB.entities.Game;
//
//import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import java.io.Serializable;
//
//@Embeddable
//public class BetGameId implements Serializable {
//    @ManyToOne
//    @JoinColumn(name = "bet_id", referencedColumnName = "id")
//    private Bet bet;
//    @ManyToOne
//    @JoinColumn(name = "game_id", referencedColumnName = "id")
//    private Game game;
//
//    public BetGameId() {}
//
//    public BetGameId(Bet bet, Game game) {
//        this.bet = bet;
//        this.game = game;
//    }
//
//    public Bet getBet() {
//        return bet;
//    }
//
//    public void setBet(Bet bet) {
//        this.bet = bet;
//    }
//
//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game game) {
//        this.game = game;
//    }
//}
