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
        Scanner sc = new Scanner(System.in);
        Solver solve = new Solver();
        int border = 0;

        do {
            try {
                System.out.println("Geben Sie die obere Grenze an");
                border = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Keine gültige Zahl eingegeben");
            }
            sc.nextLine(); // clears the buffer
        } while (border <= 0);


        solve.setBorder(border);
        int[] primenumbers = solve.calculate_Primes();
        System.out.println("Primzahlen:" + Arrays.toString(primenumbers));
    }
}