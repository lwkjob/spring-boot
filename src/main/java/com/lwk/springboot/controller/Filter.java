package com.lwk.springboot.controller;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by R9L4H0W on 2016/2/26.
 */
@WebFilter(filterName = "Filter",urlPatterns="/*")
public class Filter implements javax.servlet.Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
      HttpServletRequest servletRequest=(HttpServletRequest)req;
      HttpServletResponse  servletResponse=(HttpServletResponse)resp;
        System.out.println(servletRequest.getQueryString());


        chain.doFilter(req, new HttpResponseLwk(servletResponse));
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
