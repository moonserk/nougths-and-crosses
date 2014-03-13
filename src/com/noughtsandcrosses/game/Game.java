package com.noughtsandcrosses.game;

import java.util.Scanner;

import com.noughtsandcrosses.users.Ai;
import com.noughtsandcrosses.users.Human;
import com.noughtsandcrosses.users.Users;

/**
 * Created by Gregory on 02.02.14.
 */
public class Game{
	private Users user1;
	private Users user2;
	
	private Ai ai = new Ai(' ');
	
	private Field field;
	
	Scanner in = new Scanner(System.in);
	
	public void startGame(){
		field = new Field();
		field.clearField();
		
		creatingGamers();
        System.out.println("Game STARTED");
        field.showField();
        System.out.print(gameWinner());
        
        switch(field.getSignCheck()){
        	
        	case 'X' : 
        		System.out.println(user1.getName());
        		break;
        	case '0' :
        		System.out.println(user2.getName());
        		break;
        	case ' ' :
        		System.out.println();
        }
	}
	
	private String gameWinner(){
		String textWin = "Winner is ";
		String deadHeat = "!!!Dead heat!!!";
        for(boolean finish = false ; finish != true ;){
            for(; field.getBusy() == true ;){
            	if(field.checkEmptyCells() == true){
            		field.setSignCheck(' ');
                	return deadHeat;
                }
            	move(user1);
            }
            finish = field.check();
            if(finish == true){
            	return textWin;
            }
            field.setBusy(true);
            
            for(;field.getBusy() == true;){
            	if(field.checkEmptyCells() == true){
            		field.setSignCheck(' ');
                	return deadHeat;
                }
            	move(user2);
            }
            finish = field.check();
            if(finish == true){
            	return textWin;
            }
            field.setBusy(true);
        }
        return deadHeat;
	}
	
	private void creatingGamers(){
		System.out.println("Select game mod: 1 - {Human vs. Human} 2 - (Human vs. AI)");
		int gameMod = in.nextInt();
		System.out.println("User one what your name?");
		user1 = new Human(in.next(), 'X');
		switch(gameMod){
			case 1 :
				System.out.println("User two what your name?");
				user2 = new Human(in.next(), '0');
				break;
			case 2 : 
				user2 = new Ai('0');
				break;
			default : 
				System.out.println("Sorry, only 1 or 2");
				break;
		}
	}

	private void moveOn(Users user) {
		System.out.println("Your turn " + user.getName());
		try{
			field.moveOn(user.returnMoveCoordinates(), user.returnMoveCoordinates(), user.getSign());
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("Miss");
			moveOn(user);
		}
	}
	
	private void move(Users user){
		moveOn(user);
		field.showField();
		//ai.showFF(); /// /// check
	}
}
