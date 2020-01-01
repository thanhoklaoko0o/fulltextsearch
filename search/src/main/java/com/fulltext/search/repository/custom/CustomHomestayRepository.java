package com.fulltext.search.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.fulltext.search.model.Homestay;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Jan 1, 2020	
 *@version 1.0
 */
@Repository
public interface CustomHomestayRepository {

	List<Homestay> filterHomestay(String name);
}
