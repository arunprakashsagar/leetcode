package com.scaler.math;

import java.math.BigInteger;

public class VeryLargePower {

	public VeryLargePower() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int a = 2, b = 27;
		System.out.println(solve(a, b));

	}

	static int mod = 1000 * 1000 * 1000 + 7;

	public static int solve(int A, int B) {
		long p = 1;
		for (int i = B; i > 1; i--) {
			p = (p * i)%mod;
			System.out.println("p= " + p);
		}
		return (int) power(A % mod, p);
	}

	public static int solve1(int A, int B) {
		long ans = A;
		for (int i = B; i > 1; i--) {
			ans = power(ans % mod, i);
		}
		return (int) ans;
	}

	private static long power(long A, long B) {
		if (A == 0)
			return 0;
		if (B == 0)
			return 1;
		if (B == 1)
			return A;
		long ans = power(A, B / 2);
		ans = (ans * ans) % mod;
		if (B % 2 == 1)
			ans = (ans * A) % mod;
		System.out.println("B = " + B + ", ans = " + ans);
		return ans;
	}

}
