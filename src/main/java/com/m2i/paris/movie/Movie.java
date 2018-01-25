package com.m2i.paris.movie;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import org.hibernate.annotations.Type;



@Entity
public class Movie {

	@GeneratedValue
	@Id
	private Integer id;
	
	private Integer voteCount;
	private Integer movieDBid;
	private Double voteAverage;
	private String title;
	private Double popularity;
	private String posterPath;
	private String backdropPath;
	private Boolean adult;
	@Type(type="text")
	private String overview;
	private String releaseDate;
	
	
	public Movie(String title) {
		super();
		this.title = title;
	}


	public Movie() {
		super();
	}


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getVoteCount() {
		return voteCount;
	}


	public void setVoteCount(Integer voteCount) {
		this.voteCount = voteCount;
	}


	public Integer getMovieDBid() {
		return movieDBid;
	}


	public void setMovieDBid(Integer id) {
		this.movieDBid = id;
	}


	public Double getVoteAverage() {
		return voteAverage;
	}


	public void setVoteAverage(Double voteAverage) {
		this.voteAverage = voteAverage;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public Double getPopularity() {
		return popularity;
	}


	public void setPopularity(Double popularity) {
		this.popularity = popularity;
	}


	public String getPosterPath() {
		return posterPath;
	}


	public void setPosterPath(String posterPath) {
		this.posterPath = posterPath;
	}


	public String getBackdropPath() {
		return backdropPath;
	}


	public void setBackdropPath(String backdropPath) {
		this.backdropPath = backdropPath;
	}


	public Boolean getAdult() {
		return adult;
	}


	public void setAdult(Boolean adult) {
		this.adult = adult;
	}


	public String getOverview() {
		return overview;
	}


	public void setOverview(String overview) {
		this.overview = overview;
	}


	public String getReleaseDate() {
		return releaseDate;
	}


	public void setReleaseDate(String releaseDate) {
		this.releaseDate = releaseDate;
	}




	public Movie(Integer voteCount, Integer movieDBid, Double voteAverage, String title, Double popularity,
			String posterPath, String backdropPath, Boolean adult, String overview, String releaseDate) {
		super();
		this.voteCount = voteCount;
		this.movieDBid = movieDBid;
		this.voteAverage = voteAverage;
		this.title = title;
		this.popularity = popularity;
		this.posterPath = posterPath;
		this.backdropPath = backdropPath;
		this.adult = adult;
		this.overview = overview;
		this.releaseDate = releaseDate;
	}


	@Override
	public String toString() {
		return title + "\n Title = " + title + "\n Overview = " +overview+ "\n Jaquette=" + posterPath + "\n MovieDB Id = " + movieDBid + "\n Vote Count=" + voteCount + "\n Vote Average=" + voteAverage  
				+ "\n Popularity = " + popularity + "\n Background=" + backdropPath
				+ ", Adult=" + adult + ", Release Date=" + releaseDate;
	}
	
	

	
}
