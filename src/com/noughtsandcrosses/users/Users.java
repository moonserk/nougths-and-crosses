package com.noughtsandcrosses.users;



import java.util.Scanner;

/**
 * Created by Gregory on 02.02.14.
 */
public abstract class Users {
	private char sign;
	
	private Scanner in = new Scanner(System.in);

    private String name = "N/A";

    public Users(String name, char sign){
    	this.sign = sign;
        if(name.length() < 12){
        	this.name = name;
        } else {
        	this.name = name.substring(0, 11);
        }
    }
    
    public String getName(){
        return name;
    }
    
    public char getSign(){
    	return sign;
    }
    
    public int returnMoveCoordinates(){
    	return in.nextInt();
    }
}
