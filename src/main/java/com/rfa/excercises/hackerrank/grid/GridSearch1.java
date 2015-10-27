package com.rfa.excercises.hackerrank.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class GridSearch1 {

	public static void main(String[] args) throws IOException {
		try (BufferedReader input = new BufferedReader(new InputStreamReader(System.in))) {
			int numTestCases = Integer.parseInt(input.readLine());
			assert numTestCases >= 1 && numTestCases <= 5;
			// int[][] grid;
			// int[][] pattern;
			List<String> answers = new LinkedList<>();
			for (int t = 0; t < numTestCases; t++) {
				String testDim = input.readLine();
				String[] dim = testDim.split("\\s");
				int tR = Integer.parseInt(dim[0]);
				// int tC = Integer.parseInt(dim[1]);
				String[] testLines = new String[tR];
				for (int r = 0; r < tR; r++) {
					testLines[r] = input.readLine();
				}
				testDim = input.readLine();
				dim = testDim.split("\\s");
				tR = Integer.parseInt(dim[0]);
				// tC = Integer.parseInt(dim[1]);
				RC xy = new RC();
				for (int r = 0; r < tR; r++) {
					String linePattern = input.readLine();
					match(testLines, linePattern, xy);
				}
				answers.add(xy.linesMatched == tR ? "YES" : "NO");
			}
			for (String answer : answers) {
				System.out.println(answer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void match(String[] testLines, String linePattern, RC xy) {
		int end = xy.linesMatched == 0 ? testLines.length : xy.r + 2;
		boolean found = false;
		System.out.println(xy + " " + end);
		for (int i = xy.r + 1; i < end; i++) {
			int index = testLines[i].indexOf(linePattern);
			if ((xy.linesMatched == 0 && index >= 0) || (xy.linesMatched > 0 && index == xy.c)) {
				xy.r = i;
				xy.c = index;
				xy.linesMatched++;
				found = true;
				break;
			}
		}
		if (!found)
			xy.reset();
	}

	static class RC {
		int r = -1;
		int c = -1;
		int linesMatched = 0;

		void reset() {
			r = -1;
			c = -1;
			linesMatched = 0;
		}

		public String toString() {
			return r + " " + c + " " + linesMatched;
		}
	}
}
