/**

@author Niklas Koopmann

*/

package de.bundesbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.lang.Math;

import java.util.Date;

public class UnitTest {

	// run all tests
	public static int runTests(){

		// measuring time taken for tests (partially DEBUG)
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

		if(checkPrimesInArrayCorrect(testSolver.calculate_Primes())){

			System.out.println("Testing of calculate_Primes() successful.");
			testsPassed++;

		}else System.out.println("WARNING! Testing of calculate_Primes() failed. At least 1 generated number was not prime!");

		System.out.println("Tests ran.");

		Date end = new Date();
		long intvl = end.getTime() - start.getTime();
		System.out.println("Time taken: " + intvl/1000.0 + " s");

		return testsPassed;
	}


	// prime check for single number
	//@Test
	public static boolean isPrime(int prime){

		System.out.println("Testing alleged prime number " + prime + ":");

		if(prime < 2) return false;
		if(prime == 2) return true;
		if(prime % 2 == 0) return false;

		System.out.println("	Loop entered (number is odd and greater than 2).");
		
		for(int i = 3; i < prime; i += 2){

			System.out.println("	Division by " + i + "...");

			if(prime % i == 0) return false;
		}

		System.out.println("Loop exited. Number is prime.");

		return true;
	}

	// check every prime number in an array
	//@Test
	public static boolean checkPrimesInArrayCorrect(int[] primes){

		System.out.println("Testing primes in array...");

		for(int prime:primes){ // iterate through (generated) primes

			if(!isPrime(prime)){

				System.out.println("Error at generated prime " + prime + "! Not a prime number!");

				return false;
			}
		}

		return true;
	}

	// random numbers in list with "size" elements
	//@Test
	public static List<Integer> generateTestList(int size){

		List<Integer> testlist = new ArrayList<Integer>();

		for(int i = 0; i < size; i++){

			testlist.add((int)((Math.random() - 0.5) * 2 * Integer.MAX_VALUE));
		}

		return testlist;
	}

	// compare each element in list to corresponding element in array
	//@Test
	public static boolean compareListToArray(List<Integer> list, int[] arr){

		for(int i = 0; i < arr.length; i ++){

			if(list.get(i) != arr[i]){

				System.out.println("Error comparing list to array at index " + i + " with number\n in array " + arr[i] + "\n in list " + list.get(i));

				return false;
			}
		}

		return true;
	}

	// testing getter and setter
	//@Test
	public static boolean testGetterAndSetter(Solver testSetterSolver){

		for(int i = 0; i < 100000; i++){

		 	int testInt = (int)((Math.random() - 0.5) * 2 * Integer.MAX_VALUE);

		 	System.out.println("Setting Border to number " + testInt + "...");

		 	testSetterSolver.setBorder(testInt);

		 	System.out.println("Border set.");

			if(Math.abs(testInt) != testSetterSolver.getBorder()){

				System.out.println("Error setting and re-getting Border with number " + testSetterSolver.getBorder() + "!");

				return false;
			}
		}

		return true;
	}
}