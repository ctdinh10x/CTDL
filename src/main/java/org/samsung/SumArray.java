package org.samsung;

import java.util.Scanner;

public class SumArray {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        long sum = 0;
        for(int i = 1; i <= number; i++) {
            int num = sc.nextInt();
            sum+=num;
        }
        System.out.println(sum);
    }
}
