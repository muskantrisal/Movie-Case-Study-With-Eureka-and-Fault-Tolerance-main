package com.rating.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.rating.bean.Rating;
import com.rating.persistence.RatingDao;

@SpringBootApplication(scanBasePackages = "com.rating")
@EnableJpaRepositories(basePackages ="com.rating.persistence")
@EntityScan(basePackages="com.rating.bean")
@EnableEurekaClient
public class RatingServiceApplication /* implements CommandLineRunner */ {

	/*@Autowired
	private RatingDao ratingDao;*/
	
	public static void main(String[] args)  {
		SpringApplication.run(RatingServiceApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		ratingDao.save(new Rating(1001,100,1,"5 Star"));
		ratingDao.save(new Rating(1002,101,2,"4.5 Star"));
		ratingDao.save(new Rating(1003,100,3,"4.7 Star"));
		ratingDao.save(new Rating(1004,102,4,"4.8 Star"));
		ratingDao.save(new Rating(1005,103,5,"4.9 Star"));
		ratingDao.save(new Rating(1006,101,1,"5 Star"));
		
	}*/

}
