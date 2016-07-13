package io.egen.repository;

import io.egen.entity.Movie;

import java.util.List;


public interface MovieRepository {
	
	public List<Movie> findAll();
	public Movie findById(String Id);
	
	public Movie findByTitle(String title);
	
	public List<Movie> filterByType(String type);
	
	public Movie create(Movie movie);
	public Movie update(Movie movie);
	public void delete(Movie movie);
	public void insertAllMovie(List<Movie> movies);
	public List<Movie> filterByYear(String year);
	public List<Movie> filterByGenre(String genre);
	public List<Movie> sortByRating();
	public List<Movie> sortByYear();
	public List<Movie> sortByVotes();
}
