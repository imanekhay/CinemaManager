package com.example.CinemaManager.controller.api;

<<<<<<< HEAD


import com.example.CinemaManager.entity.Showtime;
import com.example.CinemaManager.repository.ShowtimeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/showtimes")
public class ShowtimeRestController {

    @Autowired
    public ShowtimeRepository showtimeRepository;

    @GetMapping
    public List<Showtime> getAllShowtimes() {
        return showtimeRepository.findAll();
    }

    @GetMapping("/{id}")
    public Showtime getShowtimeById(@PathVariable Long id) {
        return showtimeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Showtime not found with id " + id));
    }

    @PostMapping
    public Showtime createShowtime(@RequestBody Showtime showtime) {
        return showtimeRepository.save(showtime);
    }

    @PutMapping("/{id}")
    public Showtime updateShowtime(@PathVariable Long id, @RequestBody Showtime updatedShowtime) {
        Showtime showtime = showtimeRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Showtime not found with id " + id));
        showtime.setDateTime(updatedShowtime.getDateTime());
        showtime.setScreen(updatedShowtime.getScreen());
        showtime.setFilm(updatedShowtime.getFilm());
        return showtimeRepository.save(showtime);
    }

    @DeleteMapping("/{id}")
    public void deleteShowtime(@PathVariable Long id) {
        showtimeRepository.deleteById(id);
    }
=======
public class ShowtimeRestController {
>>>>>>> a8867f0bb764eaccad7afc7f243c162b8d3f2aac
}
