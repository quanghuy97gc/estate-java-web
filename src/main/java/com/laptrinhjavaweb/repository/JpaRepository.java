package com.laptrinhjavaweb.repository;

import java.util.List;
import java.util.Map;

import com.laptrinhjavaweb.paging.Pageable;

public interface JpaRepository<T> {
	List<T> findAll(Map<String, Object> params, Pageable pageable, Object... where);
	List<T> findAll(Map<String, Object> params, Object... where);
	List<T> findAll(String sqlSearch, Pageable pageable);
	T findById(Long id);
	Long insert(T entity,List<Object> entities);
	Long insert(T entity);
	String delete(Long id);
	String delete(Long[] ids);
}
