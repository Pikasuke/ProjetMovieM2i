package com.m2i.paris.movie;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.m2i.paris.movie.*;


@Service
	public class MovieService {
	   @Autowired
	   private MovieRepository movieRepository;
	   
	   public ArrayList<Movie> getAll(){
	       ArrayList<Movie> listFilm = new ArrayList<>();
	       movieRepository.findAll().forEach(listFilm::add);
		       return listFilm;
	   }
	   public Movie getById(@PathVariable Integer id){
	       return movieRepository.findOne(id);
	   }
	   public void delete(@PathVariable Integer id){
		   movieRepository.delete(id);
	   }
	   public void add(@RequestBody Movie movie){
		   movieRepository.save(movie);
	   }
	   public void update(@RequestBody Movie movie, @PathVariable Integer id){
		   movieRepository.save(movie);
	   }
	
}
