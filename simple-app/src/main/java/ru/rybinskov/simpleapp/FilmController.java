package ru.rybinskov.simpleapp;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FilmController {
    @GetMapping("/film")
    public Film getFilm() {
        Film film = new Film("test description");
        return film;
    }

    @PostMapping("/film")
    public ResponseEntity postFilm(@RequestBody Film film) {
        Film newFilm = film;
        return new ResponseEntity<>(newFilm, HttpStatus.CREATED);
    }

    @GetMapping("/movie")
    public String getMovie() {
        return "Получаем кино по GET-мапингу /movie";
    }

    @PostMapping("/movie")
    public String postMovie() {
        return "Получаем кино по POST-мапингу /movie";
    }

}
