package pl.java.scalatech.filters;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SimpleFilter implements Filter{

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     log.info("init simpleFilter");
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
           log.info( "req : filter ok !");
           chain.doFilter(request, response);
        
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
