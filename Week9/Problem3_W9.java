package Week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Problem3_W9 {
    static void calculateMinCost(int arr[], int n){
        Arrays.sort(arr);
        ArrayList<Integer> sum = new ArrayList<>();
        int currCost = 0;
        for(int i=0;i<n-1;i++){
            if(i==0) currCost = arr[i] + arr[i+1];
            else currCost += arr[i+1];
            sum.add(currCost);
        }
        int minCost = 0;
        for(int x: sum) minCost += x;
        System.out.println(minCost);
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week9/input3.txt"));
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt(); 
            calculateMinCost(arr, n);
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
