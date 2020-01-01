package com.gcs.agoda.controller;

import com.gcs.agoda.apiresult.ApiResult;

/*
 *(C) Copyright 2019
 *@author USER
 *@date   Dec 17, 2019	
 *@version 1.0
 */
public abstract class BaseController {

	ApiResult createResult(Object data, int code) {
		ApiResult apiResult = new ApiResult();
		apiResult.setData(data);
		apiResult.setCode(code);
		return apiResult;
	}
}
