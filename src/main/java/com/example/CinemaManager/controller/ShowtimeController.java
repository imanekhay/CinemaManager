package com.example.CinemaManager.controller;


import com.example.CinemaManager.entity.Showtime;

import com.example.CinemaManager.repository.ShowtimeRepository;
import com.example.CinemaManager.repository.FilmRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;



@Controller
@RequestMapping("/showtime")
              // every path starts with /showtime
public class ShowtimeController {

    @Autowired private ShowtimeRepository showtimeRepository;
    @Autowired private FilmRepository filmRepository;

    /* ---------- LIST -------------------------------------------------- */
    /* /showtime   or  /showtime/list  →  list.html */
    @GetMapping({"", "/list"})
    public String listShowtimes(Model model) {
        model.addAttribute("showtimes", showtimeRepository.findAll());
        return "showtime/list";
    }

    /* ---------- ADD --------------------------------------------------- */
    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("showtime", new Showtime());
        model.addAttribute("films", filmRepository.findAll());
        return "showtime/add";
    }

    @PostMapping("/add")
    public String addShowtime(@ModelAttribute Showtime showtime) {
        // convert film.id coming from the form into a managed Film entity
        Long filmId = showtime.getFilm().getId();
        showtime.setFilm(filmRepository.findById(filmId)
                .orElseThrow(() -> new IllegalArgumentException("Bad film id")));
        showtimeRepository.save(showtime);
        return "redirect:/showtime/list";
    }

    /* ---------- EDIT -------------------------------------------------- */
    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Showtime st = showtimeRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Bad showtime id"));
        model.addAttribute("showtime", st);
        model.addAttribute("films", filmRepository.findAll());
        return "showtime/edit";
    }

    @PostMapping("/edit/{id}")
    public String updateShowtime(@PathVariable Long id, @ModelAttribute Showtime showtime) {
        Long filmId = showtime.getFilm().getId();
        showtime.setFilm(filmRepository.findById(filmId)
                .orElseThrow(() -> new IllegalArgumentException("Bad film id")));
        showtime.setId(id);
        showtimeRepository.save(showtime);
        return "redirect:/showtime/list";
    }

    /* ---------- DELETE ------------------------------------------------ */
    @GetMapping("/delete/{id}")
    public String deleteShowtime(@PathVariable Long id) {
        showtimeRepository.deleteById(id);
        return "redirect:/showtime/list";
    }

}
