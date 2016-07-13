package io.egen.repository;

import io.egen.entity.Movie;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;


@Repository
@Transactional
public class MovieRepositoryImpl implements MovieRepository {
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Movie> findAll() {
		String qlString = "SELECT m FROM Movie m ORDER BY m.id ASC";
		List<Movie> movies = em.createQuery(qlString, Movie.class)
				.getResultList();
		return movies;
	}

	@Override
	public Movie findById(String Id) {
		Movie movie= em.find(Movie.class, Id);
		return movie;
	}
	
	public List<Movie> sortByRating(){
		String qlString = "SELECT m FROM Movie m ORDER BY m.imdbRating ";
        List<Movie> movies = em.createQuery(qlString, Movie.class)
                .getResultList();
        return movies;
	}
	
	public List<Movie> sortByYear(){
		String qlString = "SELECT m FROM Movie m ORDER BY m.year ";
        List<Movie> movies = em.createQuery(qlString, Movie.class)
                .getResultList();
        return movies;
	}
	
	public List<Movie> sortByVotes(){
		String qlString = "SELECT m FROM Movie m ORDER BY m.imdbVotes ";
        List<Movie> movies = em.createQuery(qlString, Movie.class)
                .getResultList();
        return movies;
	}
	
	@Override
	public Movie findByTitle(String title) {
		TypedQuery<Movie> qlString = em.createNamedQuery("Movie.findByTitle", Movie.class).setParameter("title",
				title);
         List<Movie> movie = qlString.getResultList();
          if (movie.size() == 1 && movie != null) {
	          return movie.get(0);
             } 
          else {
	       return null;
	       }
      }
	
	public List<Movie> filterByType(String type) {
		TypedQuery<Movie> qlString = em.createNamedQuery("Movie.filterByType", Movie.class).setParameter("type",
				type);
         List<Movie> movie = qlString.getResultList();
          if (movie != null) {
	          return movie;
             } 
          else {
	       return null;
	       }
      }
	
	public List<Movie> filterByYear(String year) {
		TypedQuery<Movie> qlString = em.createNamedQuery("Movie.filterByYear", Movie.class).setParameter("year",
				year);
         List<Movie> movie = qlString.getResultList();
          if (movie != null) {
	          return movie;
             } 
          else {
	       return null;
	       }
      }
	
	public List<Movie> filterByGenre(String genre) {
		TypedQuery<Movie> qlString = em.createNamedQuery("Movie.filterByGenre", Movie.class).setParameter("genre",
				"%" + genre + "%");
         List<Movie> movie = qlString.getResultList();
          if (movie != null) {
	          return movie;
             } 
          else {
	       return null;
	       }
      }
	

	@Override
	public Movie create(Movie movie) {
		 em.persist(movie);
		return movie;
	}

	@Override
	public Movie update(Movie movie) {
		return em.merge(movie);
	}

	@Override
	public void delete(Movie movie) {
		em.remove(movie);
	}

	@Override
	public void insertAllMovie(List<Movie> movies) {
		for(Movie mv:movies){
			em.persist(mv);
		}
	}



}
