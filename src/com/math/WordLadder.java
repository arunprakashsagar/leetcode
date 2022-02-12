package com.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder {

	public WordLadder() {
		// TODO Auto-generated constructor stub
	}

	static int min = Integer.MAX_VALUE;

	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> list = Arrays.asList(wordList);
		int l = ladderBFS(beginWord, endWord, new HashSet<String>(list));
		// int l = ladderDFS(beginWord, endWord, Arrays.asList(wordList));
		System.out.println("\nl == " + l);
	}

	private static int ladderBFS(String startWord, String endWord, HashSet<String> wordDictionary) {
		Queue<String> candidateWordsInQ = new LinkedList<>();
		candidateWordsInQ.add(startWord);
		wordDictionary.remove(startWord);
		int wordLadderHeight = 0;
		while (!candidateWordsInQ.isEmpty()) {
			int size = candidateWordsInQ.size();
			wordLadderHeight++;
			for (int i = 0; i < size; i++) {
				String currentWord = candidateWordsInQ.poll();
				if (currentWord.equals(endWord))
					return wordLadderHeight;
				List<String> neighbours = neighbours(currentWord);
				for (String neighbour : neighbours) {
					if (wordDictionary.contains(neighbour)) {
						wordDictionary.remove(neighbour);
						candidateWordsInQ.add(neighbour);
					}
				}
			}
		}
		return 0;
	}

	private static List<String> neighbours(String word) {
		int l = word.length();
		List<String> words = new ArrayList<>();
		System.out.println("\nNeighbours for word : " + word);
		for (int i = 0; i < l; i++) {
			for (int j = 0; j < 26; j++) {
				char c = (char) ('a' + j);
				String newWord = word.substring(0, i) + c + word.substring(i + 1, l);
				System.out.print(newWord + " ");
				words.add(newWord);
			}
		}
		return words;
	}

	public static int ladderDFS(String beginWord, String endWord, List<String> wordList) {

		HashSet<String> seen = new HashSet<>();
		ladder(beginWord, endWord, wordList, seen);
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	private static boolean ladder(String s, String e, List<String> l, HashSet<String> seen) {
		System.out.println("s == " + s + " - e == " + e);
		if (s.equals(e)) {
			min = Math.min(min, seen.size() + 1);
			return true;
		}
		seen.add(s);

		for (String str : l) {
			// System.out.println("s == " + s + " - e == " + e + " Iterating - " + str);
			if (seen.contains(str))
				continue;
			if (distance(s, str) != 1)
				continue;
			if (ladder(str, e, l, seen))
				break;
		}
		System.out.println("s == " + s + " - e == " + e + " Removing - " + s);
		seen.remove(s);
		return false;
	}

	private static int distance(String s1, String s2) {
		if (s1 == null || s2 == null)
			return 0;
		int n1 = s1.length(), n2 = s2.length();
		if (n1 != n2)
			return 0;
		int d = 0;
		for (int i = 0; i < n1; i++) {
			if (s1.charAt(i) != s2.charAt(i))
				d++;
			if (d > 1)
				break;
		}
		return d;
	}

}
