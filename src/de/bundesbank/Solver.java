/**
    @author Lars Roth

    to do: allgemeine Funktionsweise des Algorithmus beschreiben
*/

package de.bundesbank;

// imports
import java.util.ArrayList;
import java.util.List;
import static java.lang.Math.*;

public class Solver implements PrimeGenerator {

    private int Border;

    // calculate primes up to border in list and convert before returning
    public int[] calculate_Primes() {

        // define local variables
        boolean[] isPrime = new boolean[Border];
        List<Integer> primes = new ArrayList<>();
        int sqrt_Border = (int)sqrt(Border);

        // init array with trues
        for (int i = 0; i < Border; i++) {
            isPrime[i] = true;
        }

        // iterate through array up to the sqrt of border 
        for (int i = 2; i <= sqrt_Border; i++) {

            if(isPrime[i]){

                // to do: was zum fick?
                for (int j = i * i; j < Border; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        // add all remaining prime numbers to list of primes
        for (int k = 2; k < Border; k++) {
            if(isPrime[k]) {
                primes.add(k);
            }
        }

        return ListConversion(primes);
    }

    // convert list to array
    public int[] ListConversion(List<Integer> input){

        int size = input.size();
        int[] output = new int[size];
        Integer[] temp = input.toArray(new Integer[size]);
        
        // copy each element of temp to output
        for (int i = 0; i < size; i++) {
            output[i] = temp[i];
        }
        return output;
    }

    // setter for border value
    public void setBorder(int x) {
        this.Border = abs(x);
    }

    // getter for border value
    public int getBorder() {
        return Border;
    }
}