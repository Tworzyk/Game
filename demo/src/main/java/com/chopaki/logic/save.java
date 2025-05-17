package com.chopaki.logic;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.HexFormat;



public class save {


    public static void save(String password)
    {
        try
        {
            OutputStream binFile = new FileOutputStream(new File("passwords.bin"),true);
            String hexPassword = HexFormat.of().formatHex(password.getBytes());
            binFile.write(hexPassword.getBytes());
            binFile.write("\n".getBytes());
            binFile.close();
           
        }catch(IOException e)
        {
            e.printStackTrace();
        }
    } 
}
