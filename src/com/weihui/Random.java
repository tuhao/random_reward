package com.weihui;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

public class Random {

	private static byte[] mutex = new byte[0]; 
	private MersenneTwisterFast mersenneTwisterFast = new MersenneTwisterFast();

	private static Random instance = null;
	private ArrayBlockingQueue<Integer> queue = null;
	private int sum = 1;   //��ʼ��
	private Set<Integer> cache = new HashSet<Integer>();
	
	private Random(int sum){
		if(sum > 0){
			this.sum = sum;
		}
		queue = new ArrayBlockingQueue<Integer>(this.sum);
		init(sum);
	}
	
	private Random(int sum,int seed){
		if(sum > 0){
			this.sum = sum;
		}
		queue = new ArrayBlockingQueue<Integer>(sum);
		init(sum);
	}
	
	
	private void init(int sum){
		queue.clear();
		while(queue.size() < sum){
			int num = mersenneTwisterFast.nextInt(sum);
			if(cache.add(num)){
				queue.offer(num);
			}
		}
		cache.clear();
	}
	
	
	public static Random getInstance(int sum){
		synchronized (mutex) {
			if(instance == null){
				instance = new Random(sum);
			}
		}
		return instance;
	}
	
	public int nextInt(){
		Object obj = queue.poll();
		if(obj == null){
			init(sum);
			return nextInt();
		}else{
			return ((Integer) obj).intValue();
		}
	}
	
	
	//for speed test 
	protected static Random getInstance(int sum,long seed){
		synchronized (mutex) {
			if(instance == null){
				instance = new Random(sum,seed);
			}
		}
		return instance;
	}
	
	private Random(int sum,long seed){
		if(sum > 0){
			this.sum = sum;
		}
		mersenneTwisterFast = new MersenneTwisterFast(seed);
		queue = new ArrayBlockingQueue<Integer>(this.sum);
		init(sum);
	}
	
	

}
