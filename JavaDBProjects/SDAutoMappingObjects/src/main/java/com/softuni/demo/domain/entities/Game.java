package com.softuni.demo.domain.entities;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends BaseEntity {
    @Pattern(regexp = "[A-Z][\\w -’']+", message = "Incorrect title format")
    @Column(name = "title", nullable = false, unique = true)
    private String title;
    @Column(name = "trailer")
    @Size(min = 11, max = 11, message = "Incorrect trailer length")
    private String trailer;
    @Pattern(regexp = "(http:)?(https:)?//.*", message = "Incorrect image thumbnail format")
    @Column(name = "image_thumbnail")
    private String imageThumbnail;
    @Min(0)
    @Column(name = "size", nullable = false, precision = 19, scale = 1)
    private double size;
    @Min(0)
    @Column(name = "price", nullable = false, precision = 19, scale = 2)
    private BigDecimal price;
    @Size(min = 20, max = 1000, message = "Incorrect length of description. Must be between 20 and 1000 symbols long!")
    @Column(name = "description")
    private String description;
    @Column(name = "release_date")
    private LocalDate releaseDate;

    @ManyToMany(targetEntity = User.class, mappedBy = "games", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    private Set<User> users;

    public Game() {}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTrailer() {
        return trailer;
    }

    public void setTrailer(String trailer) {
        this.trailer = trailer;
    }

    public String getImageThumbnail() {
        return imageThumbnail;
    }

    public void setImageThumbnail(String image_thumbnail) {
        this.imageThumbnail = image_thumbnail;
    }

    public double getSize() {
        return size;
    }

    public void setSize(double size) {
        this.size = size;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}
