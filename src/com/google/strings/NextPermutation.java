package com.google.strings;

public class NextPermutation {

	public NextPermutation() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] mat = { { 1, 2, 3 }, { 3, 2, 1 }, { 1, 1, 5 }, { 5, 1, 1 },};
		for(int[] nums : mat) {
			nextPermutation(nums);
			print(nums);
		}
	}

	
	public static void nextPermutation(int[] nums) {
		int N = nums.length;
		int i = N-2;
		while(i>=0 && nums[i+1] <= nums[i]) {
			i--;
		}
		if(i >= 0) {
			int j=N-1;
			while(nums[j] <= nums[i])
				j--;
			swap(nums, i, j);
		}
		reverse(nums, i+1);
	}

	private static void reverse(int[] nums, int l) {
		int r = nums.length -1;
		while(l<r) {
			swap(nums, l, r);
			l++;r--;
		}		
	}

	private static void swap(int[] nums, int i, int j) {
		int temp = nums[i];
		nums[i] = nums[j];
		nums[j] = temp;
		
	}

	private static void print(int[] nums) {
		for(int num : nums)
			System.out.print(num + " ");
		System.out.println();
		
	}

}
