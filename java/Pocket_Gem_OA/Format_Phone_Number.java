package Pocket_Gem_OA;

public class Format_Phone_Number {

	/**
	 * Normalize a given phone number.
	 *
	 * This method declaration must be kept unmodified.
	 *
	 * @param String
	 *            telephoneNumber: A string containing a phone number.
	 * @return String with the normalized phone number if the input phone is
	 *         valid, or '' otherwise.
	 *         ex: 650-121-1234
	 */
	public static String standardizeTelephoneNumber(String telephoneNumber) {
		// Write your implementation here
		StringBuilder sb = new StringBuilder();
		int count = 0;
		for(char s : telephoneNumber.toCharArray()) {
			if(s < '0' || s >'9') {
				continue;
			}
			++count;
			sb.append(s);
			if(count == 3 || count == 6) {
				sb.append('-');
			}
			if(count == 10){
				break;
				
			}
		}
		
//		return sb.length() == 12? sb.toString() :"Not implemented";
		return count == 10? sb.toString() :"Not implemented";
		
	}

	// This tests your code with the examples given in the question,
	// and is provided only for your convenience.
	public static void main(String[] args) {
		String[] phoneNumbers = { "(650) 555-1234", "65.0555.1234",
				"65/05/5512/34", "(650) 555-1234 x111", "(650) 555-123" };
		for (String telephoneNumber : phoneNumbers) {
			System.out.println(standardizeTelephoneNumber(telephoneNumber));
		}
	}
}
