package com.gcs.agoda.controller;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.search.jpa.FullTextEntityManager;
import org.hibernate.search.jpa.Search;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.gcs.agoda.apiresult.ApiResult;
import com.gcs.agoda.dto.SearchDTO;
import com.gcs.agoda.entity.HomestayEntity;
import com.gcs.agoda.repository.HomeStayRepository;
import com.gcs.agoda.service.HomeStayService;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 14, 2019	
 *@version 1.0
 */
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/homestay")
public class HomeController extends BaseController {

	@Autowired
	private HomeStayService homeStayService;
	
	@Autowired
	private HomeStayRepository homeStayRepository;
	
	@Autowired
	private EntityManager entityManager;
	
	@GetMapping("/index")
	public void index() {
		FullTextEntityManager fullTextEntityManager 
		= Search.getFullTextEntityManager(entityManager);
		try {
			fullTextEntityManager.createIndexer().startAndWait();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@PostMapping("/add")
	public void add(@RequestBody HomestayEntity entity) {
		homeStayRepository.save(entity);
	}
	
	@GetMapping("/search")
	public List<HomestayEntity> fullTextSearch(@RequestParam String name) {
		
		return homeStayService.filterHomestay(name);
	}
	
//	private FullTextQuery getJpaQuery(org.apache.lucene.search.Query luceneQuery) {
//
//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//
//        return fullTextEntityManager.createFullTextQuery(luceneQuery, HomestayEntity.class);
//    }
//
//	
//	private QueryBuilder getQueryBuilder() {
//
//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//
//        return fullTextEntityManager.getSearchFactory()
//            .buildQueryBuilder()
//            .forEntity(HomestayEntity.class)
//            .get();
//    }
	

	@PostMapping("/ok")
	public List<HomestayEntity> getList(@RequestBody SearchDTO dto ) {
		
		List<HomestayEntity> list = homeStayService.filterSearch(dto);
		return list;
	}

	@GetMapping
	public Page<HomestayEntity> getHomestayPage(@RequestParam("page") int page ,@RequestParam("size")int size) {
		return homeStayService.getHomestayPage(PageRequest.of(page, size));
	}

	@PostMapping
	public ApiResult getResultSearch(@RequestBody SearchDTO searchDTO) {
		
		// Get page and sizePage
		PageRequest pageReq = PageRequest.of(searchDTO.getPage(), searchDTO.getSizePage());
		
		// Check parameter search
		if (searchDTO.getType() == 1) {
			ApiResult result = createResult(homeStayService.findAllByName(searchDTO, pageReq), 200);
			return result;
		}
			
		if (searchDTO.getType() == 2) {
			ApiResult result = createResult(homeStayService.findAllByDistrict(searchDTO, pageReq), 200);
			return result;
		}
		
		ApiResult result = createResult(homeStayService.findAllByCity(searchDTO, pageReq), 200);
		return result;
	}
}
