package com.MO.Software.base;

import java.util.List;
import java.util.Optional;

public interface baseServiceInterface <T,ID>{
	  	List<T> findAll();
	    Optional<T> findById(ID id);
	    T save(T entity);
	    void deleteById(ID id);
	    void delete(T entity);
}