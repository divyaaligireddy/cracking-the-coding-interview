package arraysAndStrings;

import java.util.ArrayList;
import java.util.List;
/*
1.3 URLify: Write a method to replace all spaces in a string with '%20'. You may assume that the string
has sufficient space at the end to hold the additional characters, and that you are given the "true"
length of the string. (Note: If implementing in Java, please use a character array so that you can
perform this operation in place.)
EXAMPLE
Input: "Mr John Smith ", 13
Output: "Mr%20John%20Smith"
Hints: #53, # 118
 */
public class URLify {

	public static void main(String[] args) {
		algorithmToConvertToUrl("Mr John Smith   ", 13);
	}

	private static void algorithmToConvertToUrl(String s, int len) {
		List<Character> chars = new ArrayList<Character>();
		for (int i = 0; i < len; i++) {
			if(s.charAt(i) != ' ') {
				chars.add(s.charAt(i));
			} else {
				chars.add('%');
				chars.add('2');
				chars.add('0');
			}
		}
		for (Character character : chars) {
			System.out.print(character);
		}
	}
}
