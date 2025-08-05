package org.Ibrahim;

import java.net.MalformedURLException;
import java.net.URL;
public class URLDemo {
    public static void main(String args[]) throws MalformedURLException {
        URL hp = new URL("https://tuwaiq.edu.sa/bootcamps?category=ac41152d-f228-8af4-8406-e0cda6df6c35&type=NORMAL");
        System.out.println("Protocol : " + hp.getProtocol());
        System.out.println("Host : " +hp.getHost());
        System.out.println("Port : " + hp.getPort());
        System.out.println("Default Port : " + hp.getDefaultPort());
        System.out.println("File : " + hp.getFile());
        System.out.println("Path : " + hp.getPath());
        System.out.println("Fragment Identifier : " + hp.getRef());
        System.out.println("Query String : " + hp.getQuery());
        System.out.println("User Info : " + hp.getUserInfo());
        System.out.println("Authority : " + hp.getAuthority());
    }

}
