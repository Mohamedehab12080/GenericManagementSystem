package com.MO.Software.Login.service;

import com.MO.Software.Login.loginModel;
import com.MO.Software.base.baseServiceInterface;

public interface loginServiceInterface extends baseServiceInterface<loginModel,Long>{

	Long checkLogin(String username,String password);
}
