package com.weihui;

public class Main {
	

	public static void main(String[] args) {
		Random instance = Random.getInstance(180);
		for (int j = 0; j < 100; j++) {
			// first, convert the int from signed to "unsigned"
			long l = (long) instance.getMersenneTwisterFast().nextInt(10);
			if (l < 0)
				l += 4294967296L; // max int value
			String s = String.valueOf(l);
			while (s.length() < 10)
				s = " " + s; // buffer
			System.out.print(s + " ");
			if (j % 5 == 4)
				System.out.println();
		}
	}

}
