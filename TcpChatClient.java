package org.Ibrahim;
import java.io.*;
import java.net.*;

public class TcpChatClient {
    public static void main(String args[])throws Exception{
        Socket Cltsoc;
        PrintWriter toServer;
        BufferedReader fromUser, fromServer;
        if (args.length !=2){
            System.err.println("ERROR: Please enter the host name and port number");
            System.exit(1);
        }
        String hostName = args[0];
        int portNumber = Integer.parseInt(args[1]);
        try
        {
            Cltsoc = new Socket(hostName,portNumber);
            toServer = new PrintWriter(new OutputStreamWriter(Cltsoc.getOutputStream()), true);
            fromServer = new BufferedReader(new InputStreamReader(Cltsoc.getInputStream()));
            fromUser = new BufferedReader(new InputStreamReader(System.in));
            String CltMsg, SrvMsg;
            System.out.println("Client Started");
            System.out.println("Type \"end\" to Quit");
            while (true)
            {
                System.out.print("\nMessage to Server : ");
                CltMsg = fromUser.readLine();
                toServer.println(CltMsg);
                if (CltMsg.equals("end"))
                    break;
                SrvMsg = fromServer.readLine();
                System.out.println("The message from server is <<< " + SrvMsg + " >>> ");
            }
        }
        catch(Exception E)
        {
            System.out.println(E.getMessage());
        }
    }
}
