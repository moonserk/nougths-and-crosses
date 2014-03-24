package com.noughtsandcrosses.game;


/**
 * Created by Gregory on 02.02.14.
 */
public class Field{ // Singleton

    private static final int FIELD_SIZE = 3;

    private static final char CLEAR_CELL = ' ';

    private static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    
    private static char[] fieldCheckWin = new char[FIELD_SIZE];
    
    private static char signCheck;
    
	private static boolean busy = true;
	
	private static Field instance = new Field();
	
	private Field(){}
	
	public static Field getInstance(){
		return instance;
	}
    
    public static int getFieldSize() {
		return FIELD_SIZE;
	}

	public static boolean getBusy(){
    	return busy;
    }
    
    public static  void setBusy(boolean aBusy){
    	busy = aBusy;
    }
    
    public static char getSignCheck(){
    	return signCheck;
    }
    
    public static void setSignCheck(char aSignCheck) {
    	signCheck = aSignCheck;
	}
    
    public static char[][] returnField(){ // it's work  =)
    	return field;
    }
    
    public static void moveOn(int i, int j, char sign){
    	if(field[i][j] == ' '){
    		field[i][j] = sign;
    		busy = false;
    	}
    	else{
    		busy = true;
    		System.out.println("You can't go that!");
    	}
    }
    

    public static void clearField(){
        for(int i = 0 ; i < FIELD_SIZE; i++){
            setLineForClear(i);
        }
    }

    private static void setLineForClear(int i){
        for(int j = 0 ; j < FIELD_SIZE ; j++ ){
            field[i][j] = CLEAR_CELL;
        }
    }


    public static void showField(){
        for(int i = 0 ; i < FIELD_SIZE; i++){
            System.out.println(getLine(i));      // New line
        }
    }

    
    public static String getLine(int i){
        String line = "";
    	for(int j = 0 ; j < FIELD_SIZE ; j++ ){
             line += "[" + field[i][j] + "]";
        }
    	return line;
    }
    
    private static boolean checkField(){
    	boolean win = false;
    	signCheck = fieldCheckWin[0];
    	for(int i = 1; i < FIELD_SIZE; i++){
    		if(fieldCheckWin[i] == signCheck && fieldCheckWin[i] != ' '){
    			win = true;
    		} 
    		else{
    			win = false;
    			return false;
    		}
    	}
    	return win;
    }
    
    
    
    private static boolean checkHorizontalCombination(){
    	boolean win = false;
    	for(int i = 0 ; i < FIELD_SIZE ; i++ ){
    		for(int j = 0; j < FIELD_SIZE ; j++){
    			fieldCheckWin[j] = field[i][j];
    		}
    		win = checkField();
    		if(win == true){
    			return win;
    		}
    	}
		return false;
    }
    
    private static boolean checkVerticalCombination(){
    	boolean win = false;
    	for(int j = 0 ; j < FIELD_SIZE ; j++){
    		for(int i = 0 ; i < FIELD_SIZE ; i++){
    			fieldCheckWin[i] = field[i][j];
    		}
    		win = checkField();
    		if(win == true){
    			return win;
    		}
    	}
		return false;
    }
    
    public static boolean check(){
    	boolean win = false;
    	win = checkHorizontalCombination();
    	if(win == true){
    		return win;
    	}
    	win = checkVerticalCombination();
    	if(win == true){
    		return win;
    	}
		win = checkDiagonalCombination_1();
		if(win == true){
			return win;
		}
		win = checkDiagonalCombination_2();
		if(win == true){
			return win;
		}
		return false;
    }
    
    public static boolean checkEmptyCells(){
    	final int allCells = FIELD_SIZE * FIELD_SIZE;
    	int notEmpty = 0;
		for(int i = 0, j = 0 ; i < FIELD_SIZE ; i++, j = 0){
			for(; j < FIELD_SIZE ; j++){
				if(field[i][j] != ' '){
					notEmpty++;
				}
			}
		}
		
		if(notEmpty == allCells){
			return true;
		}
		return false;
    }
    
    private static boolean checkDiagonalCombination_1(){
    	clearFieldCheckWin();
    	boolean win = false;
    	for(int i = 0, j = 0 ; i < FIELD_SIZE ; i++, j++ ){
    		fieldCheckWin[i] = field[i][j];
    		win = checkField();
    		if(win == true){
    			return win;
    		}
    	}
		return false;
    }
    
    private static boolean checkDiagonalCombination_2(){
    	clearFieldCheckWin();
    	boolean win = false;
    	for(int i = 0, j = FIELD_SIZE - 1 ; i < FIELD_SIZE ; i++, j-- ){
    		fieldCheckWin[i] = field[i][j];
    		win = checkField();
    		if(win == true){
    			return win;
    		}
    	}
		return false;
    }
    
    private static void clearFieldCheckWin(){
    	for(int i = 0; i < FIELD_SIZE ; i++){
    		fieldCheckWin[i] = ' ';
    	}
    }

}

//KISS
