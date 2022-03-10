package com.movie.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.movie.bean.Movie;

@Repository
public interface MovieDao extends JpaRepository<Movie, Integer> {
	
}
