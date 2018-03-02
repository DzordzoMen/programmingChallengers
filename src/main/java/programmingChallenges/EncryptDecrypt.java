package programmingChallenges;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
//		Fail :(
public class EncryptDecrypt {
	public Scanner scanner = new Scanner(System.in);
	private List<Integer> numberList = new ArrayList<Integer>();
	private String value;
	
	public void addNumber() {
		String result = scanner.nextLine();
		while(TryParse.tryParseInt(result) == false) {
			System.out.print("You can only type a digit: ");
			result = scanner.nextLine();
		}
		Integer number = Integer.parseInt(result);
		numberList.add(number);
	}
	
	public Integer chooseMode() {
		String mode = scanner.nextLine();
		
		while(TryParse.tryParseInt(mode) == false || (!mode.equals("1") && !mode.equals("2")) ) {
			System.out.println("Sorry, but i dont have this kind of mode");
			System.out.println("Try again");
			System.out.println("1 - Encrypting");
			System.out.println("2 - Decrypting");
			System.out.print("Choose wisely: ");
			mode = scanner.nextLine();
		}

		Integer newMode = Integer.parseInt(mode);
		return newMode;
	}
	
	public void setValue(String setValue) {
		this.value = setValue;
	}
	
	public Integer generateNumber() {
		Integer newNumber = numberList.get(1) / numberList.get(0) * numberList.get(2);
		
		if (newNumber > 75) {
			newNumber = newNumber / numberList.get(1);
			
			if (newNumber > 75) {
				newNumber = newNumber / numberList.get(2);
			} else if (newNumber.equals(0)) {
				newNumber = numberList.get(2) / numberList.get(1) * numberList.get(0);
				if (newNumber > 75) {
					newNumber = newNumber / numberList.get(1);
				}
			}
		} else if (newNumber.equals(0)) {
			newNumber = numberList.get(0) / numberList.get(2) * numberList.get(1);
			if (newNumber > 75) {
				newNumber = newNumber / numberList.get(0);
			}
		}
		
		if (newNumber.equals(0)) {
			return 12;
		} else {
			return newNumber;
		}
	}
	
	public void encrypt(Integer newNumber) {

		char[] letters =  value.toCharArray();
		String numericLetters = "";
		for (int i = 0; i < letters.length; i++) {
			numericLetters += (char)((int)letters[i]+newNumber);
		}
		
		System.out.println("Your encrypted message is: " + numericLetters);
	}
	
	public void decrypt(Integer newNumber) {
		
		char[] letters =  value.toCharArray();
		String numericLetters = "";
		for (int i = 0; i < letters.length; i++) {
			numericLetters += (char)((int)letters[i]-newNumber);
		}
		
		System.out.println("Your decrypted message is: "+ numericLetters);
		
	}
	
	public static void main(String [] args) {
		EncryptDecrypt encry = new EncryptDecrypt();
		System.out.println("Welcome in EncryptDecrypt v2.3");
		System.out.println("Choose what you want to do: ");
		System.out.println("1 - Encrypting");
		System.out.println("2 - Decrypting");
		System.out.print("Wybrany tryb: ");
		Integer result = encry.chooseMode();
		
		if (result.equals(1)) {
			System.out.println("It's time to choose digits which i will encrypt your message");
			System.out.print("First row: ");
			encry.addNumber();
			System.out.print("Second row: ");
			encry.addNumber();
			System.out.print("Third row: ");
			encry.addNumber();
			System.out.print("Now type your message to encrypt: ");
			encry.setValue(encry.scanner.nextLine());
			
			encry.encrypt(encry.generateNumber());
		} else if (result.equals(2)) {
			System.out.println("Here you need to type your digits what you use to encypt message");
			System.out.print("First row: ");
			encry.addNumber();
			System.out.print("Second row: ");
			encry.addNumber();
			System.out.print("Third row: ");
			encry.addNumber();
			System.out.print("Now type code what you get after encrypting: ");
			encry.setValue(encry.scanner.nextLine());
			
			encry.decrypt(encry.generateNumber());
		}
		
	}
}
