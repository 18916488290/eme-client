package com.huihuan.eme.client;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableScheduling
@SpringBootApplication
public class Application implements CommandLineRunner {

    public static void main(String args[]) {
    	ConfigurableApplicationContext ctx =  SpringApplication.run(Application.class,args);
    	EMEClient emeClient = ctx.getBean(EMEClient.class);
    	emeClient.getUserName();
    }


	@Override
	public void run(String... arg0) throws Exception {
		// TODO Auto-generated method stub
		
	}


}