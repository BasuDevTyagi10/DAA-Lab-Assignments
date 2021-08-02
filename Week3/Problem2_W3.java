package Week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2_W3 {
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./Week3/input2.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int arr[] = new int[n];
                int i,j,comparisions=0,swaps=0;
                for(i=0;i<n;i++) arr[i] = sc.nextInt();
                for(i=0;i<n-1;i++){
                    int min = i;
                    for(j=i+1;j<n;j++){
                        comparisions++;
                        if(arr[j] < arr[min])
                            min++;
                    }
                    int temp = arr[min];
                    arr[min] = arr[i];
                    arr[i] = temp;
                    swaps++;
                }
                for(i=0;i<n;i++) System.out.print(arr[i]+" ");
                System.out.println("\ncomparisions = "+comparisions);
                System.out.println("swaps = "+swaps);
            }
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}