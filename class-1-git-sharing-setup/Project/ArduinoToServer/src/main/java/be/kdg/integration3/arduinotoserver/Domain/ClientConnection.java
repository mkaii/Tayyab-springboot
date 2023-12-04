package be.kdg.integration3.arduinotoserver.Domain;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientConnection {
    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    public ClientConnection() {
    }

    public ClientConnection(PrintWriter out, BufferedReader in) {
        this.out = out;
        this.in = in;
    }

    public void startConnection(String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sendMessage("first data", ip, port);
    }

    public String sendMessage(String msg, String ip, int port) throws IOException {
        clientSocket = new Socket(ip, port);
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        out.println(msg);
        String resp = in.readLine();
        return resp;
    }

    public void sendMessageWithoutResponse(String msg) throws IOException {
        out.println(msg);
    }

    public void stopConnection() throws IOException {
        in.close();
        out.close();
        clientSocket.close();
    }
}
