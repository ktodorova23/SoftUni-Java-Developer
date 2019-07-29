//package Problem06FootballBettingDB.embeddables;
//
//import Problem06FootballBettingDB.entities.Game;
//import Problem06FootballBettingDB.entities.Player;
//
//import javax.persistence.Column;
//import javax.persistence.Embeddable;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import java.io.Serializable;
//import java.util.Objects;
//
//@Embeddable
//public class PlayerGameId implements Serializable {
//    @ManyToOne
//    @JoinColumn(name = "player_id", referencedColumnName = "id")
//    private Player player;
//    @ManyToOne
//    @JoinColumn(name = "game_id", referencedColumnName = "id")
//    private Game game;
//
//    public PlayerGameId() {}
//
//    public PlayerGameId(Player player, Game game) {
//        this.player = player;
//        this.game = game;
//    }
//
//    public Player getPlayer() {
//        return player;
//    }
//
//    public void setPlayer(Player player) {
//        this.player = player;
//    }
//
//    public Game getGame() {
//        return game;
//    }
//
//    public void setGame(Game game) {
//        this.game = game;
//    }
//
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        PlayerGameId that = (PlayerGameId) o;
//        return Objects.equals(player, that.player) &&
//                Objects.equals(game, that.game);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(player, game);
//    }
//}
