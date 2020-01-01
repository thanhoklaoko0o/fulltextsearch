package com.gcs.agoda.entity;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.apache.lucene.analysis.core.KeywordAnalyzer;
import org.hibernate.search.annotations.Analyzer;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.TermVector;

import com.gcs.agoda.CustomAuthorAnalyzer;

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
public class HomestayEntity {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@Column(name = "name")
	@Field(termVector = TermVector.YES)
	@Analyzer(impl=CustomAuthorAnalyzer.class)
	private String name;

	@Column(name = "price")
	private Double price;

	@Column(name = "quality")
	private Integer quality;

	@Column(name = "is_payment")
	private Boolean isPayment;

	@Column(name = "is_cannel")
	private Boolean isCannel;

	@Column(name = "address")
	private String address;

	@Column(name = "max_person")
	private Integer maxPerson;

	@Column(name = "wifi")
	private Boolean wifi;

	@Column(name = "airconditional")
	private Boolean airconditional;

	@Column(name = "breakfast")
	private Boolean breakfast;

	@Column(name = "pool")
	private Boolean pool;

	@Column(name = "image")
	private String image;

	@Column(name = "create_date")
	private LocalDate createDate;

	@ManyToOne
	@JoinColumn(name = "district_id")
	private DistrictEntity districtEntity;

}
