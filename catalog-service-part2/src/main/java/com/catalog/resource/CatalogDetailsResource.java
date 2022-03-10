package com.catalog.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.catalog.bean.CatalogDetailsList;
import com.catalog.service.CatalogDetailsService;

@RestController
public class CatalogDetailsResource {
	
	
	@Autowired
	CatalogDetailsService catalogDetailsService;
	
	
	@GetMapping(value="/catalogdetails/{uid}",produces="application/json")
	public CatalogDetailsList getCatalogDetailsByUserId(@PathVariable("uid") Integer userId) {
		return catalogDetailsService.getCatalogDetailsById(userId);
	}
	
}
