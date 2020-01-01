package com.fulltext.search.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.fulltext.search.model.Homestay;
import com.fulltext.search.repository.custom.CustomHomestayRepository;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Jan 1, 2020	
 *@version 1.0
 */
public interface HomestayRepository extends JpaRepository<Homestay, Integer>, CustomHomestayRepository{

}
