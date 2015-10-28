package com.rfa.excercises.hackerrank.timewords;

import java.util.Scanner;

public class TimeWords {

	private static final String[] numNames = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight",
			"nine", "ten", "eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen", "eighteen",
			"nineteen" };

	public static void main(String... args) {
		try (Scanner scan = new Scanner(System.in);) {
			int H = scan.nextInt();
			int M = scan.nextInt();
			System.out.println(name(H, M));
		} catch (Exception e) {

		}
	}

	static String name(int h, int m) {
		String name = "";
		if (m == 0)
			name = numNames[h] + " o' clock";
		else if (m == 30)
			name = "half past " + numNames[h];
		else if (m == 15)
			name = "quarter past " + numNames[h];
		else if (m == 45) {
			name = "quarter to " + (h + 1 < 13 ? numNames[h + 1] : numNames[1]);
		} else if (m < 30) {
			name = numberLess30Name(m) + " minutes past " + numNames[h];
		} else {
			name = numberLess30Name(60 - m) + " minutes to " + (h + 1 < 13 ? numNames[h + 1] : numNames[1]);
		}

		if (m == 1 || m == 59)
			name = name.replace("minutes", "minute");
		return name;
	}

	static String numberLess30Name(int number) {
		String name = "";
		if (number < 20)
			name = numNames[number];
		else if (number == 20)
			name = "twenty";
		else
			name = "twenty " + numNames[number % 20];
		return name;
	}
}
