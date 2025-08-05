package org.Ibrahim;

import java.io.*;
import java.net.*;
class TcpChatServer{
    public static void main(String[] args)throws Exception {
        PrintWriter toClient;
        BufferedReader fromUser, formClient;
        if (args.length !=1){
            System.err.println("ERROR: Please enter port number");
            System.exit(1);
        }
        int portNumber = Integer.parseInt(args[0]);
        try {
            ServerSocket Srvsoc = new ServerSocket(portNumber);
            System.out.print("\nServer started\n");
            Socket Cltsoc = Srvsoc.accept();
            System.out.println("Client connected");
            toClient = new PrintWriter(new OutputStreamWriter(Cltsoc.getOutputStream()), true);
            BufferedReader fromClient = new BufferedReader(new InputStreamReader(Cltsoc.getInputStream()));
            fromUser = new BufferedReader(new InputStreamReader(System.in));
            String CltMsg, SrvMsg;
            while (true) {
                CltMsg = fromClient.readLine();
                if (CltMsg.equals("end"))
                    break;
                else {
                    System.out.println("\nThe message from client is <<< " + CltMsg + " >>>");
                    System.out.print("Message to Client : ");
                    SrvMsg = fromUser.readLine();
                    toClient.println(SrvMsg);
                }
            }
            System.out.println("\nClient Disconnected");
            fromClient.close();
            toClient.close();
            fromUser.close();
            Cltsoc.close();
            Srvsoc.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}