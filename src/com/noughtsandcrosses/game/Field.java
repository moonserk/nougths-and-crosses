package com.noughtsandcrosses.game;

/**
 * Created by Gregory on 02.02.14.
 */
public class Field{

    private static final int FIELD_SIZE = 3;

    private static final char CLEAR_CELL = ' ';

    private static char[][] field = new char[FIELD_SIZE][FIELD_SIZE];
    
    private char[] fieldCheckWin = new char[FIELD_SIZE];
    
    private char signCheck;
    

	private boolean busy = true;
    
    public static int getFieldSize() {
		return FIELD_SIZE;
	}

	public boolean getBusy(){
    	return busy;
    }
    
    public  void setBusy(boolean busy){
    	this.busy = busy;
    }
    
    public char getSignCheck(){
    	return signCheck;
    }
    
    public void setSignCheck(char signCheck) {
		this.signCheck = signCheck;
	}
    
    public char[][] returnField(){ // it's work  =)
    	return field;
    }
    
    public void moveOn(int i, int j, char sign){
    	if(field[i][j] == ' '){
    		field[i][j] = sign;
    		busy = false;
    	}
    	else{
    		busy = true;
    		System.out.println("You can't go that!");
    	}
    }
    

    public void clearField(){
        for(int i = 0 ; i < FIELD_SIZE; i++){
            setLineForClear(i);
        }
    }

    private void setLineForClear(int i){
        for(int j = 0 ; j < FIELD_SIZE ; j++ ){
            field[i][j] = CLEAR_CELL;
        }
    }


    public void showField(){
        for(int i = 0 ; i < FIELD_SIZE; i++){
            setLineForShow(i);
            System.out.println();               // New line
        }
    }

    private void setLineForShow(int i){
        for(int j = 0 ; j < FIELD_SIZE ; j++ ){
            System.out.print("[" + field[i][j] + "]");
        }
    }
    
    private boolean checkField(){
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
    
    
    
    private boolean checkHorizontalCombination(){
    	boolean win = false;
    	for(int i = 0, j = 0 ; i < FIELD_SIZE ; i++, j = 0 ){
    		for(; j < FIELD_SIZE ; j++){
    			fieldCheckWin[j] = field[i][j];
    		}
    		win = checkField();
    		if(win == true){
    			return win;
    		}
    	}
		return false;
    }
    
    private boolean checkVerticalCombination(){
    	boolean win = false;
    	for(int i = 0, j = 0 ; i < FIELD_SIZE ; i++, j = 0 ){
    		for(; i < FIELD_SIZE ; i++){
    			fieldCheckWin[i] = field[i][j];
    		}
    		win = checkField();
    		if(win == true){
    			return win;
    		}
    	}
		return false;
    }
    
    public boolean check(){
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
    
    public boolean checkEmptyCells(){
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
    
    private boolean checkDiagonalCombination_1(){
    	boolean win = false;
        clearCheckField();
    	for(int i = 0, j = 0 ; i < FIELD_SIZE ; i++, j++ ){
    		fieldCheckWin[i] = field[i][j];
    		win = checkField();
    		if(win == true){
    			return win;
    		}
    	}
		return false;
    }
    private boolean checkDiagonalCombination_2(){
    	boolean win = false;
        clearCheckField();
    	for(int i = 0, j = FIELD_SIZE - 1 ; i < FIELD_SIZE ; i++, j-- ){
    		fieldCheckWin[i] = field[i][j];
    		win = checkField();
    		if(win == true){
    			return win;
    		}
    	}
		return false;
    }

    private void clearCheckField(){
        for (int i = 0 ; ++i < FIELD_SIZE ;){
            fieldCheckWin[i] = CLEAR_CELL;
        }
    }
}

//KISS
