package com.noughtsandcrosses;

import com.noughtsandcrosses.game.Game;
import com.noughtsandcrosses.network.Server;

/**
 * Created by Gregory on 02.02.14.
 */

public class Main {

    public static void main(String[] args){
    	Game game = new Game();
    	game.startGame();
        Server server =  new Server();
        server.crateServer();
    }	
}
