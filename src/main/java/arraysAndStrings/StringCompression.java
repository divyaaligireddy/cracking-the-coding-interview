package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;

/*
1.6 String Compression: Implement a method to perform basic string compression using the counts
of repeated characters. For example, the string aabcccccaaa would become a2blc5a3. If the
"compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).
Hints:#92, #110
 */
public class StringCompression {

	public static void main(String[] args) {
		System.out.println("String compression is: " + compressString("aabcccccaaa"));
	}

	private static String compressString(String s1) {
		List<String> compressed = new ArrayList<>();
		Integer count = 0;
		for (int i=0; i<s1.length(); i++) {
			if(compressed.size() == 0) {
				compressed.add(String.valueOf(s1.charAt(i)));
				count++;
			}
			else if (compressed.get(compressed.size() - 1).equals(String.valueOf(s1.charAt(i))))
				count++;
			else {
				compressed.add(String.valueOf(count));
				compressed.add(String.valueOf(s1.charAt(i)));
				count = 1;
			}
		}
		compressed.add(String.valueOf(count));
		if(s1.length() == compressed.size()/2)
			return s1;
		
		return compressed.toString();
	}
	
}
