package com.math;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class WordLadder2Sides {

	public WordLadder2Sides() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		String beginWord = "hit", endWord = "cog";
		String[] wordList = { "hot", "dot", "dog", "lot", "log", "cog" };
		List<String> list = Arrays.asList(wordList);
		int l = ladderBFS2Sides(beginWord, endWord, new HashSet<String>(list));
		System.out.println("\nl == " + l);
	}

	public static int ladderBFS2Sides(String beginWord, String endWord, HashSet<String> dictionary) {
		if (!dictionary.contains(endWord))
			return 0;

		Queue<String> forwardQ = new LinkedList<>();
		Queue<String> backwardQ = new LinkedList<>();
		forwardQ.add(beginWord);
		backwardQ.add(endWord);
		HashSet<String> forwardVisited = new HashSet<>();
		HashSet<String> backwardVisited = new HashSet<>();
		forwardVisited.add(beginWord);
		backwardVisited.add(endWord);
		int l1 = 0, l2 = 0;
		while (!forwardQ.isEmpty() && !backwardQ.isEmpty()) {
			if (backwardQ.size() < forwardQ.size()) {
				l2++;
				if (visitNodesInPath(backwardQ, backwardVisited, forwardVisited, dictionary))
					return l1 + l2;
			} else {
				l1++;
				if (visitNodesInPath(forwardQ, forwardVisited, backwardVisited, dictionary))
					return l1 + l2;
			}
		}

		return 0;

	}

	private static boolean visitNodesInPath(Queue<String> currQ, HashSet<String> visited, HashSet<String> otherVisited,
			HashSet<String> dictionary) {
		int size = currQ.size();
		for (int i = 0; i < size; i++) {
			String currWord = currQ.poll();

			if (otherVisited.contains(currWord))
				return true;
			
			for (String neighbour : neighbours(currWord)) {
				if (dictionary.contains(neighbour) && !visited.contains(neighbour)) {
					currQ.add(neighbour);
					visited.add(neighbour);
				}
			}
		}
		return false;
	}

	private static List<String> neighbours(String currWord) {
		List<String> neighbours = new ArrayList<String>();
		char[] arr = currWord.toCharArray();
		for (int i = 0; i < arr.length; i++) {
			char actual = arr[i];
			for (char c = 'a'; c <= 'z'; c++) {
				arr[i] = c;
				neighbours.add(new String(arr));
			}
			arr[i] = actual;
		}
		return neighbours;
	}

}
