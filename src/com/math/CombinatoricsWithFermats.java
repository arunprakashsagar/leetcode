package com.math;

import java.util.HashMap;
import java.util.Map;

public class CombinatoricsWithFermats {

	public CombinatoricsWithFermats() {
	}

	static Map<Long, Long> factMap = new HashMap<Long, Long>();

	public static void main(String[] args) {
		int A = 51299;
		int B = 25646;
		int C = 3685739;
		System.out.println(nCr(A, B, C));
	}

	public static int nCr(int A, int B, int C) {
		if (B == 0)
			return 1;
		if (B == 1)
			return A % C;
		long[] fact = new long[A + 1];
		fact[0] = fact[1] = 1;
		for (int i = 2; i <= A; i++)
			fact[i] = ((i % C) * fact[i - 1]) % C;

		long a = fact[A];
		System.out.println("fact-" + A + " = " + a);
		long b = pow(fact[A - B], C - 2, C);
		System.out.println("fact-" + (A - B) + " = " + b);
		long c = pow(fact[B], C - 2, C);
		System.out.println("fact-" + B + " = " + c);
		a = (a % C * b % C) % C;
		System.out.println("ans = " + a);
		a = (a % C * c % C) % C;
		System.out.println("ans = " + a);
		return (int) a;
	}

	public static int nCrII(int A, int B, int C) {
		if (B == 0)
			return 1;
		if (B == 1)
			return A % C;
		long[] fact = new long[A + 1];
		fact[0] = fact[1] = 1;
		for (int i = 2; i <= A; i++)
			fact[i] = ((i % C) * fact[i - 1]) % C;
		long a = fact(A % C, C);

		a = a % C;
		long f = fact((A - B) % C, C);

		long b = pow(f, C - 2, C);
		b = b % C;
		long c = pow(fact(B % C, C), C - 2, C);
		c = c % C;

		return (int) ((a * b * c) % C);
	}

	private static long fact(long x, int p) {
		if (x == 0)
			return 1;
		if (factMap.containsKey(x))
			return factMap.get(x);
		System.out.println("fact-" + x + " % " + p);
		long val = (x * fact(x - 1, p)) % p;
		factMap.put(x, val);
		return val;
	}

	private static long pow(long x, long n, int p) {
		if (x == 0)
			return 0;
		if (n == 0)
			return 1;
		long ans = pow(x, n / 2, p);
		ans = (ans * ans) % p;
		if (n % 2 == 1)
			ans = (ans * x) % p;
		return ans % p;
	}

}
