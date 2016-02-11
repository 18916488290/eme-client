package com.huihuan.eme.client;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component("emeClient")
public class EMEClient {
	@Autowired private EMERestTemplate restTemplate;
	private static final Logger log = LoggerFactory.getLogger(EMEClient.class);
	
	@Scheduled(fixedRate=5000)
	public void getUserName()
	{
        EMEUser user = restTemplate.getForObject("http://localhost:8080/eme/api/restTest", EMEUser.class);
        log.debug(user.getUsername());
	}

}
