package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

/*
 * 1.1 Is Unique: Implement an algorithm to determine if a string has all unique characters. What if you
cannot use additional data structures?
Hints: #44, #7 7 7, #732
 */

public class IsUnique {

	public static Boolean isUniqueWithoutDataStructures(String s) {
		Boolean isUnique = Boolean.TRUE;
		if (s.length() > 256)
			isUnique = Boolean.FALSE;
		else {
			Boolean[] b = new Boolean[256];
			for (int i = 0; i < s.length(); i++) {
				if (b[s.charAt(i)] == Boolean.TRUE) {
					isUnique = Boolean.FALSE;
					break;
				} else
					b[s.charAt(i)] = Boolean.TRUE;
			}
		}
		return isUnique;
	}

	public static Boolean isUniqueWithMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for (int i = 0; i < s.length(); i++) {
			if (map.get(s.charAt(i)) != null)
				return Boolean.FALSE;
			else
				map.put(s.charAt(i), 1);
		}
		return Boolean.TRUE;
	}

	public static void main(String[] args) {
		System.out.println(isUniqueWithoutDataStructures("divya"));
		System.out.println(isUniqueWithMap("divya"));
	}
}
