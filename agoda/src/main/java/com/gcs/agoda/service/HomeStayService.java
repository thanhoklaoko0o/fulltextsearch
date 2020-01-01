package com.gcs.agoda.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.gcs.agoda.dto.SearchDTO;
import com.gcs.agoda.entity.HomestayEntity;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 15, 2019	
 *@version 1.0
 */
public interface HomeStayService {

	List<HomestayEntity> findAllByName(SearchDTO searchDTO, Pageable pageable);
	
	List<HomestayEntity> findAllByDistrict (SearchDTO searchDTO, Pageable pageable);
	
	List<HomestayEntity> findAllByCity (SearchDTO searchDTO, Pageable pageable);
	
	List<HomestayEntity> filterSearch(SearchDTO s);
	
	Page<HomestayEntity> getHomestayPage(Pageable pageable);
	
	List<HomestayEntity> searchText(String text);
	
	List<HomestayEntity> filterHomestay(String name);
}
