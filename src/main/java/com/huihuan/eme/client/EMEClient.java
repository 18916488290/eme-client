package com.huihuan.eme.client;


import java.util.Map;
import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;


@Component("emeClient")
public class EMEClient {
	
	@Autowired private EMERestTemplate restTemplate;
	@Autowired private FactorUtil factorUtil;
	private static final Logger log = LoggerFactory.getLogger(EMEClient.class);
	
	private String uploadFactorURL = "http://localhost:8080/eme/api/uploadFactorValue";
	private String MN1 = "20050708S00001";
	private String MN2 = "20050708S00002";
	//private long stationId= 1l;
	
	
	private String calAirURL = "http://localhost:8080/eme/api/calc";
	

	@Scheduled(fixedRate=10000)
	public void uploadFactorValue()
	{
		 log.warn("上传空气质量检测因子数据。。。。。。");
		 uploadAirFactorValToStation(1l,MN1);
		 uploadAirFactorValToStation(2l,MN2);
	}
	
	@Scheduled(fixedRate=1000*60*60)
	public void calcAir()
	{
		String response = restTemplate.getForObject(calAirURL, String.class);
	}
	
	private void  uploadAirFactorValToStation(long stationId,String MN)
	{

		
		Map<Long,Factor> factorMap= factorUtil.getAirFactorMap();
		Random rand =new Random();
		
		for(long factorId: factorMap.keySet())
		{
			Factor factor = factorMap.get(factorId);
			float normalizedVal =rand.nextFloat();
			float min = factor.getMin();
			float max = factor.getmMax();
			float val = min +(max-min)*normalizedVal;
			int iVal = (int)val;
			
			FactorValue fv = new FactorValue();
			fv.setDaily(true);
			fv.setStationId(stationId);
			fv.setFactorId(factorId);
			fv.setMn(MN);
			fv.setVal(iVal);
			String response = restTemplate.postForObject(uploadFactorURL, fv, String.class);
			log.warn(response);
		}
		
       
	
		
	}
	

}
