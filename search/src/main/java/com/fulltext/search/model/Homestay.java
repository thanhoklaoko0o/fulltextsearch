package com.fulltext.search.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 15, 2019	
 *@version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Indexed
@Table(name = "homestay")
public class Homestay {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	@Field(termVector = TermVector.YES)
	@Analyzer(impl=KeywordAnalyzer.class)
	private String name;

	@Column(name = "city")
	@Field(termVector = TermVector.YES)
	@Analyzer(impl=KeywordAnalyzer.class)
	private String city;
	
	@Column(name = "district")
	@Field(termVector = TermVector.YES)
	@Analyzer(impl=KeywordAnalyzer.class)
	private String district;
	
	@Column(name = "price")
	private double price;

	@Column(name = "quality")
	private int quality;

	@Column(name = "is_payment")
	private boolean isPayment;

	@Column(name = "is_cannel")
	private boolean isCannel;

	@Column(name = "address")
	private String address;

	@Column(name = "max_person")
	private int maxPerson;

	@Column(name = "wifi")
	private boolean wifi;

	@Column(name = "airconditional")
	private boolean airconditional;

	@Column(name = "breakfast")
	private boolean breakfast;

	@Column(name = "pool")
	private boolean pool;

	@Column(name = "image")
	private String image;

	@Column(name = "create_date")
	private LocalDate createDate;

}
