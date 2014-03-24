package com.noughtsandcrosses.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.noughtsandcrosses.game.Field;

public class Server {
	
	public void crateServer(){
		try{
		
			ServerSocket server = new ServerSocket(8912);
			Socket incoming = server.accept();
		
			try{
			
				InputStream inStream = incoming.getInputStream();
				OutputStream outStream = incoming.getOutputStream();
			
				Scanner in = new Scanner(inStream);
				PrintWriter out = new PrintWriter(outStream, true);
				
				for(int i = -1 ; ++i < Field.getFieldSize() ;){
					out.println(Field.getLine(i));
				}

			}
			finally{
				incoming.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
