/**
    @author Lars Roth
*/

package de.bundesbank;

import java.util.ArrayList;
import java.util.List;

import static java.lang.Math.*;

public class Solver implements PrimeGenerator {

    private int Border;

    public int[] calculate_Primes() {
        boolean[] isPrime = new boolean[Border];
        List<Integer> primes = new ArrayList<>();
        int sqrt_Border = (int)sqrt(Border);

        for (int i = 0; i < Border; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= sqrt_Border; i++) {
            if(isPrime[i]){
                for (int j = i * i; j < Border; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int k = 2; k < Border; k++) {
            if(isPrime[k]) {
                primes.add(k);
            }
        }


        return ListConversion(primes);
    }

    public int[] ListConversion(List<Integer> input){
        int size = input.size();
        int[] output = new int[size];
        Integer[] temp = input.toArray(new Integer[size]);
        for (int i = 0; i < size; i++) {
            output[i] = temp[i];
        }
        return output;
    }

    public void setBorder(int x) {
        this.Border = abs(x);
    }

    public int getBorder() {
        return Border;
    }
}