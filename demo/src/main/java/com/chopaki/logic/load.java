package com.chopaki.logic;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HexFormat;

public class load {
    private static ArrayList<String> passwords = new ArrayList<String>();
    public static void load()
    {
        try
        {
            BufferedReader inputBinFile = new BufferedReader(new FileReader("passwords.bin"));
            String data;

            while((data = inputBinFile.readLine()) != null)
            {
                byte[] bytes = HexFormat.of().parseHex(data.trim());
                String password = new String(bytes);
                passwords.add(password);
            }
        }catch(IOException e)
        {
            e.printStackTrace();
            return;
        }
    }

    public static ArrayList<String> getPasswords() {
    return passwords;
}

public static void clearlist() {
    passwords.clear();
    }
}
