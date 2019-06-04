package com.journaldev.spring.service;

import com.journaldev.spring.model.Film;
import java.util.List;

public interface IFilmService {


    public void addFilm(Film film);
    public void editFilm(Film film);
    public List<Film> listFilms();
    public Film getFilmById(int id);
    public void removeFilm(int id);
    public void updateIds();

}
