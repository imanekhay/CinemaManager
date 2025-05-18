package com.example.CinemaManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.example.CinemaManager.entity.Booking;
import com.example.CinemaManager.entity.Watcher;
import com.example.CinemaManager.entity.Showtime;
import com.example.CinemaManager.repository.BookingRepository;
import com.example.CinemaManager.repository.WatcherRepository;
import com.example.CinemaManager.repository.ShowtimeRepository;

@Controller
@RequestMapping("/booking")
public class BookingController {
    @Autowired
    private BookingRepository bookingRepository;
    @Autowired
    private ShowtimeRepository showtimeRepository;
    @Autowired
    private WatcherRepository watcherRepository;

    @GetMapping
    public String listBookings(Model model) {
        model.addAttribute("bookings", bookingRepository.findAll());
        return "booking/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("booking", new Booking());
        model.addAttribute("watchers", watcherRepository.findAll());
        model.addAttribute("showtimes", showtimeRepository.findAll());
        return "booking/add";
    }

    @PostMapping("/add")
    public String addBooking(
            @RequestParam("watcherId") Long watcherId,
            @RequestParam("showtimeId") Long showtimeId,
            @ModelAttribute Booking booking
    ) {
        booking.setWatcher(watcherRepository.findById(watcherId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid watcher ID")));

        booking.setShowtime(showtimeRepository.findById(showtimeId)
                .orElseThrow(() -> new IllegalArgumentException("Invalid showtime ID")));



        bookingRepository.save(booking);
        return "redirect:/booking";
    }


}