/**

@author Niklas Koopmann

Unit test for a Prime Number Generator using Sieve of Eratosthenes.

Tests include:

- checking generated prime numbers
	- checking whether a single number is prime
	- prime-checking all ints in an array using above method to check numbers generated by the algorithm. The first 1.000 primes are generated and thoroughly checked. For more numbers the algorithm would take too much time.

- checking conversion from list to array
	- generating a List of random Integers in whole int range, by default with 100.000 elements
	- comparing the List of Integers to an int array (element-wise)

- checking getter and setter method
	- getting and setting the Border value in a Solver object, by default with 100.000 random numbers in whole int range

- calculating the total time it took for all tests to be performed

*/

package de.bundesbank;

// imports
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;
import java.util.Date;

public class UnitTest {

	// run all tests
	public static int runTests(){

		// measuring time taken for tests (partially for performance monitoring)
		Date start = new Date();

		int testsPassed = 0;

		Solver testSolver = new Solver();

		// test data for list-array-conversion:
		int testCasesListArray = 100000;
		List<Integer> testList = generateTestList(testCasesListArray);

		// convert using function
		int[] arrayFromList = testSolver.ListConversion(testList);

		// compare array to list and increment counter
		if(compareListToArray(testList, arrayFromList)){

			System.out.println("Testing of ListConversion(List<Integer>) successful.");
			testsPassed++;

		}else System.out.println("WARNING! Testing of ListConversion(List<Integer>) failed.");

		// run test for getter and setter method
		if(testGetterAndSetter(testSolver)){

			System.out.println("Testing of getBorder() and setBorder(int) successful.");
			testsPassed++;

		}else System.out.println("WARNING! Testing of getBorder() and setBorder(int) failed.");

		// run test for consistency of generated primes
		testSolver.setBorder(1000);
		System.out.println("Border set.");

		// check integrity of primes in generated array
		if(checkPrimesInArrayCorrect(testSolver.calculate_Primes())){

			System.out.println("Testing of calculate_Primes() successful.");
			testsPassed++;

		}else System.out.println("WARNING! Testing of calculate_Primes() failed. At least 1 generated number was not prime!");

		Date end = new Date();
		long intvl = end.getTime() - start.getTime();
		System.out.println("Tests completed. Time taken: " + intvl/1000.0 + " s");

		return testsPassed;
	}


	// prime check for single number
	// @Test
	public static boolean isPrime(int prime){

		System.out.println("Testing alleged prime number " + prime + ":");

		// defined prime numbers
		if(prime < 2) return false;
		if(prime == 2) return true;

		// filter out multiples of 2 (even numbers) for better performance
		if(prime % 2 == 0) return false;

		System.out.println("	Loop entered (number is odd and greater than 2).");
		
		// try division with every odd number smaller than alleged prime
		for(int i = 3; i < prime; i += 2){

			// shitload of outputs
			System.out.println("	Division by " + i + "...");

			// If the alleged prime is divisible by current number, it is not prime.
			if(prime % i == 0) return false;
		}

		System.out.println("Loop exited. Number is prime.");

		return true;
	}

	// check every prime number in an array
	// @Test
	public static boolean checkPrimesInArrayCorrect(int[] primes){

		System.out.println("Testing primes in array...");

		// iterate through (generated) primes
		for(int prime:primes){ 

			// error if alleged prime is not a real prime according to definition
			if(!isPrime(prime)){

				System.out.println("Error at generated prime " + prime + "! Not a prime number!");

				return false;
			}
		}

		return true;
	}

	// random numbers in list with "size" elements
	// @Test
	public static List<Integer> generateTestList(int size){

		List<Integer> testlist = new ArrayList<Integer>();

		// fill list with random numbers 
		for(int i = 0; i < size; i++){

			testlist.add((int)((Math.random() - 0.5) * 2 * Integer.MAX_VALUE));
		}

		return testlist;
	}

	// compare each element in list to corresponding element in array
	// @Test
	public static boolean compareListToArray(List<Integer> list, int[] arr){

		// iterate through array and ...
		for(int i = 0; i < arr.length; i ++){

			// ... compare each item in the list to the one at the same index in the array
			if(list.get(i) != arr[i]){

				System.out.println("Error comparing list to array at index " + i + " with number\n in array " + arr[i] + "\n in list " + list.get(i));

				return false;
			}

			// shitload of console prints
			System.out.println("Element at index " + i + " in array tested successfully.");
		}

		return true;
	}

	// testing getter and setter
	// @Test
	public static boolean testGetterAndSetter(Solver testSetterSolver){

		// test getting and setting with 100000 random numbers
		// also shitload of outputs
		for(int i = 0; i < 100000; i++){

		 	int testInt = (int)((Math.random() - 0.5) * 2 * Integer.MAX_VALUE);

		 	System.out.print("Setting Border to number " + testInt + "... ");

		 	testSetterSolver.setBorder(testInt);

		 	System.out.print("Border set.\n");

		 	// error if gotten number is unequal to set number
			if(Math.abs(testInt) != testSetterSolver.getBorder()){

				System.out.println("Error setting and re-getting Border with number " + testSetterSolver.getBorder() + "!");

				return false;
			}
		}

		return true;
	}
}