package com.example.CinemaManager.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.example.CinemaManager.entity.Watcher;
import com.example.CinemaManager.repository.WatcherRepository;


@Controller
@RequestMapping("/watcher")
public class WatcherController {
    @Autowired private WatcherRepository watcherRepository;

    @GetMapping
    public String listWatchers(Model model) {
        model.addAttribute("watchers", watcherRepository.findAll());
        return "watcher/list";
    }

    @GetMapping("/add")
    public String showAddForm(Model model) {
        model.addAttribute("watcher", new Watcher());
        return "watcher/add";
    }

    @PostMapping("/add")
    public String addWatcher(@ModelAttribute Watcher watcher) {
        watcherRepository.save(watcher);
        return "redirect:/watcher";
    }

}
