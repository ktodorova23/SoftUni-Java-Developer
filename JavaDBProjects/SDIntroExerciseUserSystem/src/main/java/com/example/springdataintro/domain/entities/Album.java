package com.example.springdataintro.domain.entities;

import com.example.springdataintro.domain.enums.AlbumAccessibility;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "albums")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(name = "background_color")
    private String backgroundColor;
    @Column(name = "accessibility")
    private AlbumAccessibility albumAccessibility;

    @OneToMany
    private Set<Photo> photoes;

    @ManyToOne
    private User owner;

    public Album() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBackgroundColor() {
        return backgroundColor;
    }

    public void setBackgroundColor(String backgroundColor) {
        this.backgroundColor = backgroundColor;
    }

    public AlbumAccessibility getAlbumAccessibility() {
        return albumAccessibility;
    }

    public void setAlbumAccessibility(AlbumAccessibility albumAccessibility) {
        this.albumAccessibility = albumAccessibility;
    }

    public Set<Photo> getPhotoes() {
        return photoes;
    }

    public void setPhotoes(Set<Photo> photoes) {
        this.photoes = photoes;
    }

    public User getOwner() {
        return owner;
    }

    public void setOwner(User owner) {
        this.owner = owner;
    }
}
