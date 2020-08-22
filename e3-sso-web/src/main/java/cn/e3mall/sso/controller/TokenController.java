package cn.e3mall.sso.controller;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.e3mall.common.utils.E3Result;
import cn.e3mall.common.utils.JsonUtils;
import cn.e3mall.sso.service.TokenService;

/**
 * 根据token查询用户信息Controller
 * @author 51145
 *
 */
@Controller
public class TokenController {

	@Autowired
	private TokenService tokenService;
	
	@RequestMapping("/user/token/{token}")
	@ResponseBody
	public String getUserByToken(@PathVariable String token,String callback) {
		
		E3Result result = tokenService.getUserByToken(token);
		//响应结果之前,判断是否为jsonp请求
		if(StringUtils.isNotBlank(callback)) {
			//把结果封装成一个js语句响应
			return callback+"("+JsonUtils.objectToJson(result)+");";
		}
		return  JsonUtils.objectToJson(result);
	}
}
