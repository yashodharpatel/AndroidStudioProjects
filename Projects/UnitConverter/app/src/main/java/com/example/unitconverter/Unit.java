package com.example.unitconverter;

public class Unit {
	private final int unitLogo;
	private final String unitName;

	public Unit(int unitLogo, String unitName) {
		this.unitLogo = unitLogo;
		this.unitName = unitName;
	}

	public  int getUnitLogo() {
		return unitLogo;
	}

	public String getUnitName() {
		return unitName;
	}
}