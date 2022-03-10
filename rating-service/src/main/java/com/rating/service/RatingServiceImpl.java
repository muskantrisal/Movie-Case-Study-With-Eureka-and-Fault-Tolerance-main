package com.rating.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rating.bean.Rating;
import com.rating.persistence.RatingDao;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RatingDao ratingDao;
	
	
	@Override
	public List<Rating> getRatingsByUserId(Integer userId) {
		
		return ratingDao.findByUserId(userId);
	}

}
