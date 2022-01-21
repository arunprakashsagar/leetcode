package com.google.strings;

public class CanJumpToLastStep {

	public CanJumpToLastStep() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[] height = { 1, 8, 6, 2, 5, 4, 8, 3, 7 };
		System.out.print(canJump(height));

	}

	// bottom-up
	private static boolean canJump(int[] arr) {
		int remaining_steps = 0;
		int N = arr.length;
		for (int i = 1; i < N; i++) {
			remaining_steps = Math.max(remaining_steps, arr[i - 1]);
			remaining_steps--;// step down
			if (remaining_steps < 0)
				return false;
		}
		return remaining_steps >= 0;
	}

	// top-down
	private static boolean canJumpTD(int[] arr) {
		int last_indx = arr.length - 1;

		for (int i = arr.length - 2; i >= 0; i--) {
			if (i + arr[i] >= last_indx)
				last_indx = i;
		}
		return last_indx == 0;
	}

}
