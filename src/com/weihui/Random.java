package com.weihui;

import java.util.HashSet;
import java.util.Set;

public class Random {

	private static byte[] mutex = new byte[0]; 
	private Set<Integer> buffers = new HashSet<Integer>();
	private MersenneTwisterFast mersenneTwisterFast = new MersenneTwisterFast();

	private static Random instance = null;
	private int sum;
	private int count;
	
	public void reset(){
		if(buffers != null){
			buffers.clear();
		}else{
			buffers = new HashSet<Integer>();
		}
		count = 0;
	}
	
	private Random(int sum){
		this.sum = sum;
	}
	
	public static Random getInstance(int sum){
		synchronized (mutex) {
			if(instance == null){
				instance = new Random(sum);
			}
		}
		return instance;
	}
	
	public long nextInt(){
		count += 1;
		int num = mersenneTwisterFast.nextInt(sum);
		return 0;
	}


	public MersenneTwisterFast getMersenneTwisterFast() {
		return mersenneTwisterFast;
	}
	
	

}
