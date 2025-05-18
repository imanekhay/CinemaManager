package com.example.CinemaManager.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;

import java.util.List;



@Entity
public class Showtime {
    @Id
    @GeneratedValue
    private Long id;
    private String dateTime;
    private String screen;

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Booking> bookings;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDateTime() {
        return dateTime;
    }

    public void setDateTime(String dateTime) {
        this.dateTime = dateTime;
    }

    public String getScreen() {
        return screen;
    }

    public void setScreen(String screen) {
        this.screen = screen;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }



}
