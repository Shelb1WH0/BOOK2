package com.demo.service;

import com.demo.model.Genre;
import com.demo.repository.GenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GenreService {

    @Autowired
    private GenreRepository genreRepository;

    // CREATE: Создание нового жанра
    public Genre createGenre(Genre genre) {
        return genreRepository.save(genre);
    }

    // READ: Получить все жанры
    public List<Genre> getAllGenres() {
        return genreRepository.findAll();
    }

    // READ: Получить жанр по ID
    public Genre getGenreById(Long id) {
        return genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
    }

    // UPDATE: Обновить жанр
    public Genre updateGenre(Long id, Genre updatedGenre) {
        Genre genre = genreRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Genre not found"));
        genre.setName(updatedGenre.getName());
        return genreRepository.save(genre);
    }


    public void deleteGenre(Long id) {
        if (!genreRepository.existsById(id)) {
            throw new RuntimeException("");
        }
    }
}