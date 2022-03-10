package com.movie.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.movie.bean.Movie;
import com.movie.persistence.MovieDao;


@Service
public class MovieServiceImlp implements MovieService {

	@Autowired
	private MovieDao movieDao;
	
	@Override
	public Movie findMovieById(int id) {	
		return movieDao.getById(id);
	}

}
