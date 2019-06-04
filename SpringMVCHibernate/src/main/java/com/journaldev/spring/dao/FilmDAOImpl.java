package com.journaldev.spring.dao;

import com.journaldev.spring.model.Film;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FilmDAOImpl implements IFilmDAO {

    private static final Logger logger = LoggerFactory.getLogger(FilmDAOImpl.class);

    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addFilm(Film film) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(film);
        logger.info("Film saved successfully, Person Details=" + film);
    }

    @Override
    public void editFilm(Film film) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(film);
        logger.info("Film updated successfully, Person Details=" + film);
    }

    @Override
    public List<Film> listFilms() {
        Session session = this.sessionFactory.getCurrentSession();
        List filmslist = session.createQuery("from Film").list();
        return filmslist;
    }

    @Override
    public Film getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Film film = (Film) session.load(Film.class, id);
        logger.info("Film loaded successfully, Person details=" + film);
        return film;
    }

    @Override
    public void removeFilm(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Film film = getPersonById(id);
        if (film != null) {
            session.delete(film);
        }
        logger.info("Film remove successfully, Person details=" + film);
    }

    @Override
    public void updateIds()
    {

        Session session = this.sessionFactory.getCurrentSession();
        session.createQuery("ALTER TABLE 'FILM' AUTO_INCREMENT = 1");

    }
}
