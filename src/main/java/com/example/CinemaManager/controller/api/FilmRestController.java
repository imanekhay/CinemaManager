package com.example.CinemaManager.controller.api;

import com.example.CinemaManager.entity.Film;
import com.example.CinemaManager.repository.FilmRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/films")
public class FilmRestController {

    @Autowired
    public FilmRepository filmRepository;

    // Get all films (GET /api/films)
    @GetMapping
    public List<Film> getAllFilms() {
        return filmRepository.findAll();
    }

    // Get one film by ID (GET /api/films/{id})
    @GetMapping("/{id}")
    public Film getFilmById(@PathVariable Long id) {
        return filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found with id " + id));
    }

    // Create new film (POST /api/films)
    @PostMapping
    public Film createFilm(@RequestBody Film film) {
        return filmRepository.save(film);
    }

    // Update existing film (PUT /api/films/{id})
    @PutMapping("/{id}")
    public Film updateFilm(@PathVariable Long id, @RequestBody Film updatedFilm) {
        Film film = filmRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Film not found with id " + id));
        film.setTitle(updatedFilm.getTitle());
        film.setGenre(updatedFilm.getGenre());
        film.setDuration(updatedFilm.getDuration());
        return filmRepository.save(film);
    }

    // Delete film (DELETE /api/films/{id})
    @DeleteMapping("/{id}")
    public void deleteFilm(@PathVariable Long id) {
        filmRepository.deleteById(id);
    }
}
