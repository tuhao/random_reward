package com.weihui;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Main {
	

	public static void main(String[] args) {
		Random instance = Random.getInstance(180);
		Map<Integer,Integer> map = new HashMap<Integer,Integer>();
		for (int j = 0; j < 1000; j++) {
			// first, convert the int from signed to "unsigned"
			int l = instance.nextInt();
			if(map.get(l) == null){
				map.put(l, 1);
			}else{
				map.put(l, map.get(l) + 1);
			}
			if (l < 0)
				l += 4294967296L; // max int value
			String s = String.valueOf(l);
			while (s.length() < 10)
				s = " " + s; // buffer
			System.out.print(s + " ");
			if (j % 5 == 4)
				System.out.println();
		}
		Integer[] a = new Integer[map.size()];
		map.keySet().toArray(a);
		Arrays.sort(a);
		for(int i :a){
			System.out.println("number:" + i + ", show times:" + map.get(i));
		}
		
	}

}
