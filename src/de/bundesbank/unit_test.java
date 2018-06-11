/**

@author Niklas Koopmann

*/

package de.bundesbank;

public class unit_test implements PrimeGenerator{

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

	public static boolean checkPrimesInArrayCorrect(int[] primes){

		for(int prime:primes){ // iterate through (generated) primes

			if(!isPrime(prime)){

				return false;
			}
		}

		return true;
	}

	public static void main(String[] args){

		int[] data = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47};

		System.out.println(checkPrimesInArrayCorrect(data) ? "gut" : "schlecht");
	}
}