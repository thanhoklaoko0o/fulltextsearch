package com.gcs.agoda.apiresult;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 17, 2019	
 *@version 1.0
 */
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class ApiResult {

	private int code;
	private String message;
	private Object data;
}
