package arraysAndStrings;

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
		algorithmToConvertToUrlifyUsingCharArray("Mr John Smith    ", 13);
		algorithmToConvertToUrlUsingStringBuilder("Mr John Smith   ", 13);
	}

	private static void algorithmToConvertToUrlifyUsingCharArray(String string, int trueLength) {
		char[] str = string.toCharArray();
		int spaces = 0;
		for (int i = 0; i < trueLength; i++) {
			if (str[i] == ' ') {
				spaces++;
			}
		}
		int urlLength = trueLength + spaces * 2;
		for (int i = trueLength - 1; i >= 0; i--) {
			if (str[i] != ' ')
				str[--urlLength] = str[i];
			else {
				str[--urlLength] = '0';
				str[--urlLength] = '2';
				str[--urlLength] = '%';
			}
		}
		System.out.print("Urlify using char array: ");
		for (char c : str) {
			System.out.print(c);
		}
	}

	private static void algorithmToConvertToUrlUsingStringBuilder(String s, int len) {
		StringBuilder url = new StringBuilder();
		for (int i = 0; i < len; i++) {
			if (s.charAt(i) != ' ') {
				url.append(s.charAt(i));
			} else {
				url.append("%20");
			}
		}
		System.out.println("\nUrlify using StringBuilder: " + url.toString());
	}
}
