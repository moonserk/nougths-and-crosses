package com.noughtsandcrosses.game;

import com.noughtsandcrosses.network.Server;
import com.noughtsandcrosses.users.Ai;
import com.noughtsandcrosses.users.Human;
import com.noughtsandcrosses.users.Users;

/**
 * Created by gregory on 28.03.14.
 */
public class NetworkGame extends Game{

    private Server server = new Server();

    @Override
    public void endGame(){
        String gameWinner = gameWinner();
        System.out.print(gameWinner);
        server.showStreamMessage(gameWinner);

        switch(Field.getSignCheck()){

            case 'X' :
                System.out.println(user1.getName());
                server.showStreamMessage(user1.getName());
                break;
            case '0' :
                System.out.println(user2.getName());
                server.showStreamMessage(user2.getName());
                break;
            case ' ' :
                System.out.println();
        }
    }

    @Override
    public String gameWinner(){
        String textWin = "Winner is ";
        String deadHeat = "!!!Dead heat!!!";
        for(boolean finish = false ; finish != true ;){
            for(; Field.getBusy() == true ;){
                if(Field.checkEmptyCells() == true){
                    //Field.setSignCheck(' ');
                    return deadHeat;
                }
                move(user1);
            }
            finish = Field.check();
            if(finish == true){
                return textWin;
            }
            Field.setBusy(true);

            for(;Field.getBusy() == true;){
                if(Field.checkEmptyCells() == true){
                    //Field.setSignCheck(' ');
                    return deadHeat;
                }
                moveStream(user2);
            }
            finish = Field.check();
            if(finish == true){
                return textWin;
            }
            Field.setBusy(true);
        }
        return deadHeat;
    }


    @Override
    public void creatingGamers(){
        server.crateServer();

        System.out.println("Network game");
        server.showStreamMessage("Network game");

        System.out.println("User one what your name?");
        user1 = new Human(in.next(), 'X');

        server.showStreamMessage("User two what your name?");
        user2 = new Human(server.getStreamMessage(), '0');
    }

    @Override
    public void move(Users user){
        moveOn(user);
        Field.showField();
        server.showStreamField();
    }

    public void moveOnStream(Users user){
        server.showStreamMessage("Your turn " + user.getName());
        try{
            Field.moveOn(server.getStreamCoordinates(), server.getStreamCoordinates(), user.getSign());
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Miss");
            moveOnStream(user);
        }
    }

    public void moveStream(Users user){
        moveOnStream(user);
        server.showStreamField();
        Field.showField();
    }

}
