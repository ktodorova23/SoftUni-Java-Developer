//package Problem06FootballBettingDB.entities;
//
//import Problem06FootballBettingDB.embeddables.BetGameId;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name = "bet_games")
//public class BetGame {
//    @EmbeddedId
//    private BetGameId id;
//
//    @ManyToOne
//    @JoinColumn(name = "result_prediction")
//    private ResultPrediction resultPrediction;
//
//    public BetGame() {}
//
//    public BetGameId getId() {
//        return id;
//    }
//
//    public void setId(BetGameId id) {
//        this.id = id;
//    }
//
//    public ResultPrediction getResultPrediction() {
//        return this.resultPrediction;
//    }
//
//    public void setResultPrediction(ResultPrediction resultPrediction) {
//        this.resultPrediction = resultPrediction;
//    }
//}
