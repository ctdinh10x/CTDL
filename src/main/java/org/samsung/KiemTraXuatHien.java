package org.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class KiemTraXuatHien {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int number = sc.nextInt();
        sc.nextLine();
        int [] a = new int[number];
        String line = sc.nextLine();
        String [] words = line.split(" ");
        for(int i = 0; i < number; i++) {
            a[i] = Integer.parseInt(words[i]);
        }
        Set<Integer> set = new TreeSet<Integer>();
        for(int i = 0; i < number; i++) {
            if(set.contains(a[i])) {
                System.out.println(1);
            }
            else{
                System.out.println(0);
                set.add(a[i]);
            }
        }

    }
}
