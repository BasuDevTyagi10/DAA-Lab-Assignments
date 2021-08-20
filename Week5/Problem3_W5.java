package Week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_W5 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week5/input3.txt"));
            int m = sc.nextInt();
            int arr1[] = new int[m];
            int i,j;
            for(i=0;i<m;i++) arr1[i] = sc.nextInt();
            int n = sc.nextInt();
            int arr2[] = new int[n];
            for(i=0;i<n;i++) arr2[i] = sc.nextInt();
            i=0; j=0;
            while (i<m && j<n) {
                if(arr1[i]<arr2[j])
                    i++;
                else if(arr2[j] < arr1[i])
                    j++;
                else{
                    System.out.print(arr2[j] + " ");
                    i++; j++;
                }
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
    
}