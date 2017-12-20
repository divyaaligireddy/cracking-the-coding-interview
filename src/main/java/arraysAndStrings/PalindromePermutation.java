package arraysAndStrings;

import java.util.HashMap;
import java.util.Map;
/*
 1.4 Palindrome Permutation: Given a string, write a function to check if it is a permutation of a palindrome.
A palindrome is a word or phrase that is the same forwards and backwards. A permutation
is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words.
EXAMPLE
Input: Tact Coa
Output: True (permutations: "taco cat", "atco eta", etc.)
Hints: #106, #121, #134, #136
 */
public class PalindromePermutation {

	public static void main(String[] args) {
		System.out.println(checkPalindromePermutation("Tact Coa".toLowerCase()));
	}

	private static Boolean checkPalindromePermutation(String s) {
		Map<Character, Integer> map = new HashMap<>();
		for(int i = 0; i < s.length(); i++) {
			char ch = s.charAt(i);
			if(ch != ' '){
				if (map.get(ch) != null) {
					int count = map.get(ch);
					map.put(ch, count+1);
				} else
					map.put(ch, 1);
			}
		}
		int isPP = 0;
		for (Integer val : map.values()) {
			if(val % 2 != 0){
				isPP++;
				if(isPP > 1)
					return Boolean.FALSE;
			}
		}
		return Boolean.TRUE;
	}
}
