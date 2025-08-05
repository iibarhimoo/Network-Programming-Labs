package org.Ibrahim;
import java.io.*;
import java.net.*;
import java.util.*;
public class MultiEchoServer
{
    private static ServerSocket servsoc;
    private static final int PORT = 1234;
    public static void main(String[] args) throws IOException
    {
        try
        {
            servsoc = new ServerSocket(PORT);
        }
        catch (IOException ioEx)
        {
            System.out.println("\nUnable to set up port!");
            System.exit(1);
        }
        System.out.println("\nWaiting for Client.\n");
        do
        {
            Socket client = servsoc.accept();
            System.out.println("\nNew client accepted.\n");

            ClientHandler handler = new ClientHandler(client);
            handler.start();

        }while (true);
    }
}
class ClientHandler extends Thread
{
    private Socket client;
    private Scanner input;
    private PrintWriter output;
    public ClientHandler(Socket soc)
    {
//Set up reference to associated socket…
        client = soc;
        try
        {
            input = new Scanner(client.getInputStream());
            output = new PrintWriter(client.getOutputStream(),true);
        }catch(IOException ioEx)
        {

            ioEx.printStackTrace();
        }
    }
    public void run()
    {
        String received;
        do
        {
            received = input.nextLine();
            output.println("ECHO: " + received);
        }while (!received.equals("QUIT"));
        try
        {
            if (client!=null)
            {
                System.out.println("client disconnected");
                client.close();
            }
        }
        catch(IOException ioEx)
        {
            System.out.println("Unable to disconnect!");
        }
    }
}