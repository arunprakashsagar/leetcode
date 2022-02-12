package com.google.strings;

public class TrappingRainWater {

	public TrappingRainWater() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(maxWater(height));
		System.out.println(maxWaterII(height));

	}
	private static int maxWaterII(int[] height) {
		
		int n = height.length;
		int ans = 0;
		int l=0, r=n-1;
		int lmax = 0, rmax = 0;
		while(l<=r) {
			if(lmax < rmax) {
				if(height[l] > lmax)
					lmax = height[l];
				else ans += lmax-height[l];
				l++;
			}else {
				if(height[r] > rmax)
					rmax = height[r];
				else ans += rmax-height[r];
				r--;
			}
		}
		return ans;
	}
	
	//O(N) space complexity
	private static int maxWater(int[] height) {
		
		int N = height.length;
		int[] max = new int[N];
		for(int i=N-2; i>=0;i--)
			max[i] = Math.max(max[i+1], height[i+1]);
		
		int sum = 0, lmax = height[0];
		for(int i= 1; i<N-1;i++) {
			int min = Math.min(lmax, max[i]);
			if(min-height[i] > 0)
				sum += min-height[i];
			else
				lmax = height[i];
		}
		return sum;
	}

}
