package others;

import java.util.Scanner;

public class ArmstrongNumber {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter a number: ");
		String input = scanner.nextLine().trim();
		scanner.close();
		int digits = input.length();
		Integer n = Integer.valueOf(input);
		System.out.println("Is " + input + " an Armstring Number? " + findIfArmstrong(n, digits));
	}

	private static Boolean findIfArmstrong(Integer n, int digits) {
		Double result = 0.0;
		int remainder = 0, number = n;
		while (number != 0) {
			remainder = number % 10;
			result += Math.pow(remainder, digits);
			number = number / 10;
		}
		return n.equals(result.intValue());
	}

}
