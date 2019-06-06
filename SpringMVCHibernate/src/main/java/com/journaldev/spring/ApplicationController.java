package com.journaldev.spring;

import com.journaldev.spring.model.Film;
import com.journaldev.spring.model.User;
import com.journaldev.spring.service.IFilmService;
import com.journaldev.spring.service.IUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.List;

@Controller
public class ApplicationController {

	private IUserService userService;
	private IFilmService filmService;

	private static final Logger log = LoggerFactory.getLogger(ApplicationController.class);


	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(IUserService userService) { this.userService = userService; }


	@Autowired(required=true)
	@Qualifier(value="filmService")
	public void setFilmService(IFilmService filmService) { this.filmService = filmService; }


    @RequestMapping(value="/", method = RequestMethod.GET)
	public String rootIndex( Model model, HttpSession httpSession) {

		User newUser = new User();
        User user = null;
		try {
            user = (User) httpSession.getAttribute("user");
            log.info("+" + user.getName() + "+");
        } catch (Exception e) {}

		if ( user != null )
		{
		    model.addAttribute("user", user);
		    model.addAttribute("listFilms", filmService.listFilms());
			return "films";
		} else {
			model.addAttribute("user", newUser);
			return "login";
		}

	}

	@RequestMapping(value="/login/sign", method = RequestMethod.POST)
	public String loginUser(@ModelAttribute("user") User user, Model model, HttpSession httpSession) {

		List<User> usersList = userService.listUsers();

		log.info("Size is : " + usersList.size());

		for (User userI : usersList) {

			log.info("   KEK  " + userI.getName());

			if (user.getName().equals(userI.getName())) {
				httpSession.setAttribute("user", userI);
				return "redirect:/";
			}

		}

		user.setId(usersList.size());

		userService.addUser(user);
		httpSession.setAttribute("user", user);
		return "redirect:/";

	}


	@RequestMapping(value="/films/add", method = RequestMethod.GET)
	public String addFilm(Model model, HttpSession httpSession) {
		model.addAttribute("film", new Film());
		return "/formfilm";

	}


	@RequestMapping(value="/logout", method = RequestMethod.POST)
	public String logoutUser(Model model, HttpSession httpSession) {
		httpSession.removeAttribute("user");
		return "redirect:/";

	}

	@RequestMapping(value="/films/edit/{id}", method = RequestMethod.GET)
	public String editFilm(@PathVariable("id") int id, Model model) {

		model.addAttribute("film", filmService.getFilmById(id));
		return "/formfilm";

	}

	@RequestMapping(value="/films/delete/{id}", method = RequestMethod.GET)
	public String deleteFilm(@PathVariable("id") int id, Model model) {

		Film deleteFilm = filmService.getFilmById(id);

		log.info("Popp" + deleteFilm.getImage_url());
		if (deleteFilm.getImage_url().startsWith("res/"))
		{
			log.info("/WEB-INF/image/" + deleteFilm.getImage_url().substring(4));
			File file = new File("C:\\Users\\Vapio\\Downloads\\SpringMVCHibernate\\SpringMVCHibernate\\src\\main\\webapp\\WEB-INF\\image\\" + deleteFilm.getImage_url().substring(4));
			if (file.exists())
			{
				file.delete();
				log.info("!!! File DELETED~!!!!");
			} else {
				log.info("!!! File DOESN'T EXISTS~!!!!");
			}


		}

		filmService.removeFilm(id);
		//filmService.updateIds();

		return "redirect:/";

	}


	@RequestMapping(value="/films/save/", method = RequestMethod.POST)
	public String saveFilm(@ModelAttribute("film") Film film, Model model) {

		log.info(String.valueOf(film.getId()));
		if (film.getId() != 0)
		{
			filmService.editFilm(film);
		} else {
			filmService.addFilm(film);
		}

		return "redirect:/";

	}

	@RequestMapping(value="/films/show/{id}", method = RequestMethod.POST)
	public String showFilm(@PathVariable("id") int id, Model model) {

		model.addAttribute("film", filmService.getFilmById(id));
		return "/film";

	}

}
