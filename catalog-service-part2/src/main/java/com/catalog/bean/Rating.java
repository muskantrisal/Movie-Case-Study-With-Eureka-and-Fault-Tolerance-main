package com.catalog.bean;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter

@JsonIgnoreProperties({ "hibernateLazyInitializer","handler" })
public class Rating {
	

	private int ratingId;
	private int userId;
	private int movieId;
	private String rating;
	
}
