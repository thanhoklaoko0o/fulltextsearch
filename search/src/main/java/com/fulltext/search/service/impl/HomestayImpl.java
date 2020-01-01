package com.fulltext.search.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fulltext.search.model.Homestay;
import com.fulltext.search.repository.HomestayRepository;
import com.fulltext.search.service.HomestayService;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Jan 1, 2020	
 *@version 1.0
 */
@Service
public class HomestayImpl implements HomestayService{
	
	@Autowired
	private HomestayRepository homestayRepository;


	@Override
	public void AddHomeStay(Homestay homestay) {
		homestayRepository.save(homestay);
	}

	@Override
	public List<Homestay> searchKeyWord(String name) {
		return homestayRepository.filterHomestay(name);
	}

	
}
