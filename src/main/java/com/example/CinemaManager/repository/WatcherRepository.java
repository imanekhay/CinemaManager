package com.example.CinemaManager.repository;

import com.example.CinemaManager.entity.Watcher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface WatcherRepository extends JpaRepository<Watcher, Long> {}
