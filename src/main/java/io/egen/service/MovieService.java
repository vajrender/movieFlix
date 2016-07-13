package io.egen.service;

import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExitsException;
import io.egen.exception.MovieNotFoundException;

import java.util.List;

public interface MovieService {

	List<Movie> findAll();

	Movie findById(String Id) throws MovieNotFoundException;
	
	Movie findByTitle(String title) throws MovieNotFoundException;
	
	List<Movie> filterByType(String type) throws MovieNotFoundException;

	Movie create(Movie movie) throws MovieAlreadyExitsException;

	Movie update(String Id, Movie movie) throws MovieNotFoundException;

	void delete(String Id) throws MovieNotFoundException;

	void insertAllMovie(List<Movie> movies);

	List<Movie> filterByYear(String year) throws MovieNotFoundException;

	List<Movie> filterByGenre(String genre) throws MovieNotFoundException;

	List<Movie> sortByRating();

	List<Movie> sortByYear();

	List<Movie> sortByVotes();

}
