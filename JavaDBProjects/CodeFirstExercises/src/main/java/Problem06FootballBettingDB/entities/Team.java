//package Problem06FootballBettingDB.entities;
//
//import javax.persistence.*;
//import javax.validation.constraints.Size;
//
//@Entity
//@Table(name = "teams")
//public class Team extends BaseEntity {
//    private String name;
//    private String logo;
//    @Size(min = 3, max = 3)
//    @Column(columnDefinition = "CHAR(3)")
//    private String initials;
//    @ManyToOne
//    @JoinColumn(name = "primary_kit_color")
//    private Color primaryKitColor;
//    @ManyToOne
//    @JoinColumn(name = "secondary_kit_color")
//    private Color secondaryKitColor;
//    @ManyToOne
//    @JoinColumn(name = "town_id")
//    private Town town;
//
//    public Team() {}
//
//    public String getName() {
//        return this.name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getLogo() {
//        return this.logo;
//    }
//
//    public void setLogo(String logo) {
//        this.logo = logo;
//    }
//
//    public String getInitials() {
//        return this.initials;
//    }
//
//    public void setInitials(String initials) {
//        this.initials = initials;
//    }
//
//    public Color getPrimaryKitColor() {
//        return this.primaryKitColor;
//    }
//
//    public void setPrimaryKitColor(Color primaryKitColor) {
//        this.primaryKitColor = primaryKitColor;
//    }
//
//    public Color getSecondaryKitColor() {
//        return this.secondaryKitColor;
//    }
//
//    public void setSecondaryKitColor(Color secondaryKitColor) {
//        this.secondaryKitColor = secondaryKitColor;
//    }
//
//    public Town getTown() {
//        return this.town;
//    }
//
//    public void setTown(Town town) {
//        this.town = town;
//    }
//}
