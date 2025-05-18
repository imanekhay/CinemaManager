package com.example.CinemaManager.repository;
import com.example.CinemaManager.entity.Showtime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface ShowtimeRepository extends JpaRepository<Showtime, Long> {}
