package com.huihuan.eme.client;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component("emeClient")
public class EMEClient {
	private RestTemplate restTemplate;
	private static final Logger log = LoggerFactory.getLogger(EMEClient.class);
	
	@Scheduled(fixedRate=5000)
	public void getUserName()
	{		
        restTemplate = new RestTemplate();
        //Create and initialize the interceptor
        final List<ClientHttpRequestInterceptor> interceptors = new ArrayList<ClientHttpRequestInterceptor>();
        interceptors.add( new BasicAuthInterceptor("admin", "admin" ));
        //restTemplate.setAsyncRequestFactory(asyncRequestFactory);
        restTemplate.setInterceptors( interceptors );
        EMEUser user = restTemplate.getForObject("http://localhost:8080/eme/api/restTest", EMEUser.class);
        log.info(user.getUsername());
	}

}
