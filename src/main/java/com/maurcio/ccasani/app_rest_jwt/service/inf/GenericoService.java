package com.maurcio.ccasani.app_rest_jwt.service.inf;

import java.util.List;

import com.maurcio.ccasani.app_rest_jwt.service.exeptionService.ExceptionService;

public interface GenericoService<T, ID> {
	List<T> findAll() throws ExceptionService;

	T save(T t) throws ExceptionService;
	//T update(T t)throws ExceptionService;

	T findById(ID id) throws ExceptionService;
	//delete fisico
	void deleteById(ID id) throws ExceptionService;
}
