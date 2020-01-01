package com.gcs.agoda;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.gcs.agoda.entity.HomestayEntity;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Jan 1, 2020	
 *@version 1.0
 */
@Component
public class BuildSearchIndex implements ApplicationListener<ApplicationReadyEvent> {

	@PersistenceContext
	  private EntityManager entityManager;
	
	@Override
	@Transactional
	public void onApplicationEvent(final ApplicationReadyEvent event) {
		// TODO Auto-generated method stub
		try {
		      FullTextEntityManager fullTextEntityManager =
		        Search.getFullTextEntityManager(entityManager);
		      fullTextEntityManager.createIndexer().startAndWait();
		    }
		    catch (InterruptedException e) {
		      System.out.println(
		        "An error occurred trying to build the serach index: " +
		         e.toString());
		    }
		    return;
	}

}
