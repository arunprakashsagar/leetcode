package com.google.strings;

public class ContainerWithMostWater {

	public ContainerWithMostWater() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] height = {1,8,6,2,5,4,8,3,7};
		System.out.print(maxArea(height));
	}

	private static int maxArea(int[] height) {
		int l=0, r=height.length-1;
		int ans = 0;
		while(l < r) {
			int min = Math.min(height[l], height[r]);
			ans = Math.max(ans, min*(r-l));
			if(height[l] <= height[r]) l++;
			else r--;
		}
		return ans;
	}

}
