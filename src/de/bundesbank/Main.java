package de.bundesbank;

import javax.swing.border.Border;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static java.lang.Math.sqrt;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Solver solve = new Solver();

        System.out.println("Geben Sie die obere Grenze an");
        String eingabe = sc.next();
        int border = Integer.parseInt(eingabe);
        solve.setBorder(border);
        System.out.println(solve.getBorder());
        int[] primenumbers = solve.calculate_Primes();
        System.out.println("Primzahlen:" + Arrays.toString(primenumbers));
    }
}

interface PrimeGenerator {
    int[] calculate_Primes();
    void setBorder(int x);
    int getBorder();
}

class Solver implements PrimeGenerator {

    private int Border;

    @Override
    public int[] calculate_Primes() {
        boolean[] gestrichen = new boolean[Border];
        List<Integer> primes = new ArrayList<>();
        int sqrt_Border = (int)sqrt(Border);

        for (int i = 2; i < sqrt_Border; i++) {
                for(int j = i; j < Border; j++) {
                    if(j!=i){
                        if(j%i == 0){
                            gestrichen[j] = true;
                        }
                    }
                }
        }
        for(int k = 1; k < Border; k++) {

            if (!gestrichen[k]) {

                primes.add(k);

            }

        }

        int[] Primes_out = ListConversion(primes);
        return Primes_out;
    }

    private int[] ListConversion(List<Integer> input){
        int size = input.size();
        System.out.println(size);
        int[] output = new int[size];
        Integer[] temp = input.toArray(new Integer[size]);
        for (int i = 0; i < size; i++) {
            output[i] = temp[i];
        }
        return output;
    }

    @Override
    public void setBorder(int x) {
        this.Border = x;
    }

    @Override
    public int getBorder() {
        return Border;
    }
}
