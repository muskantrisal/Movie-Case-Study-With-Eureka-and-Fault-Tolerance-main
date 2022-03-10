package com.rating.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.rating.bean.Rating;

@Repository
public interface RatingDao extends JpaRepository<Rating, Integer> {
	public List<Rating> findByUserId(Integer userId);
}
