package com.tmb.enums;

public enum MarkSideEnum {

	RIGHT, LEFT,TOP,BOTTOM;

	public String getSide() {
		return this.name().toLowerCase();
	}

}
