package com.fulltext.search.repository.custom.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.fulltext.search.model.Homestay;
import com.fulltext.search.repository.custom.CustomHomestayRepository;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Jan 1, 2020	
 *@version 1.0
 */
public class CustomHomestayRepositoryImpl implements CustomHomestayRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Homestay> filterHomestay(String name) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);

		QueryBuilder queryBuilder = fullTextEntityManager
				.getSearchFactory()
				.buildQueryBuilder()
				.forEntity(Homestay.class)
				.get();
		
		Query luceneQuery = queryBuilder
				.keyword()
				.onFields("name", "city", "district")
				.matching(name)
				.createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Homestay.class);
		
		List<Homestay> lsthome = jpaQuery.getResultList();
		return lsthome;
	}

}
