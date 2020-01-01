package com.gcs.agoda.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.gcs.agoda.dto.SearchDTO;
import com.gcs.agoda.entity.HomestayEntity;
import com.gcs.agoda.repository.HomeStayRepository;
import com.gcs.agoda.service.HomeStayService;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 15, 2019	
 *@version 1.0
 */
@Service
public class HomeStayServiceImpl implements HomeStayService{

	@Autowired
	private HomeStayRepository homeStayRepository;
	
	@Override
	public List<HomestayEntity> findAllByName(SearchDTO searchDTO, Pageable pageable) {
		return homeStayRepository.findAllByName(searchDTO, pageable);
	}

	@Override
	public List<HomestayEntity> findAllByDistrict(SearchDTO searchDTO, Pageable pageable) {
		return homeStayRepository.findAllByDistrict(searchDTO, pageable);
	}

	@Override
	public List<HomestayEntity> findAllByCity(SearchDTO searchDTO, Pageable pageable) {
		return homeStayRepository.findAllByCity(searchDTO, pageable);
	}

	@Override
	public List<HomestayEntity> filterSearch(SearchDTO s) {
		return homeStayRepository.filterSearch(s);
	}

	@Override
	public Page<HomestayEntity> getHomestayPage(Pageable pageable) {
		return homeStayRepository.findAll(pageable);
	}

	@Override
	public List<HomestayEntity> searchText(String name) {

		return null;
	}

	@Override
	public List<HomestayEntity> filterHomestay(String name) {
		return homeStayRepository.filterHomestay(name);
	}


}
