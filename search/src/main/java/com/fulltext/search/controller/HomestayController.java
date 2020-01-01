package com.fulltext.search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fulltext.search.model.Homestay;
import com.fulltext.search.service.HomestayService;

/*
 *(C) Copyright 2020
 *@author USER
 *@date   Jan 1, 2020	
 *@version 1.0
 */
@RestController
@RequestMapping("/homestay")
public class HomestayController {

	@Autowired
	private HomestayService homestayService;
	
	@GetMapping
	public List<Homestay> getHeyWord(@RequestParam String name) {
		return homestayService.searchKeyWord(name);
	}
	
	@PostMapping
	public void add(@RequestBody Homestay homestay) {
		homestayService.AddHomeStay(homestay);
	}
}
