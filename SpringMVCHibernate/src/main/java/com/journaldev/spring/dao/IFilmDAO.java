package com.journaldev.spring.dao;

import com.journaldev.spring.model.Film;

import java.util.List;

public interface IFilmDAO {

    public void addFilm(Film film);
    public void editFilm(Film film);
    public List<Film> listFilms();
    public Film getPersonById(int id);
    public void removeFilm(int id);

    public void updateIds();
}
