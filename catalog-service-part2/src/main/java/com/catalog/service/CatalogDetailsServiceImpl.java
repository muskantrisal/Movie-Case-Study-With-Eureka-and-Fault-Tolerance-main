package com.catalog.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.catalog.bean.CatalogDetails;
import com.catalog.bean.CatalogDetailsList;
import com.catalog.bean.Movie;
import com.catalog.bean.Rating;
import com.catalog.bean.RatingList;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class CatalogDetailsServiceImpl implements CatalogDetailsService {

//	@Autowired
//	private RestTemplate restTemplate;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private RatingService ratingService;
	
	
	@Override
//	@CircuitBreaker(name="catalogDetails",fallbackMethod="getCatalogDetailsByIdFallback")
	public CatalogDetailsList getCatalogDetailsById(Integer userId) {
		
		List<CatalogDetails> catalogDetailsCollection=new ArrayList<>();
		
//		RatingList ratingList=restTemplate.getForObject("http://rating-service/ratings/"+userId, RatingList.class);

		RatingList ratingList=ratingService.getRatingList(userId);
		
		for(Rating rating:ratingList.getRatings()) {
			
//			Movie movie=restTemplate.getForObject("http://movie-service/movies/"+rating.getMovieId(), Movie.class);
	
			Movie movie=movieService.getMovieDetails(rating.getMovieId());
			
			CatalogDetails catalogDetails=new CatalogDetails(userId,movie.getMovieName(),rating.getRating());
			
			catalogDetailsCollection.add(catalogDetails);
			
			
		}
		
		CatalogDetailsList catalogDetailsList=new CatalogDetailsList(catalogDetailsCollection);
		
		return catalogDetailsList;
	}
	
	
//	public CatalogDetailsList getCatalogDetailsByIdFallback(Exception e)
//	{
//		List<CatalogDetails> catalogDetails=new ArrayList<>();
//		catalogDetails.add(new CatalogDetails(0,null,null));
//		return new CatalogDetailsList(catalogDetails);
//	}

}
