package org.samsung;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Stack;

public class SimulationStack {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Stack<>();
        while(true){
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String line = br.readLine();
            if(line.equals("#")){
                break;
            }
            ArrayList<Integer> list = new ArrayList<>();
            String [] tokens = line.split(" ");
            switch(tokens[0]){
                case "PUSH":
                    list.add(stack.push(Integer.parseInt(tokens[1])));
                    break;
                case "POP":
                    System.out.println(stack.pop());
                    break;
            }
            for(int i=0;i<list.size();i++){
                System.out.println(list.get(i));
            }
        }
    }
}
