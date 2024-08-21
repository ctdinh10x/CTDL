package BTTL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AnalyzeSalesCompany {

    public static int getTimeMinutes(String time){
        String []arr = time.split(":");
        int hours = Integer.parseInt(arr[0]);
        int minutes = Integer.parseInt(arr[1]);
        return hours * 60 + minutes;
    }

    public static void main(String[] args) throws IOException {
        int order_amout = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String create = br.readLine();
        ArrayList<ArrayList<String>> listOrder = new ArrayList<>();
        ArrayList<Integer> result = new ArrayList<>();
        while(!create.equals("#")){
            String[] order = br.readLine().split(" ");
            ArrayList<String> list = new ArrayList<>();
            for(int i = 0; i < order.length; i++){
                list.add(order[i]);
            }
            listOrder.add(list);
            order_amout++;
        }
        String[] request = br.readLine().split(" ");
        switch(request[0]){
            case "?total_number_orders":
                result.add(order_amout);
                break;
            case "?total_revenue":
                int sum = 0;
                for(int i = 0; i < order_amout; i++){
                    sum+=Integer.parseInt(listOrder.get(i).get(2));
                }
                result.add(sum);
                break;
            case "?revenue_of_shop SHOP001":
                int sum1 = 0;
                for(int i = 0; i < order_amout; i++){
                    if(listOrder.get(i).get(3).contains(request[1])){
                        sum1+=Integer.parseInt(listOrder.get(i).get(2));
                    }
                }
                result.add(sum1);
                break;
            case "?total_consume_of_customer_shop":
                int sum2 = 0;
                for(int i = 0; i < order_amout; i++){
                    if(listOrder.get(i).get(3).contains(request[1]) && listOrder.get(i).get(0).contains(request[2])){
                        sum2+=Integer.parseInt(listOrder.get(i).get(2));
                    }
                }
                result.add(sum2);
                break;
            case "?total_revenue_in_period":
                int sum3 = 0;
                int timestart = getTimeMinutes(request[1]);
                int timeend = getTimeMinutes(request[2]);
                for(int i = 0; i < order_amout; i++){
                    if(getTimeMinutes(listOrder.get(i).get(4)) >= timestart && getTimeMinutes(listOrder.get(i).get(4)) <= timeend){
                        sum3+=Integer.parseInt(listOrder.get(i).get(2));
                    }
                }
                result.add(sum3);
                break;
        }
        for(int i = 0; i < result.size(); i++){
            System.out.println(result.get(i));
        }
    }
}
