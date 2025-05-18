package com.example.CinemaManager.controller.api;

import com.example.CinemaManager.entity.Watcher;
import com.example.CinemaManager.repository.WatcherRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/watchers")
public class WatcherRestController {

    @Autowired
    private WatcherRepository watcherRepository;

    @GetMapping
    public List<Watcher> getAllWatchers() {
        return watcherRepository.findAll();
    }

    @GetMapping("/{id}")
    public Watcher getWatcherById(@PathVariable Long id) {
        return watcherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Watcher not found with id " + id));
    }

    @PostMapping
    public Watcher createWatcher(@RequestBody Watcher watcher) {
        return watcherRepository.save(watcher);
    }

    @PutMapping("/{id}")
    public Watcher updateWatcher(@PathVariable Long id, @RequestBody Watcher updatedWatcher) {
        Watcher watcher = watcherRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Watcher not found with id " + id));
        watcher.setName(updatedWatcher.getName());
        watcher.setEmail(updatedWatcher.getEmail());
        return watcherRepository.save(watcher);
    }

    @DeleteMapping("/{id}")
    public void deleteWatcher(@PathVariable Long id) {
        watcherRepository.deleteById(id);
    }
}