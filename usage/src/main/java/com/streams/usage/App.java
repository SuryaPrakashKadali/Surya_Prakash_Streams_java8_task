package com.streams.usage;

import java.util.ArrayList;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class App 
{
	private static final Logger LOGGER=LogManager.getLogger(App.class);
	private static Scanner in;
	public static double getAverage(int[] arr) {
		IntStream stream = IntStream.of(arr); 
        OptionalDouble obj = stream.average(); 
        if (obj.isPresent()) { 
        	return (obj.getAsDouble()); 
        } 
        else { 
            return -1.0; 
        } 
	}
	public static List<String> getListOfWords(List<String>listWords){
		return listWords.stream().filter(s -> s.startsWith("a")).filter(s -> s.length() == 3).collect(Collectors.toList());
	}
	public static List<String> getListOfPalind(List<String>listWords){
		List<String> palindromeList=new ArrayList<>();
		for(int index=0;index<listWords.size();index++) {
			String tempString=listWords.get(index);
			if(IntStream.range(0, tempString.length() / 2).noneMatch(i-> tempString.charAt(i) != tempString.charAt(tempString.length() - i - 1))) {
				palindromeList.add(tempString);
			}
		}
		return palindromeList;
	}
    public static void main( String[] args)
    {
    	in =new Scanner(System.in);
    	LOGGER.debug("Enter number of elements ");
    	int n = in.nextInt();
    	int[] arr=new int[n];
    	LOGGER.debug("Enter elements ");
    	for(int i=0;i<n;i++) {
    		arr[i]=in.nextInt();
    	}
    	LOGGER.debug("The average of numbrs is");
    	LOGGER.debug(getAverage(arr));
    	LOGGER.debug("Enter the no of word number");
    	int sizeWordsList=in.nextInt();
    	in.nextLine();
    	LOGGER.debug("Enter the words");
    	List<String>listWords=new ArrayList<>();
    	for(int i=0;i<sizeWordsList;i++) {
    		listWords.add(in.nextLine());
    	}
    	List<String>wordsStartWithA=getListOfWords(listWords);
    	LOGGER.debug("List of words starts with a and length is 3");
    	for(int i=0;i<wordsStartWithA.size();i++) {
    		LOGGER.debug(wordsStartWithA.get(i));
    	}
    	LOGGER.debug("Enter the size of word number");
    	int sizeOfPalind=in.nextInt();
    	in.nextLine();
    	LOGGER.debug("Enter the strings");
    	List<String>listWordsPalind=new ArrayList<>();
    	for(int i=0;i<sizeOfPalind;i++) {
    		listWordsPalind.add(in.nextLine());
    	}
    	List<String>listOfPalindrome=getListOfPalind(listWordsPalind);
    	LOGGER.debug("List of Palindrome from the give list of words:");
    	for(int i=0;i<listOfPalindrome.size();i++) {
    		LOGGER.debug(listOfPalindrome.get(i));
    	}
    	in.close();
        
    }
}
