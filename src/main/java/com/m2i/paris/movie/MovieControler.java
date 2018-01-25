package com.m2i.paris.movie;

import java.io.IOException;
import java.util.ArrayList;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.m2i.paris.util.Controle;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Controller
public class MovieControler {
	@Autowired
	private MovieService movieServices;

	private static final String URL = "https://api.themoviedb.org/3/movie/top_rated?api_key=71b5b7777a42d6d1f3cc478ca687c0e0&language=fr-FR&page=1";

	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ModelAndView getJSON() throws IOException, ParseException {
		
		
		if (movieServices.getAll().isEmpty() == true) {
		
		OkHttpClient client = new OkHttpClient();
		Request request = new Request.Builder().url(URL).build();
		Response response = client.newCall(request).execute();

		JSONParser parser = new JSONParser();
		JSONObject jsonTotal = (JSONObject) parser.parse(response.body().string());
		ArrayList<JSONObject> jsonList = (ArrayList<JSONObject>) parser.parse(jsonTotal.get("results").toString());

		JSONObject jsonObj = new JSONObject();
		Movie movie = new Movie();
		for (JSONObject js : jsonList) {
			System.out.println(js);
			jsonObj = (JSONObject) parser.parse(js.toString());

			movie = new Movie();
			movie.setVoteCount(Integer.parseInt(jsonObj.get("vote_count").toString()));
			movie.setMovieDBid(Integer.parseInt(jsonObj.get("id").toString()));
			movie.setVoteAverage(Double.parseDouble(jsonObj.get("vote_average").toString()));
			movie.setTitle((jsonObj.get("title").toString()));
			movie.setPopularity(Double.parseDouble(jsonObj.get("popularity").toString()));
			movie.setPosterPath((jsonObj.get("poster_path").toString()));
			movie.setBackdropPath((jsonObj.get("backdrop_path").toString()));
			movie.setAdult(Boolean.parseBoolean(jsonObj.get("adult").toString()));
			movie.setOverview((jsonObj.get("overview").toString()));
			movie.setReleaseDate((jsonObj.get("release_date").toString()));
			
			movieServices.add(movie);
		}
		}

		ModelAndView jSonVue = new ModelAndView();
		jSonVue.addObject("UnFilm", movieServices.getById(4));
		jSonVue.setViewName("info"); // page

		return jSonVue;

	}
	@RequestMapping(value = "/movies", method = RequestMethod.GET)
	public ModelAndView getAll() {
		ModelAndView mav = new ModelAndView("movies");
		mav.addObject("listFilms", movieServices.getAll());
		for (Movie m : movieServices.getAll()) {
			System.out.println(m);
		}
		
		return mav;
	}

	@RequestMapping(value = "/movies/{id}", method = RequestMethod.GET)
	public ModelAndView getById(@PathVariable Integer id) {
		ModelAndView mav = new ModelAndView("movie");
		mav.addObject("film", movieServices.getById(id));
		return mav;
	}

	@RequestMapping(method = RequestMethod.DELETE, value = "/movies/{id}")
	public ModelAndView delete(@PathVariable Integer id) {
		movieServices.delete(id);
		ModelAndView mav = new ModelAndView("info");
		return mav;
	}

	
	@RequestMapping(value = "/add")
	public String adde (){
		return "add"; 
		}
		
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelAndView add(Movie film) {
		System.out.println(film.getTitle());
		System.out.println(Controle.prenom(film.getTitle()));
		if (Controle.prenom(film.getTitle())==true) {
		movieServices.add(film);
		return new ModelAndView("redirect:/");
		} else {
			ModelAndView add = new ModelAndView("add");
			add.addObject("errornom","Veuillez entrer un titre correct");
			System.out.println(film.toString());
		return add;
		}
	}
	
	
	@RequestMapping(value = "/movies/{id}", method = RequestMethod.PUT)
	   public void update(@RequestBody Movie film, @PathVariable Integer id){
		movieServices.update(film, id);
	}

}
