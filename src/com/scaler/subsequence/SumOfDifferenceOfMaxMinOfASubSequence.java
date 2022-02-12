package com.scaler.subsequence;

import java.util.ArrayList;
import java.util.Collections;

public class SumOfDifferenceOfMaxMinOfASubSequence {

	int sum = 0;
	int mod = 1000 * 1000 * 1000 + 7;

	public SumOfDifferenceOfMaxMinOfASubSequence() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {

	}
	
	private int sumOfDiff(ArrayList<Integer> A) {
		int N = A.size();
		Collections.sort(A);
		long[] power = new long[N];
		power[0] = 1;
		for(int i=1;i<N;i++)
			power[i] = (power[i-1]*2)%mod;
		
		long max = 0, min =0;
		for(int i=0;i<N;i++) {
			max += A.get(i)*power[i-1];
		}
		for(int i=0;i<N;i++) {
			min += A.get(i)*power[N-1-i];
		}
		return (int) (max-min)%mod;
		
	}

	//O(N^2) solution
	private int sumOfMaxMinDiff(ArrayList<Integer> A) {

		int N = A.size();
		Collections.sort(A);
		int[] power = new int[N];
		power[0] = 1;
		for (int i = 1; i < N; i++)
			power[i] = (power[i - 1] * 2) % mod;
		for (int i = 0; i < N - 1; i++) {
			int a = A.get(i);
			for (int j = i + 1; j < N; j++) {
				int b = A.get(j);
				// int pow = (int)Math.pow(2, j-i-1);
				long diff = (b - a) % mod;
				diff = ((b - a) * power[j - i - 1]) % mod;
				sum = (int) (sum + diff) % mod;
			}
		}
		return sum;
	}

	// Bruteforce solution
	private void subsequencesSum(ArrayList<Integer> A, int start, ArrayList<Integer> list) {
		for (int i = start; i < A.size(); i++) {
			list.add(A.get(i));
			calculateDiffSum(list);
			subsequencesSum(A, i + 1, list);
			list.remove(list.size() - 1);
		}
	}

	private void calculateDiffSum(ArrayList<Integer> A) {
		if (A.size() < 2)
			return;
		int min = Integer.MAX_VALUE;
		int max = Integer.MIN_VALUE;
		for (Integer num : A) {
			if (num > max)
				max = num;
			if (num < min)
				min = num;
		}
		sum = (sum + (max - min) % mod) % mod;
	}
}
