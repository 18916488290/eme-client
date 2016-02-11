package com.huihuan.eme.client;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class EMERestTemplate extends RestTemplate {
	
	 @PostConstruct  
	 public void  init(){  
		    final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
	        interceptors.add(new BasicAuthInterceptor("admin", "admin" ));
	        setInterceptors(interceptors );
	    }  

}
