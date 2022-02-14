package com.math;

import java.util.Random;

public class RandomPickWithWeight {
	private int[] prefixSum = null;
	private int totalSum = 0;
	private static Random rand = new Random();

	public RandomPickWithWeight(int[] w) {
		int n = w.length;
		this.prefixSum = new int[n];
		this.totalSum = 0;
		for (int i = 0; i < n; i++) {
			this.totalSum += w[i];
			this.prefixSum[i] = this.totalSum;
		}
	}

	public int pickIndex() {
		double target = (rand.nextDouble() * this.totalSum);
		int l = 0, h = this.prefixSum.length;
		while (l < h) {
			int mid = (l + h) / 2;
			if (target > prefixSum[mid])
				l = mid + 1;
			else
				h = mid;
		}
		return l;

	}

	public static void main(String[] args) {
		int[] w = { 1, 2, 3, 4 };
		RandomPickWithWeight obj = new RandomPickWithWeight(w);
		for (int i = 0; i < 10; i++)
			//System.out.println(obj.pickIndex());
		System.out.println(rand.nextInt(2) + " " + rand.nextDouble() + " -- " + Math.random());

	}

}
