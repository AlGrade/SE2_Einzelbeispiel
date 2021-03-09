package com.example.se2_einzelbeispiel;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerConnection implements Runnable {

    String mNumber;
    String responseFromServer;

    public ServerConnection(String mNumber) {
        this.mNumber = mNumber;
    }

    @Override
    public void run() {

        try {

            Socket clientSocket = new Socket("se2-isys.aau.at", 53212);
            BufferedReader inFromUser = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            PrintWriter writer = new PrintWriter(clientSocket.getOutputStream(), true);

            writer.println(mNumber);

            responseFromServer = inFromUser.readLine();

            clientSocket.close();
            writer.close();
            inFromUser.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
