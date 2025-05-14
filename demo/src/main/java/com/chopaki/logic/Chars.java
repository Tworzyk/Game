package com.chopaki.logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;


public class Chars {

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

    public static String genChars(int length, Boolean nums, Boolean special, Boolean large){
        Character[] alphabet = convertToCharacterArray(("abcdefghijklmnopqrstiwvxyz".toCharArray()));
        Character[] digits = convertToCharacterArray(("1234567890".toCharArray()));
        Character[] specials = convertToCharacterArray(("!@#$%^&*?+-".toCharArray()));
        Character[] larges = convertToCharacterArray("ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray());

        Random generator = new Random();
        String password = "";
        List<Character> completeList = new ArrayList<>();

        completeList.addAll(new ArrayList<>(Arrays.asList(alphabet)));

        if(nums){
            completeList.addAll(new ArrayList<>(Arrays.asList(digits)));
        }
        if(special){
            completeList.addAll(new ArrayList<>(Arrays.asList(specials)));
        }
        if(large){
            completeList.addAll(new ArrayList<>(Arrays.asList(larges)));
        }

        for(int i=0;i<length;i++){
            Character character = completeList.get(generator.nextInt(completeList.size()));
            password += character.toString();
    }
    return password;
}

}