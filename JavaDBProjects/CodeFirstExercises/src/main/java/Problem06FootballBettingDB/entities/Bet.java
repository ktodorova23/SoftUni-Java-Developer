//package Problem06FootballBettingDB.entities;
//
//import javax.persistence.*;
//import java.time.LocalDateTime;
//
//@Entity
//@Table(name = "bets")
//public class Bet extends BaseEntity{
//    @Column(name = "bet_money")
//    private double money;
//    @Column(name = "date_time")
//    private LocalDateTime dateTime;
//
//    @ManyToOne
//    @JoinColumn(name = "user_id", referencedColumnName = "id")
//    private User user;
//
//    public Bet() {}
//
//    public double getMoney() {
//        return this.money;
//    }
//
//    public void setMoney(double money) {
//        this.money = money;
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
//    public User getUser() {
//        return this.user;
//    }
//
//    public void setUser(User user) {
//        this.user = user;
//    }
//}
