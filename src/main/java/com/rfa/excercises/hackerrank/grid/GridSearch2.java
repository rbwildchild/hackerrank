package com.rfa.excercises.hackerrank.grid;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;

public class GridSearch2 {

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
				String[] patternLines = new String[tR];
				for (int r = 0; r < tR; r++) {
					patternLines[r] = input.readLine();
				}
				boolean match = match(testLines, patternLines);
				answers.add(match ? "YES" : "NO");
			}
			for (String answer : answers) {
				System.out.println(answer);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static boolean match(String[] testLines, String[] patternLines) {
		return match(testLines, patternLines, 0, 0, 0, 0);
	}

	private static boolean match(String[] testLines, String[] patternLines, int i, int j, int pl, int lm) {
		if (lm == patternLines.length)
			return true;
		int end = lm == 0 || i + 2 >= testLines.length ? testLines.length : i + 2;
		boolean match = false;
		// System.out.println(i + " " + j + " " + pl + " " + lm + " " + end);
		A: for (int r = i; r < end; r++) {
			List<Integer> indexes = getIndexes(testLines[r], patternLines[pl]);
			//System.out.println(indexes);
			for (Integer index : indexes) {
				// System.out.println("r " + r + " index " + index);
				if ((lm == 0 && index > -1) || (lm > 0 && index == j)) {
					match = match(testLines, patternLines, r + 1, index, pl + 1, lm + 1);
				}
				if (match)
					break A;
			}
		}
		return match;
	}

	private static List<Integer> getIndexes(String line, String pattern) {
		List<Integer> indexes = new LinkedList<>();
		int index = -1;
		while (true) {
			index = line.indexOf(pattern, ++index);
			if (index > -1) {
				indexes.add(index);
			} else
				break;
		}
		return indexes;
	}

}
