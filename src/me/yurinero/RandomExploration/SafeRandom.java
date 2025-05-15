package me.yurinero.RandomExploration;

import java.security.SecureRandom;
import java.util.Random;

public class SafeRandom {
	int upperBound = Integer.MAX_VALUE;
	int lowerBound = 0;

	SecureRandom safeRandom;

	public int getRandomSeed() {
	    Random seed = new Random();
		return seed.nextInt(lowerBound, upperBound);
	}

	public SafeRandom() {
		this.safeRandom = new SecureRandom();
	}

	int getSafeRandomLong() {
		return Math.toIntExact(safeRandom.nextLong(getRandomSeed()));
	}
}