package me.yurinero.RandomExploration;


import java.security.SecureRandom;
import java.time.Clock;
import java.time.LocalDateTime;

public class RandomExploration {
	public static void main(String[] args) {
        BasicRandom basicRandom = new BasicRandom();
		UserTime userTime = new UserTime();
		SafeRandom safeRandom = new SafeRandom();

         System.out.println(safeRandom.getSafeRandomLong());
		 System.out.println(safeRandom.getRandomSeed());


		}
	}
