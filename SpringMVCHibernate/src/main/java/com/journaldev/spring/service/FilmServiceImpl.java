package com.journaldev.spring.service;

import com.journaldev.spring.dao.FilmDAOImpl;
import com.journaldev.spring.model.Film;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public class FilmServiceImpl implements IFilmService {

    private FilmDAOImpl filmDAO;

    public void setFilmDAO(FilmDAOImpl filmDAO) { this.filmDAO = filmDAO; }

    @Override
    @Transactional
    public void addFilm(Film film) { this.filmDAO.addFilm(film); }

    @Override
    @Transactional
    public void editFilm(Film film) { this.filmDAO.editFilm(film); }

    @Override
    @Transactional
    public List<Film> listFilms() { return this.filmDAO.listFilms(); }

    @Override
    @Transactional
    public Film getFilmById(int id) { return this.filmDAO.getPersonById(id); }

    @Override
    @Transactional
    public void removeFilm(int id) { this.filmDAO.removeFilm(id); }

    @Override
    @Transactional
    public void updateIds() { this.filmDAO.updateIds(); }

}
