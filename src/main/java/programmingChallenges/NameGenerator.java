package programmingChallenges;

import java.util.Random;
import java.util.Scanner;

public class NameGenerator {
	public Random r = new Random();
	public Scanner sc = new Scanner(System.in);
	public char vowels() {
		String vowel = "aeouiy";
		return vowel.charAt(r.nextInt(vowel.length()));
	}
	
	public char consonants() {
		String consonant = "bcdfghjklmnprstwz";
		return consonant.charAt(r.nextInt(consonant.length()));
	}
	
	
	
	public static void main(String [] args) { 
		NameGenerator ng = new NameGenerator();
		
		System.out.print("How long name you want? ");
		Integer lenght = ng.sc.nextInt();
		String name = ""; 
		for (int i = 0; i < lenght; i++) {
			char letter;
			if(i % 2 == 0) {				
				letter = ng.consonants();
			} else if (i % 3 == 0) {
				letter = ng.vowels();
			} else if (i % 5 == 0) {
				letter = ng.vowels();
			} else {
				letter = ng.vowels();
			}
			name += letter;
		}
		
		String name1 = name.substring(0, 1).toUpperCase() + name.substring(1);
		
		System.out.println("Your new name is: " + name1);
	}
}
