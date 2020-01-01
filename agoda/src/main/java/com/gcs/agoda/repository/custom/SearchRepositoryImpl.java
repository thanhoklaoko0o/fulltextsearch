package com.gcs.agoda.repository.custom;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.lucene.search.Query;
import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.hibernate.search.query.dsl.QueryBuilder;

import com.gcs.agoda.entity.HomestayEntity;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 30, 2019	
 *@version 1.0
 */
public class SearchRepositoryImpl implements SearchRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<HomestayEntity> filterHomestay(String name) {
		FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
		
		QueryBuilder queryBuilder = fullTextEntityManager
				.getSearchFactory()
				.buildQueryBuilder()
				.forEntity(HomestayEntity.class)
				.get();
		
		Query luceneQuery = queryBuilder
				.keyword()
	            .wildcard()
	            .onField("name")
	            .matching(name+"*")
	            .createQuery();

		// wrap Lucene query in a javax.persistence.Query
		javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, HomestayEntity.class);
		
		List<HomestayEntity> lsthome = jpaQuery.getResultList();
		return lsthome;
	}
}
