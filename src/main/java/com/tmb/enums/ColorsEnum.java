package com.tmb.enums;

public enum ColorsEnum {

	RED("#8B0000"), GREEN("#008000"), BLUE("#0000FF"), GOLDENYELLOW("#9B870C");

	private final String hexCode;

	ColorsEnum(String hexCode) {
		this.hexCode = hexCode;
	}

	public String getHexCode() {
		return hexCode;
	}

}
