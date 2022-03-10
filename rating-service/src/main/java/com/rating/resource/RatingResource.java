package com.rating.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.rating.bean.RatingList;
import com.rating.service.RatingService;

@RestController
public class RatingResource {
	
	@Autowired
	private RatingService ratingService;
	
	@GetMapping(value="/ratings/{uid}")
	public RatingList getRatingsByUserId(@PathVariable("uid") Integer userId)
	{
		RatingList ratingList=new RatingList();
		ratingList.setRatings(ratingService.getRatingsByUserId(userId));
		return ratingList;
	}
}
