package me.yurinero.RandomExploration.logic;


import java.util.Random;

/* Here we explore a little bit of the basic Random function of Java.
*  While usable in a pinch, it is not considered Cryptographically secure, as it seemingly uses an algorithm that can be reverse engineered.
* If my reading is correct, it takes the users system time as a seed, as such if someone:
* - Understands the algorithm behind it
* - Knows the time of creation
* They could reverse-engineer it if for example we use it to generate a password, a key or similar.
* */

public class BasicRandom {
	private final int min = 0, max = 100;

	Random DefaultRandom = new Random();

	// The most basic Random function, creating a random Integer in the signed 32bit range
	public int getUnboundedRandom() {
		return DefaultRandom.nextInt();
	}
	// We can also only generate it within a certain range. With some more mucking about we could have the user input it.
	public int getBoundedRandom() {
		return DefaultRandom.nextInt(min, max);
	}
	// This will almost always overflow, but it's kinda funny
	public int multipliedRandom() {
		return DefaultRandom.nextInt() * DefaultRandom.nextInt();
	}


}
