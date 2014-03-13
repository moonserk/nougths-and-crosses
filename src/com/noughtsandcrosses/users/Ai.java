package com.noughtsandcrosses.users;

import com.noughtsandcrosses.game.Field;

import java.util.Random;


public class Ai extends Users {
	
	private Field field = new Field();
	
	private char[][] controlField = new char[field.getFieldSize()][field.getFieldSize()];
	
	public Ai(char sign){
		super("Albert", sign);
	}


	//Artifical Intelligence =)
	
	@Override
	public int returnMoveCoordinates(){

        Random random = new Random();
        return  random.nextInt(3);
	}
	
}
