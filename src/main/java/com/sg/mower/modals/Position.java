package com.sg.mower.modals;

public class Position {

	private Coordinate coordinate;
	private String orientation;

	public Position(Coordinate coordinate, String orientation) {
		super();
		this.coordinate = coordinate;
		this.orientation = orientation;
	}

	public Coordinate getCoordinate() {
		return coordinate;
	}

	public void setCoordinate(Coordinate coordinate) {
		this.coordinate = coordinate;
	}

	public String getOrientation() {
		return orientation;
	}

	public void setOrientation(String orientation) {
		this.orientation = orientation;
	}

	@Override
	public String toString() {
		return "Position [coordinate=" + coordinate + ", orientation=" + orientation + "]";
	}
	
	

}
