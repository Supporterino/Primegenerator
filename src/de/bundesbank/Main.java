/**
    @author Lars Roth
*/

package de.bundesbank;

import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) {

        /**
            running unit tests
            @author Niklas Koopmann
        */

        int passedTests = UnitTest.runTests();

        System.out.println("Tests passed: " + passedTests + "/3");

        /**
            main routine
            @author Lars Roth
        */

        // setup scanner
        Scanner sc = new Scanner(System.in);
        Solver solve = new Solver();
        int border = 0;

        // input border and catch wrong inputs
        do {
            try {
                System.out.println("Geben Sie die obere Grenze an");
                border = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Keine gültige Zahl eingegeben! Exception: " + e);
            }
            sc.nextLine(); // clears the buffer

        // repeat input if input incorrect
        } while (border <= 0);


        solve.setBorder(border);

        // calculate primes, output array and catch exception if insufficient memory was supplied
        try{
            int[] primenumbers = solve.calculate_Primes();
            System.out.println("Primzahlen:" + Arrays.toString(primenumbers));
        } catch(OutOfMemoryError E){
            System.out.println("Der Arbeitsspeicher reicht zur Berechnung nicht aus. Versuchen Sie java -Xmx4096m de.bundesbank.Main. Error: " + E);
        }
    }
}