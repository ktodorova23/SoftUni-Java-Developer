//package Problem06FootballBettingDB.entities;
//
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Table;
//import javax.validation.constraints.Size;
//
//@Entity
//@Table(name = "positions")
//public class Position {
//    @Id
//    @Size(min = 2, max = 2)
//    @Column(columnDefinition = "CHAR(2)")
//    private String id;
//    @Column(name = "position_description")
//    private String positionDescription;
//
//    public Position() {}
//
//    public String getId() {
//        return this.id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    public String getPositionDescription() {
//        return this.positionDescription;
//    }
//
//    public void setPositionDescription(String positionDescription) {
//        this.positionDescription = positionDescription;
//    }
//}
