package com.math;

import java.util.HashMap;
import java.util.Map;

public class ReconstructOriginalDigitsFromEnglish {

	public ReconstructOriginalDigitsFromEnglish() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String input = "owoztneoer";
		System.out.println(originalDigits(input));

	}

	public static String originalDigits(String s) {
		String[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		int[] chars = new int[26];
		for (char c : s.toCharArray()) {
			chars[c - 'a']++;
		}
		int[] ans = new int[10];
		ans[0] = chars['z' - 'a'];
		ans[2] = chars['w' - 'a'];
		ans[4] = chars['u' - 'a'];
		ans[6] = chars['x' - 'a'];
		ans[8] = chars['g' - 'a'];
		ans[3] = chars['h' - 'a'] - ans[8];
		ans[5] = chars['f' - 'a'] - ans[4];
		ans[7] = chars['s' - 'a'] - ans[6];
		ans[9] = chars['i' - 'a'] - ans[6] - ans[5] - ans[8];
		ans[1] = chars['n' - 'a'] - ans[7] - 2 * ans[9];
		String res = "";
		for (int i = 0; i < 10; i++) {
			for (int d = 1; d <= ans[i]; d++) {
				res += i;
			}
		}
		return res;
	}

	public String originalDigits1(String s) {
		String[] digits = { "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine" };

		Map<Character, Integer> chars = new HashMap<Character, Integer>();
		for (char c : s.toCharArray()) {
			chars.put(c, chars.getOrDefault(c, 0) + 1);
		}
		int[] ans = new int[10];
		// int currLen = 0;
		while (!chars.isEmpty()) {
			for (int i = 0; i < 10; i++) {
				String digit = digits[i];
				if (isDigitExists(chars, digit) > 0) {
					ans[i]++;
				}
			}
		}
		String res = "";
		for (int i = 0; i < 10; i++) {
			for (int d = 1; d <= ans[i]; d++) {
				res += i;
			}
		}
		return res;
	}

	private int isDigitExists(Map<Character, Integer> chars, String digit) {
		if (chars.size() == 0)
			return 0;
		char[] arr = digit.toCharArray();
		// int count = Integer.MAX_VALUE;
		for (char c : arr) {
			Integer value = chars.get(c);
			if (value == null || value == 0)
				return 0;
			// count = Math.min(count, value);
		}
		for (char c : arr) {
			Integer value = chars.get(c);
			if (value > 1)
				chars.put(c, value - 1);
			else
				chars.remove(c);
		}
		return 1;
	}

}
