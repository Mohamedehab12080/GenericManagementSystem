package com.MO.Software.Login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.MO.Software.Login.loginModel;
import com.MO.Software.base.baseRepository;
import com.MO.Software.base.baseServiceImpl;

@Service
public class loginServiceImpl extends baseServiceImpl<loginModel,Long> 
implements loginServiceInterface{
	
	@Autowired
	private loginRepository loginRepository;
	
	@Override
	public Long checkLogin(String username, String password) {
		loginModel login=loginRepository.findByUserNameAndPassword(username, password);
		
		if(login!=null)
		{
			return login.getEmployeeModel().getId();
		}else
		{
			return -1L;
		}
	}

	@Override
	protected baseRepository<loginModel, Long> getRepository() {
		return loginRepository;
	}

}
