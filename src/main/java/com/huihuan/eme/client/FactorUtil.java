package com.huihuan.eme.client;

import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午10:03:15
 *
 */
@Component("factorUtil")
public class FactorUtil {
	
	Map<Long,Factor> factorMap = new LinkedHashMap<Long,Factor>(); 
	
	public Map<Long,Factor> getAirFactorMap()
	{
		Factor so2 = new Factor(1l,0f,2620f,20f,2000f);
		Factor no2 =  new Factor(2l,0f,940f,10f,750f);
		Factor pm10 =  new Factor(3l,0f,600f,20f,500f);
		Factor co =  new Factor(4l,0f,60f,1f,50f);
		Factor o3 =  new Factor(5l,0f,1200f,50f,1000f);
		Factor pm25 =  new Factor(6l,0f,500f,10f,450f);
		factorMap.put(1l, so2);
		factorMap.put(2l, no2);
		factorMap.put(3l, pm10);
		factorMap.put(4l, co);
		factorMap.put(5l, o3);
		factorMap.put(6l, pm25);
		
		return factorMap;
	}
}
