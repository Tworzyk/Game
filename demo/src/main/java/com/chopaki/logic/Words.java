package com.chopaki.logic;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class Words
{
    private static ArrayList<String> words = new ArrayList<String>();
    static
    {
        try
        {
            loadfromFile();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }
  private static void loadfromFile() throws IOException {

        FileReader fr = null;
        try
        {
            fr = new FileReader("src\\main\\resources\\words.txt");
        }catch(FileNotFoundException fe)
        {
            System.out.println("File not found");
        }

        BufferedReader br = new BufferedReader(fr);
        String line = null;
        while((line = br.readLine()) != null)
        {
           words.add(line);
        }
        fr.close();
       
    }
  
    private static Character[] convertToCharacterArray(char[] arr) {
        if(arr == null){
            return null;
        }
        Character[] finalArray = new Character[arr.length];
        for(int i=0;i<arr.length;i++){
            finalArray[i] = arr[i];
        }
        return finalArray;
    }


   static Character[] specials = convertToCharacterArray(("!@#$%^&*?+-".toCharArray()));
    private static ArrayList<String> getWords()
    {
        return words;
    }
    private String getWord(int index)
    {
        return words.get(index);
    }
    public static String addWords(Boolean special, int howmanywords)
    {
        if (words.isEmpty()) {
            throw new IllegalStateException("Words list is not initialized or is empty.");
        }
        Character specialChar = specials[0];
        if(special)
        {
            specialChar = getSpecial();
        }
        String result = "";
        for(int i = 0; i < howmanywords -1 ; i++)
        {
            result +=  words.get(getRandomNumber()) + specialChar;
        }
        result += words.get(getRandomNumber());
        return result;
    }
    private static int getRandomNumber()
    {
        if (words.isEmpty()) {
            throw new IllegalStateException("Words list is not initialized or is empty.");
        }
        Random random = new Random();
        return random.nextInt(words.size());
    }
    private static int getRandomNumberSpecial()
    {
        Random random = new Random();
        return random.nextInt(specials.length);
    }
    private static Character getSpecial()
    {
        return specials[getRandomNumberSpecial()];
    }
}