package com.noughtsandcrosses.network;

import com.noughtsandcrosses.game.NetworkGame;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner input = new Scanner(System.in);

    public static void createClient(){

		try{
			Socket client = new Socket("127.0.0.1", 8912);
			
			try{
				InputStream inStream = client.getInputStream();
                OutputStream outStream = client.getOutputStream();
                Scanner in = new Scanner(inStream);
                PrintWriter out = new PrintWriter(outStream, true);

                if(Server.isFlag() == true) {
                    out.println(in.nextLine());
                    Server.setFlag(false);
                    out.close();
                }

                while(in.hasNext()) {
                    System.out.println(in.nextLine());
                }

                Client.createClient();

			}
			finally{
				client.close();
			}
		}catch(IOException e){
			System.out.println("Disconnect");
		}
		
	}
	
}
