package Week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1_W3 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./Week3/input1.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int arr[] = new int[n];
                int i,j,key,comparisions=0,shifts=0;
                for(i=0;i<n;i++) arr[i] = sc.nextInt();
                for(i=1;i<n;i++){
                    key = arr[i];
                    j = i-1;
                    while(j>=0 && arr[j]>key){
                        comparisions++;
                        arr[j+1] = arr[j];
                        shifts++;
                        j--;
                    }
                    arr[j+1] = key;
                    shifts++;
                }
                for(i=0;i<n;i++) System.out.print(arr[i]+" ");
                System.out.println("\ncomparisions = "+comparisions);
                System.out.println("shifts = "+shifts);
            }
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}