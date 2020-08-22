package cn.e3mall.search.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;


/**
 * 全局异常处理器
 * @author 51145
 *
 */
public class GlobalExceptionResolver implements HandlerExceptionResolver {

	private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionResolver.class); 
	@Override
	public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler,
			Exception ex) {
		//打印控制台
		ex.printStackTrace();
		
		logger.debug("测试输入的日志");
		logger.info("系统发生异常了");
		logger.error("系统发生异常",ex);
		ModelAndView m = new ModelAndView();
		m.setViewName("error/exception");
		return m;
	}

}
