package String;

public class reverseWords_in_a_String {
	public String reverseWords(String s) {
		// write your code
		if (s == null || s.length() == 0) {
			return s;
		}
		String[] words = s.split("\\s+");
		StringBuilder sb = new StringBuilder();
		for (int i = words.length - 1; i > 0; i--) {
			sb.append(words[i]);
			sb.append("  ");
		}
		sb.append(words[0]);
		return sb.toString();
	}

	public static void main(String[] args) {
		reverseWords_in_a_String test = new reverseWords_in_a_String();
		String s = "How are   you?";
		String t = new String("      ");
		
		System.out.println(test.reverseWords(s));
	}

}
