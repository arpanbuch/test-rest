package com.commons;

import java.util.Random;

public class util {

	public static int getRandomId() {

		Random rand = new Random();
		int randomId = rand.nextInt(50);

		return randomId;

	}

}
