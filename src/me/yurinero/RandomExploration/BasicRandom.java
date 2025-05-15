package me.yurinero.RandomExploration;


import java.util.Random;

public class BasicRandom {
	private int min = 0, max = 100;

	Random DefaultRandom = new Random();

	int getUnboundedRandom() {
		return DefaultRandom.nextInt();
	}
	int getBoundedRandom() {
		return DefaultRandom.nextInt(min, max);
	}
	// Can this overflow?
	int multipliedRandom() {
		return DefaultRandom.nextInt() * DefaultRandom.nextInt();
	}

}
