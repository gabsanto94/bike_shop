package com.revature.bikeshop.utils;

import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CORSFilter extends GenericFilterBean implements Filter {

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        httpResponse.setHeader("Access-Control-Allow-Origin", "http://localhost:4200");
        //httpResponse.setHeader("Access-Control-Allow-Methods", "POST, GET, PUT, OPTIONS, DELETE");
        //* to allow all members
        httpResponse.setHeader("Access-Control-Allow-Methods", "*");

        //Second Parameter: it can be Origin, Content-Type, X-Auth-Token, Authorization
        httpResponse.setHeader("Access-Control-Allow-Headers", "*");

        httpResponse.setHeader("Access-Control-Allow-Credentials", "false");
        httpResponse.setHeader("Access-Control-Max-Age", "3600");

        filterChain.doFilter(servletRequest, servletResponse);

        System.out.println("CROSS ORIGIN FINISH SETTING UP....");
    }
}
