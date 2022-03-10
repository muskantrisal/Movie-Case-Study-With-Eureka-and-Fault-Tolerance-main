package com.catalog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.catalog.bean.Rating;
import com.catalog.bean.RatingList;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class RatingServiceImpl implements RatingService {

	@Autowired
	private RestTemplate restTemplate;
	
	
	
	@CircuitBreaker(name = "rating",fallbackMethod = "getRatingListFallBack")
	public RatingList getRatingList(Integer userId) {
		return restTemplate.getForObject("http://rating-service/ratings/"+userId, RatingList.class);
	}
	
	public RatingList getRatingListFallBack(Integer userId,Exception e)
	{
		List<Rating> ratings=new ArrayList<>();
		ratings.add(new Rating(0, 0, 0, null));
		return new RatingList(ratings);
	}

}
