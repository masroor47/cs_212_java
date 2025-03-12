import java.io.IOException;

import javax.swing.*;


public class Lab6 {

	public static void main(String[] args) throws IOException {
        
        TextFileInput tfi = new TextFileInput(args[0]);


	
		// String[] wordArray = { "hello", "goodbye", "cat", "dog", "red", "green", "sun", "moon" };
        int[] nums = tfi.returnIntArray();
		System.out.println("length of int array: " + nums.length);
		int total = sum(nums);
		double avg = average(nums);
		
		System.out.println("Sum: " + total);
		System.out.println("Average: " + avg);

		// This line asks the user for input by popping out a single window
		// with text input

	

	} //main

	public static int sum(int[] arr) {
		int sum = 0;
		for (int i: arr) {
			sum += i;
		}
		return sum;
	}

	public static double average(int[] arr) {
		int sum = sum(arr);
		System.out.println("Len of arr is: " + arr.length);

		return 1.0 * sum / arr.length;
	}

} // class Lab4Program1