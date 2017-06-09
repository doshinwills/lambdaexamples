package com.doshin.lambda.interfaces.partfour;

import java.util.Arrays;

interface RegularPolygon {
	int getNumSides();

	int getSideLength();

	static int totalSides(RegularPolygon[] pArr) {
		int sum = 0;
		for (RegularPolygon p : pArr) {
			sum += p.getSideLength();
		}
		return sum;
	}

	default int getPerimeter() {
		return getNumSides() * getSideLength();
	}

	default double getInteriorAngle() {
		return (getNumSides() - 2) * 3.14 / getSideLength();
	}
}

class EquilateralTriangle implements RegularPolygon {

	int len;

	public EquilateralTriangle(int len) {
		this.len = len;
	}

	@Override
	public int getNumSides() {
		return 3;
	}

	@Override
	public int getSideLength() {
		return len;
	}

}

public class Square implements RegularPolygon {
	int len;

	public Square(int len) {
		this.len = len;
	}

	@Override
	public int getNumSides() {
		return 3;
	}

	@Override
	public int getSideLength() {
		return len;
	}
}