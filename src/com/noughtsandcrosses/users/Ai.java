package com.noughtsandcrosses.users;


import java.util.Random;

import com.noughtsandcrosses.game.Field;




public class Ai extends Users {
	
	public Ai(char sign){
		super("Albert", sign);
	}
	
	//Artifical Intelligence =)
	
	
	
//	public void showFF(){
//		controlField = field.returnField();
//		for(int i = 0 ; i < field.getFieldSize() ; i++){
//			for(int j = 0 ; j < field.getFieldSize() ; j++){
//				System.out.print(controlField[i][j]);
//			}
//			System.out.println();
//		}
//	}
	
	
	@Override
	public int returnMoveCoordinates(){
		Random random = new Random();
		return random.nextInt(3);
	}
	
}
