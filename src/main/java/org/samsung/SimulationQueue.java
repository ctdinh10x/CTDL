package org.samsung;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class SimulationQueue {
    public static int check(String E) {
        Stack<Character> S = new Stack<>();
        for (int i = 0; i < E.length(); i++) {
            char c = E.charAt(i);
            if (c== '(' || c== '[' || c== '{') {
                S.push(c);
            } else {
                if (S.empty()) {
                    return 0;
                } else {
                    char o = S.pop();
                    if (!match(o, c)) return 0;
                }
            }
        }
        if (S.empty()) return 1;
        else return 0;
    }
    public static boolean match(char o, char c) {
        if (o == '(' && c == ')') return true;
        if (o == '[' && c == ']') return true;
        if (o == '{' && c == '}') return true;
        return false;
    }
    public static void main(String[] args) {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String E = in.readLine();
            int res = check(E);
            System.out.println(res);
            in.close();
        } catch (Exception ex) {}
    }
}

