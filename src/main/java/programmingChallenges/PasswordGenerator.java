package programmingChallenges;

import java.util.Random;
import java.util.Scanner;

public class PasswordGenerator {
	public Scanner scan = new Scanner(System.in);
	public Random rand = new Random();
	
	public Integer passwordLenght() {
		String length = scan.nextLine();
		
		while(TryParse.tryParseInt(length) == false || Integer.parseInt(length) < 15) {
			System.out.println("Minimum password lenght is 15");
			System.out.print("Only digits please: ");
			length = scan.nextLine();
		}
		
		return Integer.parseInt(length);
	}

	public Character generateChar() {
		String smallLetters = "abcudefghijklmnopqrstwvxyz";
		String largeLetters = smallLetters.toUpperCase();
		String numbers = "1234567890";
		String symbols = "[]{}();:!@#$%^&*?=-_+`~";
		
		String all = smallLetters + largeLetters + numbers + symbols;
		
		return all.charAt(rand.nextInt(all.length()));
	}
	
	public static void main(String[] args) {
		PasswordGenerator genPass = new PasswordGenerator();
		System.out.println("Welcome in the password generator :)");
		System.out.print("Now you need to tell me how long password you want, remember min length is 15: ");
		Integer passLength = genPass.passwordLenght();
		String password = "";
		for (int i = 0; i < passLength; i++) {
			password += genPass.generateChar();
		}
		
		System.out.println("Your new safety password is: " + password);
	}

}
