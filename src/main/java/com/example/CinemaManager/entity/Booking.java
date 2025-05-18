package com.example.CinemaManager.entity;

import jakarta.persistence.*;

@Entity
public class Booking {
    @Id
    @GeneratedValue
    private Long id;





    @ManyToOne
    @JoinColumn(name = "watcher_id")
    private Watcher watcher;

    @ManyToOne
    @JoinColumn(name = "showtime_id")
    private Showtime showtime;

    // ✅ Getters and Setters
    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }


    public Watcher getWatcher() { return watcher; }

    public void setWatcher(Watcher watcher) { this.watcher = watcher; }

    public Showtime getShowtime() { return showtime; }

    public void setShowtime(Showtime showtime) { this.showtime = showtime; }
}
