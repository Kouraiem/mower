package com.sg.mower;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

import com.sg.mower.modals.Lawn;
import com.sg.mower.modals.Position;
import com.sg.mower.services.MowerServices;

import exceptions.MowerException;

public class Main 
{
    public static void main( String[] args )
    {
    	BufferedReader reader;
    	StringBuilder result = new StringBuilder();
		try {
			reader = new BufferedReader(new FileReader("src/main/resources/test.txt"));
			// La ligne correspond aux coordonnées du coin supérieur
			String line = reader.readLine();
			System.out.println("La ligne correspond aux coordonnées du coin supérieur : "+line);
			Lawn lawn = MowerServices.preparerLawn(line);

			while (line != null) {
		
				// La ligne correspond à la position initiale de la tondeuse, ainsi que son orientation.
				line = reader.readLine();
				if(line == null)
					break;
				System.out.println("La ligne correspond à la position initiale de la tondeuse, ainsi que son orientation : "+line);
				Position position = MowerServices.preparePosition(line);
				// La ligne correspond une série d'instructions ordonnant à la tondeuse d'explorer la pelouse.
				line = reader.readLine();
				if(line == null)
					break;
				System.out.println("La ligne correspond une série d'instructions ordonnant à la tondeuse d'explorer la pelouse :"+line);
				
				MowerServices.runInstructions(Arrays.asList(line.split("")), position, lawn);
				result.append(" "+position.getCoordinate().getX()+" "+position.getCoordinate().getY()+" "+position.getOrientation());
			}
			
			System.out.println("Le résultat est : "+ result);

			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} catch(MowerException e) {
			e.printStackTrace();
		}

    }

}
