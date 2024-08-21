package org.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class AnalyzeOdersRaisedOverTimes {
    public static int hash(String t) {
        int h = Integer.parseInt(t.split(":")[0]);
        int m = Integer.parseInt(t.split(":")[1]);
        int s = Integer.parseInt(t.split(":")[2]);

        return h * 3600 + m * 60 + s;
    }
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String line = in.readLine();
            List<Order> orders = new ArrayList<>();
            int M = 23 * 3600 + 59 * 60 + 59; // max of hh:mm:ss
            int[] a = new int[M + 1];
            int[] t = new int[M + 1];

            for (int i = 1; i <= M; i++) a[i] = 0;

            while (!line.equals("#")) {
                String[] s = line.split(" ");
                orders.add(new Order(s[0], s[1]));
                a[hash(s[1])]++;

                line = in.readLine();
            }

            // compute prefix sum t
            t[0] = a[0];
            for (int i = 1; i <= M; i++) t[i] = t[i - 1] + a[i];

            // handler get condition and print
            while (!line.equals("###")) {
                String[] s = line.split(" ");
                if (s[0].equals("?number_orders")) {
                    System.out.println(orders.size());
                } else if (s[0].equals("?number_orders_in_period")) {
                    int i = hash(s[1]);
                    int j = hash(s[2]);
                    int cnt = t[j];
                    if (i > 0) cnt = t[j] - t[i - 1];
                    System.out.println(cnt);
                } else if (s[0].equals("?number_orders_at_time")) {
                    int i = hash(s[1]);
                    int cnt = a[i];
                    System.out.println(cnt);
                }

                line = in.readLine();
            }
        } catch (IOException ex) {
        }
    }
}

class Order {
    public Order(String orderId, String orderDate) {
        this.orderId = orderId;
        this.orderDate = orderDate;
    }

    public String orderId;
    public String orderDate;
}