package com.sg.mower.services;

import java.util.List;

import com.sg.mower.modals.Coordinate;
import com.sg.mower.modals.Lawn;
import com.sg.mower.modals.Position;

import exceptions.MowerException;

public class MowerServices {

	private static final String N = "N";
	private static final String E = "E";
	private static final String S = "S";
	private static final String W = "W";
	private static final String G = "G";
	private static final String D = "D";
	private static final String A = "A";

	// Cette fonction permet de pivoter la tondeuse à gauche
	public static String rotateLeft(String orientation) throws MowerException {
		switch (orientation) {
		case N:
			orientation = W;
			break;
		case E:
			orientation = N;
			break;
		case S:
			orientation = E;
			break;
		case W:
			orientation = S;
			break;
		default:
			throw new MowerException("Orientation Invalide :" + orientation);
		}
		return orientation;
	}

	// Cette fonction permet de pivoter la tondeuse à droite
	public static String rotateRight(String orientation) throws MowerException {
		switch (orientation) {
		case N:
			orientation = E;
			break;
		case E:
			orientation = S;
			break;
		case S:
			orientation = W;
			break;
		case W:
			orientation = N;
			break;
		default:
			throw new MowerException("Orientation Invalide :" + orientation);
		}
		return orientation;
	}

	// Cette fonction permet d'avancer la tondeuse
	public static Coordinate moveMower(Position position, Lawn lawn) throws MowerException {
		int x = 0;
		int y = 0;

		switch (position.getOrientation()) {
		case N:
			x = position.getCoordinate().getX();
			y = position.getCoordinate().getY() + 1;
			break;
		case E:
			x = position.getCoordinate().getX() + 1;
			y = position.getCoordinate().getY();
			break;
		case S:
			x = position.getCoordinate().getX();
			y = position.getCoordinate().getY() - 1;
			break;
		case W:
			x = position.getCoordinate().getX() - 1;
			y = position.getCoordinate().getY();
			break;
		default:
			throw new MowerException("Position invalide :" + position);
		}

		if (x >= 0 && y >= 0 && x <= lawn.getMaxCoordinate().getX() && y <= lawn.getMaxCoordinate().getY())
			return new Coordinate(x, y);
		
		return position.getCoordinate();
	}

	// Cette fonction permet de traiter une instruction
	public static void runInstruction(String instruction, Position position, Lawn lawn) throws MowerException {

		switch (instruction) {
		case G:
			position.setOrientation(rotateLeft(position.getOrientation()));
			break;
		case D:
			position.setOrientation(rotateRight(position.getOrientation()));
			break;
		case A:
			position.setCoordinate(moveMower(position, lawn));
			break;
		default:
			throw new MowerException("Instruction invalide :" + instruction);
		}
	}

	// Cette fonction permet de traiter une série d'instructions
	public static void runInstructions(List<String> instructions, Position position, Lawn lawn) throws MowerException {
		for (String instruction : instructions) {
			runInstruction(instruction, position, lawn);
		}
	}

	// Cette fonction permet d'extraire la position max de pelouse
	public static Lawn preparerLawn(String s) {
		String[] lawnString = s.split(" ");
		return new Lawn(new Coordinate(Integer.valueOf(lawnString[0]), Integer.valueOf(lawnString[1])));
	}

	// Cette fonction permet d'extraire la position initiale de tondeuse
	public static Position preparePosition(String s) {
		String[] positionString = s.split(" ");
		return new Position(new Coordinate(Integer.valueOf(positionString[0]), Integer.valueOf(positionString[1])),
				positionString[2]);
	}

}
