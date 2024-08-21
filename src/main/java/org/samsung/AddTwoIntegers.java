package org.samsung;

import java.util.Scanner;

public class AddTwoIntegers {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        long number1 = in.nextInt();
        long number2 = in.nextInt();
        System.out.println(number1+number2);
    }
}
