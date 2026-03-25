package com.tmb.utilities;

import java.util.Base64;

public final class DecodeUtils {

	private DecodeUtils() {
	};

	public static String getEncode(String password) {

		return Base64.getEncoder().encodeToString(password.getBytes());

	}

	public static String getDecode(String password) {

		return new String(Base64.getDecoder().decode(password.getBytes()));

	}
}
