package com.rating.service;

import java.util.List;

import com.rating.bean.Rating;

public interface RatingService {
	
	List<Rating> getRatingsByUserId(Integer userId);
	
}
