package com.google.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class MeetingRomsII {

	public MeetingRomsII() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// PriorityQueue<Integer> pq = new
		// PriorityQueue<Integer>(Collections.reverseOrder());
//		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
//		pq.add(10);
//		pq.add(30);
//		pq.add(20);
//		pq.add(400);
//		print(pq);
//		System.out.println("min " + pq.poll());
//		System.out.println("min " + pq.poll());
//		System.out.println("min " + pq.poll());
//		System.out.println("min " + pq.poll());

		int[][] intervals = { { 0, 30 }, { 5, 10 }, { 15, 20 }};
		System.out.println("meetingRooms2 - " + meetingRoomsII(intervals));
		System.out.println("meetingRooms - " + meetingRooms(intervals));
	}

	private static int meetingRoomsII(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		Integer[] start = new Integer[intervals.length];
		Integer[] end = new Integer[intervals.length];

		for(int i=0;i<intervals.length;i++) {
			start[i] = intervals[i][0];
			end[i] = intervals[i][1];
		}
		Arrays.sort(start, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});
		Arrays.sort(end, new Comparator<Integer>() {
			@Override
			public int compare(Integer a, Integer b) {
				return a - b;
			}
		});

		int rooms = 0;
		int r = 0;
		for (int i = 0; i < intervals.length; i++) {
			if (start[i] >= end[r]) {
				rooms--;
				r++;
			}
			rooms++;
		}
		return rooms;
	}

	private static int meetingRooms(int[][] intervals) {
		if (intervals.length == 0)
			return 0;
		Arrays.sort(intervals, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[0] - b[0];
			}
		});
		PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
		for (int[] interval : intervals) {
			int start = interval[0];
			int end = interval[1];
			if (pq.size() > 0 && pq.peek() <= start)
				pq.poll();
			pq.add(end);
		}
		return pq.size();
	}

	private static void print(PriorityQueue<Integer> q) {
		Iterator<Integer> iterator = q.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " ");
		}
		System.out.println();
	}

}
