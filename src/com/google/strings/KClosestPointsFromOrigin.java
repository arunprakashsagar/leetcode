package com.google.strings;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class KClosestPointsFromOrigin {

	public KClosestPointsFromOrigin() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		int[][] points = { { 3, 3 }, { 5, -1 }, { -2, 4 } };
		int k = 2;
		Util.printArr(kClosestPoints(points, k));
		Util.printArr(kClosestPointsWithCustomComparator(points, k));
	}
	
	private static int[][] kClosestPointsWithMinHeap(int[][] points, int k) {

		int N = points.length;
		PriorityQueue<Point> heap = new PriorityQueue();
		for(int[] point : points) {
			Point p = new Point(point[0], point[1]);
			heap.offer(p);
		}
		int[][] ans = new int[k][2];
		for (int i = 0; i < k; i++) {
			Point p = heap.poll();
			ans[i][0] = p.x;
			ans[i][1] = p.y;
		}
		return ans;
	}
	

	private static int[][] kClosestPointsWithCustomComparator(int[][] points, int k) {

		int N = points.length;
		Arrays.sort(points, new Comparator<int[]>() {
			public int compare(int[] a, int[] b) {
				return Double.compare(Math.sqrt(a[0] * a[0] + a[1] * a[1]), Math.sqrt(b[0] * b[0] + b[1] * b[1]));
			}
		});
		int[][] ans = new int[k][2];
		for (int i = 0; i < k; i++) {
			ans[i][0] = points[i][0];
			ans[i][1] = points[i][1];
		}
		return ans;
	}

	private static int[][] kClosestPoints(int[][] points, int k) {

		int N = points.length;
		Point[] pointsArr = new Point[N];
		for (int i = 0; i < N; i++) {
			pointsArr[i] = new Point(points[i][0], points[i][1]);
		}
		Arrays.sort(pointsArr);
		int[][] ans = new int[k][2];
		for (int i = 0; i < k; i++) {
			ans[i][0] = pointsArr[i].x;
			ans[i][1] = pointsArr[i].y;
		}
		return ans;
	}

}

class Point implements Comparable<Point> {
	public int x;
	public int y;
	public double d;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
		this.d = Math.sqrt(x * x + y * y);
	}

	public double distance() {
		return d;
	}

	public int compareTo(Point other) {
		return Double.compare(this.d, other.d);
	}
}
