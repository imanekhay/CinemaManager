package com.example.CinemaManager.repository;


import com.example.CinemaManager.entity.Film;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FilmRepository extends JpaRepository<Film, Long> {

}
