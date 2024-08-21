package BTTL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class BasicQueriesOnArray {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();
        int request_number = Integer.parseInt(line);
        String []arr = br.readLine().split(" ");
        ArrayList<Integer> arr_number = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < request_number; i++) {
            arr_number.add(Integer.parseInt(arr[i]));
        }
        while (true) {
            String[] request = br.readLine().trim().split(" ");
            if(request[0].equals("***")) {break;}
            switch (request[0]) {
                case "find-max":
//                    ArrayList<Integer> temp = new ArrayList<>(arr_number);
//                    temp.sort(null);
//                    result.add(arr_number.get(arr_number.size() - 1));
                    result.add(Collections.max(arr_number));
                    break;
                case "find-min":
//                    ArrayList<Integer> temp1 = new ArrayList<>(arr_number);
//                    temp1.sort(null);
//                    result.add(arr_number.get(0));
                    result.add(Collections.min(arr_number));
                    break;
                case "find-max-segment":
                    int n = Integer.parseInt(request[1]);
                    int m = Integer.parseInt(request[2]);
                    int max = arr_number.get(0);
                    ArrayList<Integer> temp3 = new ArrayList<>();
                    for (int i = n-1; i < m; i++) {
                        temp3.add(arr_number.get(i));
                    }

                    result.add(Collections.max(temp3));
                    break;
                case "sum":
                    int sum = 0;
                    for (int i = 0; i < arr_number.size(); i++) {
                        sum += arr_number.get(i);
                    }
                    result.add(sum);
                    break;
                case "*":
                    continue;
            }

        }
        for (int i = 0; i < result.size(); i++) {
            System.out.println(result.get(i));
        }
    }
}
