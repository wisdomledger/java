package com.wisdomledger.dp.strategy;

public class Dog implements Comparable {
	private int food;

	public Dog(int food) {
		super();
		this.food = food;
	}

	public int compareTo(Object o) {
		if (o instanceof Dog) {
			Dog d = (Dog) o;
			if (this.food > d.food)
				return 1;
			else if (this.food < d.food)
				return -1;
			else
				return 0;
		}
		return -100;
	}

	@Override
	public String toString() {
		return "Dog [food=" + food + "]";
	}
}
