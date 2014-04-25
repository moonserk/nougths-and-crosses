package com.noughtsandcrosses.network;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

import com.noughtsandcrosses.game.Field;
import com.noughtsandcrosses.game.NetworkGame;

public class Server {

    private ServerSocket server;
    private InputStream inStream;
    private OutputStream outStream;
    private Scanner in;
    private PrintWriter out;
    private Socket incoming;

    public void crateServer() {
        try {

            server = new ServerSocket(8912);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStreamMessage(String s) {

        try {
            incoming = server.accept();

            try {
                outStream = incoming.getOutputStream();
                out = new PrintWriter(outStream, true);

                out.println(s);

            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void showStreamField() {

        try {
            incoming = server.accept();

            try {
                outStream = incoming.getOutputStream();
                out = new PrintWriter(outStream, true);

                for (int i = 0; i < Field.getFieldSize(); i++) {
                    out.println(Field.getLine(i));
                }

            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public int getStreamCoordinates() {
        try {
            incoming = server.accept();

            try {

                inStream = incoming.getInputStream();
                in = new Scanner(inStream);

                return in.nextInt();

            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    public String getStreamMessage() {
        try {
            incoming = server.accept();

            try {

                inStream = incoming.getInputStream();
                in = new Scanner(inStream);

                return in.nextLine();

            } finally {
                incoming.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
