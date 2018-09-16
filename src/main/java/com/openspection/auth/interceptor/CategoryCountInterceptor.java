package com.openspection.auth.interceptors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.openspection.auth.model.Category;
import com.openspection.auth.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.ModelAndView;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

@Component
public class CategoryCountInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private PostService PostService;

    @Override
    public void postHandle(HttpServletRequest request, 
            HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
	if (PostService != null) {
		for (Category cat : Category.values()) {
			modelAndView.getModelMap().addAttribute(cat.toString(), PostService.countByCategory(cat));
		}
	}
    }

}
