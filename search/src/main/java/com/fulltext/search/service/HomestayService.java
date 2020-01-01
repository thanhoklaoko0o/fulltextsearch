package com.fulltext.search.service;

import java.util.List;

import com.fulltext.search.model.Homestay;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Jan 1, 2020	
 *@version 1.0
 */
public interface HomestayService {

	void AddHomeStay(Homestay homestay);

	List<Homestay> searchKeyWord(String name);
}
