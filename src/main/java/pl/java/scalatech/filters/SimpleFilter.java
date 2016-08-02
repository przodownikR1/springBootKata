package pl.java.scalatech.filters;

import java.io.IOException;
import java.util.Random;
import java.util.UUID;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;

import lombok.extern.slf4j.Slf4j;
@Slf4j
public class SimpleFilter implements Filter{
    public static final String REQUEST_ID_KEY = "request_id";
    private  Random random = new Random(); 
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
     log.info("init simpleFilter");
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
           log.info( "req : filter ok !");
           HttpServletRequest httpRequest = (HttpServletRequest) request;                     
           putMDC(httpRequest);           
           try {
               chain.doFilter(request, response);
           } finally {
               clearMDC();
           }        
    }

    private void clearMDC() {
        MDC.remove("userid");
           MDC.remove(REQUEST_ID_KEY);
    }

    private void putMDC(HttpServletRequest httpRequest) {
           String uuid = UUID.randomUUID().toString();
           MDC.put(REQUEST_ID_KEY,uuid);
           String requestURI = httpRequest.getRequestURI();
           MDC.put("req.requestURI", requestURI);
           String queryString = httpRequest.getQueryString();
           MDC.put("req.queryString", queryString);
           String ip = getIpAddr(httpRequest);
           MDC.put("req.remoteAddr", ip);
           
           log.info("request_ID_KEY : {}",uuid);
           log.info("requestURI : {}", requestURI);
           log.info("req.queryString : {}", queryString);
           log.info("req.remoteAddr: {}",ip);
           
           if(random.nextBoolean()==true){
               MDC.put("userid","przodownik" );
               log.info("+++ przodownik");               
           }else{
               MDC.put("userid", "tyson");
               log.info("+++ tyson");
           }
    }
    public static String getIpAddr(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        if (ip != null && ip.length() > 20) {
            log.info("ip.length()>20 trim: {}", ip);
            ip = ip.substring(0, 20);
        }
        return ip;
    }
    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        
    }

}
