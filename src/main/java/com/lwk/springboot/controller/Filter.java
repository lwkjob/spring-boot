package com.lwk.springboot.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by R9L4H0W on 2016/2/26.
 */
@WebFilter(filterName = "Filter", urlPatterns = "/*")
public class Filter implements javax.servlet.Filter {
    private  static  Logger logger= LoggerFactory.getLogger(Filter.class);

    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest servletRequest = (HttpServletRequest) req;
        HttpServletResponse servletResponse = (HttpServletResponse) resp;
        HttpResponseLwk httpResponseLwk = new HttpResponseLwk(servletResponse);

        chain.doFilter(servletRequest, servletResponse);
        //chain.doFilter(req, httpResponseLwk);
//        String content = httpResponseLwk.getContent();
//        logger.info("lwk-response:"+content);
      //  servletResponse.getWriter().print(content);

    }

    public void init(FilterConfig config) throws ServletException {

    }

}
