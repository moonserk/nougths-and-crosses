package com.noughtsandcrosses.network;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public void createClient(){
		
		try{
			Socket client = new Socket("127.0.0.1", 8912);
			
			try{
				InputStream inStream = client.getInputStream();
				Scanner in = new Scanner(inStream);

                System.out.println(in.next());

			}
			finally{
				client.close();
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	
}
