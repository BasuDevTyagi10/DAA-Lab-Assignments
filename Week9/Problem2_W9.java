package Week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Problem2_W9 {
    static class Item{
        double weight, value;
        int index;
        Double cost;
        Item(double weight, double value, int index){
            this.weight = weight;
            this.value = value;
            this.index = index;
            this.cost = value/weight;
        }
    }
    static void getMaxValue(int[] weights, int[] values, int capacity){
        Item items[] = new Item[weights.length];
        for(int i=0;i<weights.length;i++)
            items[i] = new Item(weights[i], values[i], i+1);

        Arrays.sort(items, new Comparator<Item>() {
            @Override
            public int compare(Item o1, Item o2){
                return o2.cost.compareTo(o1.cost);
            }
        });

        double totalValue = 0;
        Item picked_item[] = new Item[items.length];
        int x = 0;
        for (Item i : items) {
            int curWt = (int)i.weight;
            int curVal = (int)i.value;
  
            if (capacity - curWt >= 0) {
                // this weight can be picked while
                picked_item[x] = i;
                x++;
                capacity = capacity - curWt;
                totalValue += curVal;
            }
            else {
                // item cant be picked whole
                double fraction = ((double)capacity / (double)curWt);
                totalValue += (curVal * fraction);
                capacity = (int)(capacity - (curWt * fraction));
                picked_item[x] = new Item(curWt*fraction, i.value, i.index);
                break;
            }
        }

        System.out.printf("Maximum value : %.2f\n",totalValue);
        System.out.println("item-weight");
        for(Item i: picked_item){
            try{
                System.out.println(i.index+"-"+(int)i.weight);
            } catch(NullPointerException e){
                break;
            }
        }
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week9/input2.txt"));
            int n = sc.nextInt();
            int weights[] = new int[n];
            int values[] = new int[n];
            for(int i=0;i<n;i++) weights[i] = sc.nextInt();
            for(int i=0;i<n;i++) values[i] = sc.nextInt();
            int capacity = sc.nextInt();
            getMaxValue(weights, values, capacity);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
