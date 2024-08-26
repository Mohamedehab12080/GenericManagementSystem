package com.MO.Software.Login.service;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.MO.Software.Login.loginModel;
import com.MO.Software.base.baseRepository;

@Repository
public interface loginRepository extends baseRepository<loginModel,Long>{

	@Query("SELECT l from loginModel l where l.username=:username And l.password=:password")
	loginModel findByUserNameAndPassword(String username,String password);

}
