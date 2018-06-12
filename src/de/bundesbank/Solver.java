/**
    @author Lars Roth
*/

package de.bundesbank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.*;

public class Solver implements PrimeGenerator {

    private int Border;

    public int[] calculate_Primes() {
        boolean[] isPrime = new boolean[Border];
        List<Integer> primes = new ArrayList<>();
        int sqrt_Border = (int)sqrt(Border);

//        for (int i = 2; i < sqrt_Border; i++) {
//                for(int j = i; j < Border; j++) {
//                    if(j!=i){
//                        if(j%i == 0){
//                            gestrichen[j] = true;
//                        }
//                    }
//                }
//        }
//        for(int k = 2; k < Border; k++) {
//
//            if (!gestrichen[k]) {
//
//                primes.add(k);
//
//            }
//
//        }
        for (int i = 0; i < sqrt_Border; i++) {
            isPrime[i] = true;
        }

        for (int i = 2; i <= sqrt_Border; i++) {
            if(isPrime[i]){
                for (int j = i * i; j < sqrt_Border; j += i) {
                    isPrime[j] = false;
                }
            }
        }

        for (int k = 2; k < sqrt_Border; k++) {
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

    // fixed: absolute value of border .NK
    public void setBorder(int x) {
        this.Border = abs(x);
    }

    public int getBorder() {
        return Border;
    }
}