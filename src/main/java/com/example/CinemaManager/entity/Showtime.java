package com.example.CinemaManager.entity;

import jakarta.persistence.Entity;

import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.CascadeType;
import jakarta.persistence.FetchType;
import java.util.List;


@Entity
public class Showtime {
    @Id @GeneratedValue
    private Long id;
    private String dateTime;
    private String screen;

    @ManyToOne
    @JoinColumn(name = "film_id")
    private Film film;

    @OneToMany(mappedBy = "showtime", cascade = CascadeType.ALL)
    private List<Booking> bookings;


    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDateTime() { return dateTime; }
    public void setDateTime(String dateTime) { this.dateTime = dateTime; }

    public String getScreen() { return screen; }
    public void setScreen(String screen) { this.screen = screen; }

    public Film getFilm() { return film; }
    public void setFilm(Film film) { this.film = film; }

    public List<Booking> getBookings() { return bookings; }
    public void setBookings(List<Booking> bookings) { this.bookings = bookings; }

}
