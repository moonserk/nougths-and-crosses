package com.noughtsandcrosses;

import com.noughtsandcrosses.game.Game;
import com.noughtsandcrosses.game.NetworkGame;
import com.noughtsandcrosses.network.Client;

import java.util.Scanner;

/**
 * Created by Gregory on 02.02.14.
 */

public class Main {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        System.out.println("Tic tap toe");
        System.out.println("Choose game mod : 1 - (Single) 2 - (Lan)");
        switch(in.nextInt()){
            case 1 :
                Game game = new Game();
                game.startGame();
                break;
            case 2 :
                System.out.println("Choose game mod : 1 - (Server) 2 - (Client)");
                if(in.nextInt() == 2){
                    Client client = new Client();
                    client.createClient();
                }
                else {
                    NetworkGame networkGame = new NetworkGame();
                    networkGame.startGame();
                }
                break;
            default:
                System.out.println("Go away");
        }
    }	
}
