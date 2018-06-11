/**

@author Niklas Koopmann

*/

package de.bundesbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import de.bundesbank.*;

public class UnitTest {

	// prime check for single number
	public static boolean isPrime(int prime){

		System.out.println("Teste angebliche Primzahl " + prime + ":");

		if(prime < 2) return false;
		if(prime == 2) return true;
		if(prime % 2 == 0) return false;

		System.out.println("	Schleife betreten (Zahl ist ungerade und groesser als zwei).");
		
		for(int i = 3; i < prime; i += 2){

			System.out.println("	Division durch " + i + "...");

			if(prime % i == 0) return false;
		}

		System.out.println("Schleife verlassen. Zahl ist prim.");

		return true;
	}

	// check every prime number in an array
	public static boolean checkPrimesInArrayCorrect(int[] primes){

		for(int prime:primes){ // iterate through (generated) primes

			if(!isPrime(prime)){

				return false;
			}
		}

		return true;
	}

	// random numbers in list with "size" elements
	public static List<Integer> generateTestList(int size){

		List<Integer> testlist = new ArrayList<Integer>();

		for(int i = 0; i < size; i++){

			testlist.add((int)((Math.random() - 0.5) * 2 * Integer.MAX_VALUE));
		}

		return testlist;
	}
}