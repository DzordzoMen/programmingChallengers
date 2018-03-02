package programmingChallenges;

import java.util.Random;
import java.util.Scanner;

public class HigherLower {
	public Scanner sc = new Scanner(System.in);
	public Random rand = new Random();
	
	protected Integer liczba;
	protected Integer moveLenght;
	
	public HigherLower() {
		this.liczba = rand.nextInt(300);
		this.moveLenght = 0;
	}

	
	public String getUserInput() {
		try {
			Integer user = sc.nextInt();
			return checkLiczbe(user);
		} catch(Exception e) {
			sc.next();
			System.out.println("Szanujmy się, podać możesz tylko liczbe :(");
			System.out.print("Spróbuj zgadnąć moją liczbe jeszcze raz.. Oszuście: ");
			return "nope";
		}
	}
	
	public String checkLiczbe(Integer userLiczba) {
		if (userLiczba > liczba) {
			moveLenght++;
			System.out.println("Soreczka, ale moja liczba jest mniejsza od Twojej :/");
			System.out.println("Ogólna liczba prób: "+ moveLenght);
			System.out.print("Spróbuj zgadnąć moją liczbe jeszcze raz: ");
			return "nope";
		} else if (userLiczba < liczba) {
			moveLenght++;
			System.out.println("Przykro mi, ale moja liczba jest większa od Towjej :)");
			System.out.println("Ogólna liczba prób: "+ moveLenght);
			System.out.print("Spróbuj zgadnąć moją liczbe jeszcze raz: ");
			return "nope";
		} else if (userLiczba == liczba || userLiczba.equals(liczba)) {
			moveLenght++;
			System.out.println("Brawo!! Udało Ci się zgadnąć, że moja liczba to: "+ liczba);
			System.out.println("Ogólna liczba podejść wyniosła: "+ moveLenght);
			return "brawo";
		} else {
			System.out.println("Szanujmy się, podać możesz tylko liczbe :(");
			System.out.print("Spróbuj zgadnąć moją liczbe jeszcze raz.. Oszuście: ");
			return "nope";
		}
	}
	
	public static void main(String [] args) { 
		HigherLower hl = new HigherLower();
		String response = "nope";
		System.out.println("Witaj graczu!");
		System.out.println("Co powiesz na pojedynek?");
		System.out.println("Zasady są bardzo proste, musisz zgadnąć jaką wybrałem liczbe");
		System.out.println("Wybrałem liczbe w przedziale 0-300");
		System.out.println();
		
		System.out.println("Zaczynajmy!");
		System.out.print("Wybierz swoją pierwszą liczbe: ");
		while(response == "nope") {
			response = hl.getUserInput();
		}
		System.exit(1);
	}
}

