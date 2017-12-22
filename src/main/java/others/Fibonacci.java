package others;

import java.util.Scanner;

public class Fibonacci {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter number of digits to print in Fibonacci series: ");
		String n = scanner.nextLine();
		scanner.close();
		withRecusion(n);
		withoutRecusion(n);
	}

	private static void withRecusion(String n) {
		System.out.println("Fibonacci series upto " + n + " numbers with recursion: ");
		for (int i = 0; i < Integer.valueOf(n); i++) {
			System.out.print(fib(i) + "  ");
		}
	}

	private static int fib(int i) {
		if (i < 0)
			return 0;

		else if (i == 0)
			return 1;
		else
			return fib(i - 1) + fib(i - 2);

	}

	private static void withoutRecusion(String n) {
		System.out.println("\nFibonacci series upto " + n + " numbers without recursion: ");
		int fib1 = 1, fib2 = 1, temp = 0;
		System.out.print(fib1 + "  " + fib2 + " ");
		for (int i = 3; i <= Integer.valueOf(n); i++) {
			temp = fib2;
			fib2 = temp + fib1;
			fib1 = temp;
			System.out.print(fib2 + "  ");
		}

	}
}
