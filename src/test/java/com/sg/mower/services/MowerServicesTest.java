package com.sg.mower.services;


import org.junit.jupiter.api.Test;

import com.sg.mower.modals.Coordinate;
import com.sg.mower.modals.Lawn;
import com.sg.mower.modals.Position;

import exceptions.MowerException;

import static org.junit.jupiter.api.Assertions.*;

public class MowerServicesTest {
	
	private static final String N = "N";
	private static final String E = "E";
	private static final String S = "S";
	private static final String W = "W";


	@Test
	public void rotateLeftTest_With_Orientation_N() throws MowerException {
		String result = MowerServices.rotateLeft(N);
		assertEquals(W, result);
	}
	
	@Test
	public void rotateLeftTest_With_Orientation_E() throws MowerException {
		String result = MowerServices.rotateLeft(E);
		assertEquals(N, result);
	}
	
	@Test
	public void rotateLeftTest_With_Orientation_S() throws MowerException {
		String result = MowerServices.rotateLeft(S);
		assertEquals(E, result);
	}
	
	@Test
	public void rotateLeftTest_With_Orientation_W() throws MowerException {
		String result = MowerServices.rotateLeft(W);
		assertEquals(S, result);
	}
	
	@Test
	public void rotateRightTest_With_Orientation_N() throws MowerException {
		String result = MowerServices.rotateRight(N);
		assertEquals(E, result);
	}
	
	@Test
	public void rotateRightTest_With_Orientation_E() throws MowerException {
		String result = MowerServices.rotateRight(E);
		assertEquals(S, result);
	}
	
	@Test
	public void rotateRightTest_With_Orientation_S() throws MowerException {
		String result = MowerServices.rotateRight(S);
		assertEquals(W, result);
	}
	
	@Test
	public void rotateRightTest_With_Orientation_W() throws MowerException {
		String result = MowerServices.rotateRight(W);
		assertEquals(N, result);
	}
	
	@Test
	public void moveMowerTest_With_Orientation_N() throws MowerException{
		Position position = new Position(new Coordinate(1,1), N);
		Lawn lawn = new Lawn(new Coordinate(5,5));
		Coordinate result = MowerServices.moveMower(position, lawn);
		assertEquals(1, result.getX());
		assertEquals(2, result.getY());
	}
	
	@Test
	public void moveMowerTest_With_Orientation_E() throws MowerException{
		Position position = new Position(new Coordinate(1,1), E);
		Lawn lawn = new Lawn(new Coordinate(5,5));
		Coordinate result = MowerServices.moveMower(position, lawn);
		assertEquals(2, result.getX());
		assertEquals(1, result.getY());
	}
	
	@Test
	public void moveMowerTest_With_Orientation_S() throws MowerException{
		Position position = new Position(new Coordinate(1,1), S);
		Lawn lawn = new Lawn(new Coordinate(5,5));
		Coordinate result = MowerServices.moveMower(position, lawn);
		assertEquals(1, result.getX());
		assertEquals(0, result.getY());
	}
	
	@Test
	public void moveMowerTest_With_Orientation_W() throws MowerException{
		Position position = new Position(new Coordinate(1,1), W);
		Lawn lawn = new Lawn(new Coordinate(5,5));
		Coordinate result = MowerServices.moveMower(position, lawn);
		assertEquals(0, result.getX());
		assertEquals(1, result.getY());
	}
	
	@Test
	public void moveMowerTest_With_Orientation_N_And_Position_In_MaxPosition() throws MowerException{
		Position position = new Position(new Coordinate(5,5), N);
		Lawn lawn = new Lawn(new Coordinate(5,5));
		Coordinate result = MowerServices.moveMower(position, lawn);
		assertEquals(5, result.getX());
		assertEquals(5, result.getY());
	}
	
	@Test
	public void moveMowerTest_With_Orientation_S_And_Position_In_Origine() throws MowerException{
		Position position = new Position(new Coordinate(0,0), S);
		Lawn lawn = new Lawn(new Coordinate(5,5));
		Coordinate result = MowerServices.moveMower(position, lawn);
		assertEquals(0, result.getX());
		assertEquals(0, result.getY());
	}
}
