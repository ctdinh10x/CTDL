package BTTL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Scanner;

public class ArrayEquality {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int number_test = sc.nextInt();
        ArrayList<Integer> result = new ArrayList<>();
        while(number_test != 0) {

            int length_chuoi1 = sc.nextInt();
            int length_chuoi2 = sc.nextInt();
            ArrayList<Integer> chuoi1 = new ArrayList<>();
            for(int i = 0;i<length_chuoi1;i++){
                chuoi1.add(sc.nextInt());
            }
            ArrayList<Integer> chuoi2 = new ArrayList<>();
            for(int i = 0;i<length_chuoi2;i++){

                chuoi2.add(sc.nextInt());
            }
            if(chuoi1.equals(chuoi2)) {
                result.add(1);
            }
            else{
                result.add(0);
            }
            number_test--;
        }
        for(int i = 0;i<result.size();i++){
            System.out.println(result.get(i));
        }
    }
}
