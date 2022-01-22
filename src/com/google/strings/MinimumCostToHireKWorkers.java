package com.google.strings;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MinimumCostToHireKWorkers {

	public static void main(String[] args) {
//		int[] quality = { 10, 20, 5 };
//		int[] wage = { 70, 50, 30 };
//		int k = 2;
//		
		int[] quality = {3,1,10,10,1};
		int[] wage = {4,8,2,2,7};
		int k =	3;
		
//		int[] quality = {4,5};
//		int[] wage = {8,14};
//		int k =	2;
		System.out.println(minCost(quality, wage, k));
	}

	public static double minCost(int[] q, int[] w, int k) {
		int N = q.length;
		Worker[] workers = new Worker[N];
		for (int i = 0; i < N; i++) {
			workers[i] = new Worker(q[i], w[i]);
		}
		Arrays.sort(workers);

		double min = Double.MAX_VALUE;
		PriorityQueue<Integer> pq = new PriorityQueue();
		Integer sum = 0;
		for (Worker worker : workers) {
			pq.offer(-worker.quality);
			sum += worker.quality;

			if (pq.size() > k) {
				sum += pq.poll();
			}
			if (pq.size() == k)
				min = Math.min(min, sum * worker.ratio());
		}
		return min;
	}// mincost

}// class

class Worker implements Comparable<Worker> {
	public int quality;
	public int wage;

	public Worker(int q, int w) {
		this.quality = q;
		this.wage = w;
	}

	public double ratio() {
		return (double) wage / quality;
	}

	public int compareTo(Worker other) {
		return Double.compare(ratio(), other.ratio());
	}

}
