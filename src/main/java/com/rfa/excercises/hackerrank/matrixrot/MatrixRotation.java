package com.rfa.excercises.hackerrank.matrixrot;

public class MatrixRotation {

	private static void rotate(int[][] matrix, int m, int n, int r) {
		rotate(matrix, m, n, r, 0);
	}

	private static void rotate(int[][] matrix, int m, int n, int r, int s) {
		if (m / 2 >= 1 && n / 2 >= 1)
			rotate(matrix, m - 2, n - 2, r, s + 1);
		else
			return;
		int[] layer = extractOuterLayer(matrix, m, n, s);
		// print(layer);
		rotate(layer, r);
		setOuterLayer(matrix, m, n, layer, s);
	}

	public static void rotate(int[] array, int r) {
		if (array == null || array.length == 0 || r < 0) {
			throw new IllegalArgumentException("Illegal argument!");
		}
		if (r > array.length) {
			r = r % array.length;
		}
		int a = r;
		reverse(array, 0, a - 1);
		reverse(array, a, array.length - 1);
		reverse(array, 0, array.length - 1);

	}

	public static void reverse(int[] array, int left, int right) {
		if (array == null || array.length == 1)
			return;
		while (left < right) {
			int temp = array[left];
			array[left] = array[right];
			array[right] = temp;
			left++;
			right--;
		}
	}

	private static int[] extractOuterLayer(int[][] matrix, int m, int n, int s) {
		int[] array = new int[m * 2 + n * 2 - 4];
		for (int j = 0; j < n - 1; j++) {
			array[j] = matrix[s][j + s];
			array[j + n + m - 2] = matrix[m - 1 + s][n - j - 1 + s];
		}
		for (int i = 0; i < m - 1; i++) {
			array[i + n - 1] = matrix[i + s][n - 1 + s];
			array[i + 2 * n + m - 3] = matrix[m - i - 1 + s][s];
		}
		return array;
	}

	private static void setOuterLayer(int[][] matrix, int m, int n, int[] array, int s) {
		for (int j = 0; j < n - 1; j++) {
			matrix[s][j + s] = array[j];
			matrix[m - 1 + s][n - j - 1 + s] = array[j + n + m - 2];
		}
		for (int i = 0; i < m - 1; i++) {
			matrix[i + s][n - 1 + s] = array[i + n - 1];
			matrix[m - i - 1 + s][s] = array[i + 2 * n + m - 3];
		}
	}

	/*
	 * private static void print(int[] array) { for (int i = 0; i <
	 * array.length; i++) { System.out.print(array[i] + " "); }
	 * System.out.println(); }
	 */

	private static void print(int[][] matrix, int M, int N) {
		for (int i = 0; i < M; i++) {
			for (int j = 0; j < N; j++) {
				System.out.print(matrix[i][j] + " ");
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		/*
		 * Scanner in = new Scanner(System.in); int m = in.nextInt(); int n =
		 * in.nextInt(); int r = in.nextInt(); int[][] matrix = new int[m][n];
		 * for(int i=0;i<m;i++){ for(int j=0;j<n;j++){ matrix[i][j] =
		 * in.nextInt(); } }
		 */
		int[][] matrix = new int[4][4];
		matrix[0] = new int[] { 1, 2, 3, 4 };
		matrix[1] = new int[] { 5, 6, 7, 8 };
		matrix[2] = new int[] { 9, 10, 11, 12 };
		matrix[3] = new int[] { 13, 14, 15, 16 };
		rotate(matrix, 4, 4, 1);
		print(matrix, 4, 4);
	}
}