package org.Ibrahim;
import java.net.*;
import java.io.*;

public class TCPServer {
    public static void main(String[] args)throws IOException{
        int port = 443;
        try(ServerSocket yahay = new ServerSocket(port)){
            System.out.println("TCP Server Socket is created and the name of Server object Yahya");
            System.out.println("The port number of server is " + yahay.getLocalPort());
        }catch (IOException e) {
            System.err.println("Error creating server socket: " + e.getMessage());
        }
    }
}
