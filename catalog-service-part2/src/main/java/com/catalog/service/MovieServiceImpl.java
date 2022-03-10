package com.catalog.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.catalog.bean.Movie;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class MovieServiceImpl implements MovieService {

	
	@Autowired
	private RestTemplate restTemplate;
	
	
	@CircuitBreaker(name = "movie",fallbackMethod = "getMovieDetailsFallBack")
	public Movie getMovieDetails(int movieId) {
		return restTemplate.getForObject("http://movie-service/movies/"+movieId, Movie.class);
	}
	
	public Movie getMovieDetailsFallBack(int movieId,Exception e)
	{
		return new Movie(0,null);
	}

}
