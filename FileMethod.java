package org.Ibrahim;

import java.io.*;
class FileMethodDemo {
    public static void main(String []args) throws IOException {
        String filename;
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter name of file/directory ");
        filename = input.readLine();
        File fileDir = new File(filename);
        if (!fileDir.exists())
        {
            System.out.println(filename + " does not exist!");
            return;
        }
        if (fileDir.isFile())
        {
            System.out.println(filename + " is a file.");
            System.out.println("File Name: " +fileDir.getName());
            System.out.println("Path: " +fileDir.getPath());
            System.out.println("Absolute path: " +fileDir.getAbsolutePath());
            System.out.println("Parent:" +fileDir.getParent());
            if(fileDir.exists())
                System.out.println("File exists");
            else
                System.out.println("File does not exists");
            if(fileDir.canRead())
                System.out.println(fileDir + " is readable");
            else
                System.out.println(fileDir + " is not readable");
            if(fileDir.canWrite())
                System.out.println(fileDir + " is Writeable");
            else
                System.out.println(fileDir + " is not Writeable");
            System.out.println("File Size: " +fileDir.length() + " bytes");
        }
        else
        {
            System.out.println(filename + " is a Directory.");
            System.out.println("Contents:");
            String[] fileList = fileDir.list();
            assert fileList != null;
            for (String s : fileList) System.out.println(" " + s);
        }
    }
}
