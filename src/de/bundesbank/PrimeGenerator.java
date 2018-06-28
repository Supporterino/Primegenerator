
package de.bundesbank;

// Interface for prime number generator

public interface PrimeGenerator {

    int[] calculate_Primes();
    void setBorder(int x);
    int getBorder();
}