package com.example.CinemaManager.entity;

<<<<<<< HEAD
import jakarta.persistence.*;

import java.util.Collections;
import java.util.List;

@Entity
public class Watcher {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private String email;

    @OneToMany(mappedBy = "watcher")
    private List<Booking> bookings;

    @ManyToMany
    @JoinTable(
            name = "watcher_favorites",
            joinColumns = @JoinColumn(name = "watcher_id"),
            inverseJoinColumns = @JoinColumn(name = "film_id")
    )
    private List<Film> favoriteFilms;

    // ✅ GETTERS & SETTERS

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }

    public void setName(String name) { this.name = name; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings;
    }

    public List<Film> getFavoriteFilms() { return favoriteFilms; }

    public void setFavoriteFilms(List<Film> favoriteFilms) {
        this.favoriteFilms = favoriteFilms;
    }
}

=======
public class Watcher {
}
>>>>>>> a8867f0bb764eaccad7afc7f243c162b8d3f2aac
