package com.example.CinemaManager.controller;

<<<<<<< HEAD
import com.example.CinemaManager.entity.Film;
import com.example.CinemaManager.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/films")
public class FilmViewController {

    @Autowired
    private FilmRepository filmRepository;

    @GetMapping
    public String listFilms(Model model) {
        model.addAttribute("films", filmRepository.findAll());
        return "films/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("film", new Film());
        return "films/add";
    }

    @PostMapping("/add")
    public String addFilm(@ModelAttribute Film film) {
        filmRepository.save(film);
        return "redirect:/films";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        model.addAttribute("film", filmRepository.findById(id).orElseThrow());
        return "films/edit";
    }

    @PostMapping("/edit/{id}")
    public String editFilm(@PathVariable Long id, @ModelAttribute Film updatedFilm) {
        Film film = filmRepository.findById(id).orElseThrow();
        film.setTitle(updatedFilm.getTitle());
        film.setGenre(updatedFilm.getGenre());
        film.setDuration(updatedFilm.getDuration());
        filmRepository.save(film);
        return "redirect:/films";
    }

    @PostMapping("/delete/{id}")
    public String deleteFilm(@PathVariable Long id) {
        filmRepository.deleteById(id);
        return "redirect:/films";
    }
=======
public class FilmViewController {
>>>>>>> a8867f0bb764eaccad7afc7f243c162b8d3f2aac
}
