package com.catalog.service;

import com.catalog.bean.CatalogDetailsList;

public interface CatalogDetailsService {
	CatalogDetailsList getCatalogDetailsById(Integer userId);
}
