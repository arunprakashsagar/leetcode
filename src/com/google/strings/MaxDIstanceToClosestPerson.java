package com.google.strings;

public class MaxDIstanceToClosestPerson {

	public MaxDIstanceToClosestPerson() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] a = {1,0,0,0,1,0,1};
		System.out.println(maxDistance(a));
		int[] b={1,0,0,0};
		System.out.println(maxDistance(b));
		int[] c={1,1};
		System.out.println(maxDistance(c));
	}

	public static int maxDistance(int[] seats) {
		int N = seats.length;
		int ans = 0;
		int prev = -1, i = 0, count = 0;

		while (i < N) {
			while (i < N && seats[i] == 0) {
				count++;
				i++;
			}
			if (prev == -1 || i == N) {
				ans = Math.max(ans, count);
			} else {
				ans = Math.max(ans, (count + 1) / 2);
			}
			prev=i;
			count=0;
			i++;
		}
		return ans;
	}

}
