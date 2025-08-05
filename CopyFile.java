package org.Ibrahim;

import java.io.*;
class CopyFile {
    public static void main(String[] args) throws IOException
    {
        int i;
        FileInputStream source = null;
        FileOutputStream dest = null;

        if(args.length != 2) {
            System.out.println("ERROR Please enter the Source file and Destination file");
            return;
        }

        try {

            source = new FileInputStream(args[0]);
            dest = new FileOutputStream(args[1]);
            do {
                i = source.read();
                if(i!=-1)
                    dest.write(i);
            } while(i!=-1);
        } catch (IOException e) {
            System.out.println("I/O Error: " +e);
        } finally {
            try {
                if (source!= null)
                    source.close();
            } catch (IOException e2) {
                System.out.println("Error Closing Input File") ;
            }
            try {
                if(dest!=null)
                    source.close();
            } catch(IOException e2) {
                System.out.println("Error Closing output file");
            }
        }
    }
}