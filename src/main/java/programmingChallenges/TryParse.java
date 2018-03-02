package programmingChallenges;

public class TryParse {
	
	public static Boolean tryParseInt(String value) {
		try {
			Integer.parseInt(value);
			return true;
		} catch(NumberFormatException e) {
			return false;
		}
	}
	
}
