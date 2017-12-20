package arraysAndStrings;

/*
1.5 One Away: There are three types of edits that can be performed on strings: insert a character,
remove a character, or replace a character. Given two strings, write a function to check if they are
one edit (or zero edits) away.
EXAMPLE
pale, ple -> true
pales, pale -> true
pale, bale -> true
pale, bake -> false
Hints:#23, #97, #130
 */
public class OneAway {

	public static void main(String[] args) {
		System.out.println(isOneAway("pale", "bake"));
	}

	private static Boolean isOneAway(String s1, String s2) {
		int edits = 0, j = 0;
		// Insert Char
		if(s1.length() + 1 == s2.length()){
			for(int i=0; i<s2.length();i++) {
				if(s2.charAt(i) == s1.charAt(j))
					j++;
				else {
					edits++;
					if(edits > 1)
						return Boolean.FALSE;
				}
			}
		}
		// Replace Char
		else if(s1.length() == s2.length()){
			for (int i=0; i<s1.length(); i++) {
				if(s1.charAt(i) != s2.charAt(i)) {
					edits++;
					if(edits > 1)
						return Boolean.FALSE;
				}
			}
		}
		// Remove Char
		else if (s1.length() - 1 == s2.length()) {
			for (int i=0; i<s1.length(); i++) {
				if(j < s2.length() && s1.charAt(i) == s2.charAt(j))
					j++;
				else {
					edits++;
					if(edits > 1)
						return Boolean.FALSE;
				}
			}
		}
		else
			return Boolean.FALSE;
		return Boolean.TRUE;
	}
}
