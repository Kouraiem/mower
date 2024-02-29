package com.sg.mower.modals;

public class Lawn {

	private Coordinate maxCoordinate;

	public Lawn(Coordinate maxCoordinate) {
		super();
		this.maxCoordinate = maxCoordinate;
	}

	public Coordinate getMaxCoordinate() {
		return maxCoordinate;
	}

	public void setMaxCoordinate(Coordinate maxCoordinate) {
		this.maxCoordinate = maxCoordinate;
	}

}
