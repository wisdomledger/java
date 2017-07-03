package com.wisdomledger.dp.strategy;

public class Cat implements Comparable {

	private int height;
	private int weight;
	//private Comparator comparator = new CatHeightComparator();
	private Comparator comparator = new CatWeightComparator();
	
	public Comparator getComparator() {
		return comparator;
	}

	public void setComparator(Comparator comparator) {
		this.comparator = comparator;
	}

	public Cat(int height, int weight) {
		super();
		this.height = height;
		this.weight = weight;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	@Override
	public String toString() {
		return "Cat [height=" + height + ", weight=" + weight + "]";
	}

	@Override
	public int compareTo(Object o) {
		return comparator.compare(this, o);
	}

}
