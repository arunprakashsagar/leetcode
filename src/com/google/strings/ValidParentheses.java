package com.google.strings;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class ValidParentheses {

	public ValidParentheses() {
		// TODO Auto-generated constructor stub
	}

	static Map<Character, Character> cache = new HashMap(3);
	static {
		cache.put(')', '(');
		cache.put(']', '[');
		cache.put('}', '{');

	}

	public static void main(String[] args) {
		System.out.println(isValid("(((){}))[]"));
		System.out.println(isValid("(((){})"));
		System.out.println(isValid("(}[]"));
	}

	private static boolean isValid(String s) {
		if (s == null)
			return false;
		Stack<Character> stack = new Stack();
		for (char c : s.toCharArray()) {
			Character match = cache.get(c);
			if (match == null)
				stack.push(c);
			else if (stack.size() == 0 || stack.pop() != match)
				return false;
		}

		return stack.size() == 0;
	}

}
