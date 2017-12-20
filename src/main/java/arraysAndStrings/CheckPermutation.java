package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;

public class CheckPermutation {

/*
 * 1.2 Check Permutation: Given two strings, write a method to decide if one is a permutation of the
other.
Hints: #7, #84, #722, #737
 */
	public static void main(String[] args) {
		System.out.println(checkPermutationWithArrays("BALL", "ALBL"));
		System.out.println(checkPermutationWithMap("BALL", "ALBL"));
	}

	private static Boolean checkPermutationWithArrays(String string1, String string2) {
		Boolean isPermutation = Boolean.TRUE;
		if(string1.length() != string2.length()) {
			isPermutation = Boolean.FALSE;
		}
		int[] charset = new int[256];
		for (int i = 0; i < string1.length(); i++)
			charset[string1.charAt(i)]++;
		for (int i = 0; i < string2.length(); i++) {
			if(--charset[string2.charAt(i)] < 0)
				isPermutation = Boolean.FALSE;
		}
	return isPermutation;
}

	private static Boolean checkPermutationWithMap(String string1, String string2) {
		if(string1.length() != string2.length())
			return Boolean.FALSE;
		else {
			Map<Character, Integer> map1 = buildMap(string1);
			Map<Character, Integer> map2 = buildMap(string2);
			for (Character c: map1.keySet()) {
				if(!(map1.get(c) == map2.get(c)))
					return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}

	private static Map<Character, Integer> buildMap(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i<s.length(); i++) {
			char ch = s.charAt(i);
			if (map.get(ch) != null) {
				int count = map.get(ch);
				map.put(ch, count + 1);
			}
			else
				map.put(ch, 1);
		}
		return map;
	}
}
