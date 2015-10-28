package com.rfa.excercises.hackerrank.encryption;

import java.util.Scanner;

public class Encryption {
	public static void main(String... args) {
		try (Scanner scan = new Scanner(System.in);) {
			String line = scan.nextLine();
			encrypt(line);
		} catch (Exception e) {

		}
	}

	private static void encrypt(String line) {
		int N = line.length();
		int rows = (int) Math.round(Math.sqrt((double) N));
		int cols = (int) Math.ceil((double) N / (double) rows);
		System.out.println(rows+" "+cols);
		int i = 0, j = 0;
		char[][] matrix = new char[cols][rows];
		for (int c = 0; c < cols * rows; c++) {
			i = c / cols;
			j = c % cols;
			if (c < N)
				matrix[j][i] = line.charAt(c);
			else
				matrix[j][i] = ' ';
		}
		for (int c = 0; c < cols; c++) {
			String encline = new String(matrix[c]);
			encline = encline.trim();
			System.out.print(encline);
			if (c < cols - 1)
				System.out.print(" ");
		}
	}

}
