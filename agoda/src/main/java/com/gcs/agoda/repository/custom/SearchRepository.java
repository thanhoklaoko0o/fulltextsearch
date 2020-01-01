package com.gcs.agoda.repository.custom;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.gcs.agoda.entity.HomestayEntity;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 30, 2019	
 *@version 1.0
 */
@Repository
public interface SearchRepository {

	List<HomestayEntity> filterHomestay(String name);
}
