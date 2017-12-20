package arraysAndStrings;
/*
1.9 String Rotation:Assumeyou have a method isSubstringwhich checks if one word is a substring
of another. Given two strings, sl and s2, write code to check if s2 is a rotation of sl using only one
call to isSubstring (e.g., "waterbottle" is a rotation of"erbottlewat").
Hints: #34, #88, # 7 04
 */
public class StringRotation {
	
	public static void main(String[] args) {
		System.out.println(isSubstring("waterbottlew", "erbottlewwat"));
	}
		
	private static Boolean isSubstring(String s1, String s2) {
		Boolean substring = Boolean.TRUE;
		if(s1.length() != s2.length())
			substring = Boolean.FALSE;
		String concatenated = s1.concat(s2);
		if(concatenated.indexOf(s1) == -1)
			substring = Boolean.FALSE;
		return substring;
	}

}
