package com.movie.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.movie.bean.Movie;
import com.movie.persistence.MovieDao;

@SpringBootApplication(scanBasePackages = "com.movie")
@EntityScan(basePackages = "com.movie.bean")
@EnableJpaRepositories(basePackages = "com.movie.persistence")
@EnableEurekaClient
public class MovieServiceApplication /*implements CommandLineRunner*/ {

	/*@Autowired
	private MovieDao movieDao;*/
	
	public static void main(String[] args) {
		SpringApplication.run(MovieServiceApplication.class, args);
	}

	/*@Override
	public void run(String... args) throws Exception {
		movieDao.save(new Movie(1,"Iron Man"));
		movieDao.save(new Movie(2,"Super Man"));
		movieDao.save(new Movie(3,"Spiderman"));
		movieDao.save(new Movie(4,"Batman"));
		
	}*/

}
