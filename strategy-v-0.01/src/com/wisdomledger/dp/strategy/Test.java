package com.wisdomledger.dp.strategy;

public class Test {
	
	public static void main(String[] args) {
		int[] a = {9,5,3,7,1};
		DataSorter.sort(a);
		DataSorter.p(a);
		
		Cat[] cats = {new Cat(5,5),new Cat(3,3),new Cat(1,1)};
		DataSorter.sort(cats);
		DataSorter.p(cats);
	}
}
