package com.eBanking.utilities;

import org.apache.commons.lang3.RandomStringUtils;

public class RandomCharUtils {

	public String RandomString() {
		String generatedString = RandomStringUtils.randomAlphabetic(10);
		return (generatedString);
	}
}