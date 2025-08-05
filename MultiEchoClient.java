package org.Ibrahim;

import java.io.*;
import java.net.*;
import java.util.*;

public class MultiEchoClient
{
    private static InetAddress host;
    private static final int PORT = 1234;

    public static void main(String[] args)
    {
        try
        {
            host = InetAddress.getLocalHost();
        }
        catch(UnknownHostException uhEx)
        {
            System.out.println("\nHost ID not found!\n");
            System.exit(1);
        }
        sendMessages();
    }

    private static void sendMessages()
    {
        Socket soc = null;
        try
        {
            soc = new Socket(host, PORT);

            Scanner networkInput = new Scanner(soc.getInputStream());
            PrintWriter networkOutput = new PrintWriter(soc.getOutputStream(), true);

            Scanner userEntry = new Scanner(System.in);
            String message, response;

            do
            {
                System.out.print("Enter message ('QUIT' to exit): ");
                message = userEntry.nextLine();

                networkOutput.println(message);
                response = networkInput.nextLine();

                System.out.println("\nSERVER> " + response);
            }
            while (!message.equals("QUIT"));
        }
        catch(IOException ioEx)
        {
            ioEx.printStackTrace();
        }
        finally
        {
            try
            {
                if (soc != null && !soc.isClosed()) {
                    System.out.println("\nClosing connection");
                    soc.close();
                }
            }
            catch(IOException ioEx)
            {
                System.out.println("Unable to disconnect!");
                System.exit(1);
            }
        }
    }
}