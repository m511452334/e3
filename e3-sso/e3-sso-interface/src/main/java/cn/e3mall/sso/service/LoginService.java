package cn.e3mall.sso.service;

import cn.e3mall.common.utils.E3Result;

public interface LoginService {
	
	//参数:用户名 密码
	E3Result userLogin(String username,String password);
}
