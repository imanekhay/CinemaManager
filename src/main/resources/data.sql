-- Clean tables to avoid conflicts
DELETE FROM booking;
DELETE FROM showtime;
DELETE FROM watcher_favorites;
DELETE FROM watcher;
DELETE FROM film;









-- Insert film
INSERT INTO film (id, title, genre, duration) VALUES
                                                  (1, 'The Matrix', 'Sci-Fi', 136),
                                                  (2, 'Inception', 'Sci-Fi', 148);

-- Insert watchers
INSERT INTO watcher (id, email, name) VALUES
                                          (1, 'alice@example.com', 'Alice'),
                                          (2, 'bob@example.com', 'Bob'),
                                          (3, 'charlie@example.com', 'Charlie');

-- Insert showtimes
INSERT INTO showtime (id, date_time, screen, film_id) VALUES
                                                          (1, '2025-05-17 19:00', 'Screen 1', 1),
                                                          (2, '2025-05-18 21:00', 'Screen 2', 2);

-- Insert bookings with seats (fixed showtime_id to valid ones)
INSERT INTO booking (id, watcher_id, showtime_id) VALUES
                                                             (1, 1, 1),
                                                             (2, 2, 2),

