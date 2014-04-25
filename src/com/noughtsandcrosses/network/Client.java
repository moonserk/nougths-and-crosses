package com.noughtsandcrosses.network;


import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    Scanner input = new Scanner(System.in);
    InputStream inStream;
    OutputStream outStream;
    PrintWriter out;

    Scanner in;
    Socket client;

    public  void createClient() {

        try {
             //client = new Socket("127.0.0.1", 8912);

            try {

                fromServer();
                fromServer();
                toServer();
                fromServer();
                fromServer();

                while(client.isConnected()){
                    toServer();
                    toServer();
                    fromServer();
                    fromServer();
                    fromServer();
                }



            } finally {
                client.close();
            }
        } catch (IOException e) {
            System.out.println("Disconnect");
        }

    }

    public void fromServer(){
        try {
            client = new Socket("127.0.0.1", 8912);
            try{
            inStream = client.getInputStream();
            in = new Scanner(inStream);
            while (in.hasNext()) {
                System.out.println(in.nextLine());
            }
            }finally{
                client.close();
            }
        }catch (IOException e) {
            System.out.println("Disconnect");
        }

    }

    public void toServer(){
        try {
            client = new Socket("127.0.0.1", 8912);
            outStream = client.getOutputStream();
            out = new PrintWriter(outStream, true);
            out.println(input.nextLine());
            //out.flush();

        } catch (IOException e) {
                System.out.println("Disconnect");
        }
    }
}
