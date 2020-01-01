package com.gcs.agoda.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 17, 2019	
 *@version 1.0
 */
@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "district")
public class DistrictEntity {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@ManyToOne
	@JoinColumn(name = "city_id")
	private CityEntity cityEntity;
}
