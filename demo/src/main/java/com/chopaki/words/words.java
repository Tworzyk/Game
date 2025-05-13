package com.chopaki.words;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException; 
import java.util.ArrayList;

public class words
{
    ArrayList<String> words;
    words() throws IOException
    {
        words = new ArrayList<String>();
        int ch;
        FileReader fr = null;
        try
        {
             fr = new FileReader("words.txt");
        }catch(FileNotFoundException fe)
        {
            System.out.println("File not found");
            return;
        }

        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while((line = br.readLine()) != null)
        {
           words.add(line);
        }
        fr.close();
    }   

    public ArrayList<String> getWords()
    {
        return words;
    }
    public String getWord(int index)
    {
        return words.get(index);
    }
    public String addWords(String sing, int howmanywords)
    {
        String result = "";
        for(int i = 0; i < howmanywords -1 ; i++)
        {
            result +=  words.get(getRandomNumber()) + sing;
        }
        result += words.get(getRandomNumber());
        return result;
    }
    private int getRandomNumber()
    {
        int min = 0;
        int max = words.size();
        return (int)(Math.random() * (max - min + 1) + min);
    }
    public static void main(String[] args) throws IOException
    {
         words slowa = new words();
        System.out.println(slowa.addWords("+", 5));
    }
}