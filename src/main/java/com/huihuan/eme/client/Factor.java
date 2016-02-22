package com.huihuan.eme.client;

/**
 * @author 任宏涛， ren@ecust.edu.cn
 *
 * @created 2016年1月4日 下午10:03:15
 *
 */
public class Factor {
	
	private long factorId;
	private float min;
	private float max;
	private float mMin;
	private float mMax;
	
	

	public Factor(long factorId, float min, float max, float mMin, float mMax) {
		this.factorId = factorId;
		this.min = min;
		this.max = max;
		this.mMin = mMin;
		this.mMax = mMax;
	}
	/**
	 * @return the factorId
	 */
	public long getFactorId() {
		return factorId;
	}
	/**
	 * @param factorId the factorId to set
	 */
	public void setFactorId(long factorId) {
		this.factorId = factorId;
	}
	/**
	 * @return the min
	 */
	public float getMin() {
		return min;
	}
	/**
	 * @param min the min to set
	 */
	public void setMin(float min) {
		this.min = min;
	}
	/**
	 * @return the max
	 */
	public float getMax() {
		return max;
	}
	/**
	 * @param max the max to set
	 */
	public void setMax(float max) {
		this.max = max;
	}
	/**
	 * @return the mMin
	 */
	public float getmMin() {
		return mMin;
	}
	/**
	 * @param mMin the mMin to set
	 */
	public void setmMin(float mMin) {
		this.mMin = mMin;
	}
	/**
	 * @return the mMax
	 */
	public float getmMax() {
		return mMax;
	}
	/**
	 * @param mMax the mMax to set
	 */
	public void setmMax(float mMax) {
		this.mMax = mMax;
	}
	
}
