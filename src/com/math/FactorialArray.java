package com.math;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class FactorialArray {
	static int mod = 1000 * 1000 * 1000 + 7;

	public FactorialArray() {
	}

	public static void main(String[] args) {
		int[] A = { 2, 3, 4, 5, 6 };
		System.out.println(solve(A));
	}

	public static int solve(int[] A) {

		int maxNum = max(A);

		int[] isPrime = getSieve(maxNum);
		int[] primeFactors = getPrimeFactors(maxNum, isPrime);

		// Prime factor frequency map
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : A) {
			int factors = primeFactors[num];
			if (factors == 0)
				continue;
			map.put(factors, map.getOrDefault(factors, 0) + 1);
		}
		// power array
		int max = Collections.max(map.values());
		int[] pow = new int[max + 1];
		pow[0] = 1;
		for (int i = 1; i <= max; i++)
			pow[i] = pow[i - 1] * 2;

		// Final result
		int ans = 0;
		for (Integer count : map.values()) {
			if (count < 2)
				ans = (ans + count) % mod;
			else
				ans = (ans + pow[count] - 1) % mod;
		}
		return ans;
	}

	private static int max(int[] A) {
		int max = 0;
		for (int num : A)
			if (max < num)
				max = num;
		return max;
	}

	static Map<Integer, Integer> pf = new HashMap<>();

	private static int[] getPrimeFactors(int max, int[] isPrime) {
		int[] pf = new int[max + 1];

		int count = 0;
		for (int i = 0; i <= max; i++) {
			if (isPrime[i] == 0) {
				count++;
			}
			pf[i] = count;
		}
		return pf;
	}

	private static int[] getSieve(int A) {
		int[] isprime = new int[A + 1];
		isprime[0] = 1;
		isprime[1] = 1;
		for (int i = 2; i * i <= A; i++) {
			if (isprime[i] == 0) {
				for (int j = i * i; j <= A; j = j + i) {
					isprime[j] = 1;
				}
			}
		}
		return isprime;
	}

}
