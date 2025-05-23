package com.example.CinemaManager.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;


import java.util.List;

@Entity
public class Watcher {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "watcher", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Booking> bookings;


    @ManyToMany
    @JoinTable(
            name = "watcher_favorites",
            joinColumns = @JoinColumn(name = "watcher_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    @JsonBackReference
    private List<Film> favoriteFilms;

    // ✅ GETTERS & SETTERS

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
