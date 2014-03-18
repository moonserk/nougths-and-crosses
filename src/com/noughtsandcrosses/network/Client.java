package com.noughtsandcrosses.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void createClient(){
		
		try{
			Socket client = new Socket("samsung", 8912);
			
			try{
				InputStream inStream = client.getInputStream();
				Scanner in = new Scanner(inStream);
			}
			finally{
				client.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
}
