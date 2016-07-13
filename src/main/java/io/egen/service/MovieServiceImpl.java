package io.egen.service;

import io.egen.entity.Movie;
import io.egen.exception.MovieAlreadyExitsException;
import io.egen.exception.MovieNotFoundException;
import io.egen.repository.MovieRepository;

import java.util.List;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class MovieServiceImpl implements MovieService {

	@Autowired
	private MovieRepository dao;

	@Override
	public List<Movie> findAll() {
		return dao.findAll();
	}

	@Override
	public Movie findById(String Id) throws MovieNotFoundException {
		Movie movie=dao.findById(Id);
		if(movie==null){
			throw new MovieNotFoundException() ;
		}else{
		return movie;
		}
	}
	
	@Override
	public Movie findByTitle(String title) throws MovieNotFoundException {
		Movie mv = dao.findByTitle(title);
		if(mv == null){
			throw new MovieNotFoundException() ;
		}
		else{
			return mv;
		}	
	}
	
	@Override
	public List<Movie> filterByType(String type) throws MovieNotFoundException {
		List<Movie> mv = dao.filterByType(type);
		if(mv == null){
			throw new MovieNotFoundException() ;
		}
		else{
			return mv;
		}	
	}
	
	@Override
	public List<Movie> filterByYear(String year) throws MovieNotFoundException {
		List<Movie> mv = dao.filterByYear(year);
		if(mv == null){
			throw new MovieNotFoundException() ;
		}
		else{
			return mv;
		}	
	}
	
	@Override
	public List<Movie> filterByGenre(String genre) throws MovieNotFoundException {
		List<Movie> mv = dao.filterByGenre(genre);
		if(mv == null){
			throw new MovieNotFoundException() ;
		}
		else{
			return mv;
		}	
	}

	@Override
	public Movie create(Movie movie) throws MovieAlreadyExitsException {
		Movie existing =  dao.findById(movie.getImdbID());
		if(existing == null) {
			return dao.create(movie);
		}
		else {
			throw new MovieAlreadyExitsException();
		}
		
	}

	@Override
	public Movie update(String Id, Movie movie) throws MovieNotFoundException {
		Movie existing =  dao.findById(Id);
		if(existing == null) {
			throw new MovieNotFoundException();
		}
		else {
			return dao.update(movie);
		}
	}

	@Override
	public void delete(String Id) throws MovieNotFoundException {
		Movie existing =  dao.findById(Id);
		if(existing == null) {
			throw new MovieNotFoundException();
		}
		else {
			dao.delete(existing);
		}
	}

	@Override
	public void insertAllMovie(List<Movie> movies) {
		dao.insertAllMovie(movies);
		
	}

	@Override
	public List<Movie> sortByRating() {
		return dao.sortByRating();
	}

	@Override
	public List<Movie> sortByYear() {
		return dao.sortByRating();
	}

	@Override
	public List<Movie> sortByVotes() {
		return dao.sortByVotes();
	}


}
