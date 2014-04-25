package com.noughtsandcrosses.users;


import java.util.Random;

import com.noughtsandcrosses.game.Field;




public class Ai extends Users {
	
	public Ai(char sign){
		super("Albert", sign);
	}
	
	//Artifical Intelligence =)
	
	@Override
	public int returnMoveCoordinates(){
		Random random = new Random();
		return random.nextInt(3);
	}
	
}
