package com.math;

public class CombinatoricsWithDPAndRecursion {

	public CombinatoricsWithDPAndRecursion() {
		// TODO Auto-generated constructor stub
	}

	static long[][] seen = null;

	public static void main(String[] args) {
		int A = 100;
		int B = 30;
		int C = 1001;
		seen = new long[A + 1][B + 1];
		//System.out.println(nCr_with_DP(A, B, C)); 
		System.out.println(nCr_with_recursion(A, B, C)); 
	}

	public static long nCr_with_recursion(int n, int r, int m) {
		if (r > n)
			return 0;
		if (r == 0 || r == n)
			return 1;
		if (r == 1)
			return n % m;

		if (seen[n][r] == 0) {
			seen[n - 1][r - 1] = nCr_with_recursion(n - 1, r - 1, m);
			seen[n - 1][r] = nCr_with_recursion(n - 1, r, m);
			seen[n][r] = (seen[n - 1][r - 1] + seen[n - 1][r]) % m;
		}
		return seen[n][r];
	}

	public static long nCr_with_DP(int A, int B, int C) {

		for (int i = 0; i <= A; i++)
			seen[i][0] = 1;
		for (int i = 1; i <= A; i++) {
			for (int j = 1; j <= B && i >= j; j++) {

				if (i == j) {
					seen[i][j] = 1;
				} else {
					seen[i][j] = (seen[i - 1][j - 1] % C + seen[i - 1][j] % C) % C;
				}
			}
		}
		return seen[A][B];
	}

}
