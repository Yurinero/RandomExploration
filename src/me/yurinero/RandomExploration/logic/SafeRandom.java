package me.yurinero.RandomExploration.logic;

import java.security.SecureRandom;
/* Here we take a look at the SecureRandom function within Java.
* Unlike it's previous counterpart, it is considered Cryptographically secure and based on my readings can be used in such applications.
* This is due to having built in "entropy", a quite fascinating concept if you want to do a deep dive.
* We could further expand this function, such as setting a specific algorithm, checking for entropy and preventing its use if it's detected to be low.
*/

public class SafeRandom {
	private final SecureRandom safeRandom;

	public SafeRandom() {
		try {
			this.safeRandom = SecureRandom.getInstanceStrong();
		} catch (Exception e) {
			throw new SecurityException("Failed to initialize SecureRandom", e);
		}
	}

	public long getSafeRandomLong() {
		return safeRandom.nextLong();
	}
}
