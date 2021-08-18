package Week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2_W4 {
    int swaps = 0, comparisions = 0;
    void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        swaps++;
    }
    int partition(int[] arr, int low, int high){
        int pivot = arr[high]; 
        int i = (low - 1); 
        for(int j=low;j<=high-1;j++){
            if (arr[j] < pivot) {
                // comparisions++;
                i++; 
                swap(arr, i, j);
            }
            comparisions++;
        }
        swap(arr, i + 1, high);
        return (i + 1);
    }
    void sort(int[] arr, int low, int high){
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./Week4/input2.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int arr[] = new int[n];
                Problem2_W4 obj = new Problem2_W4();
                int i;
                for(i=0;i<n;i++) arr[i] = sc.nextInt();
                obj.sort(arr, 0, n-1);

                // Printing Result
                for(i=0;i<n;i++) System.out.print(arr[i]+" ");
                System.out.println("\ncomparisions = "+obj.comparisions);
                System.out.println("swaps = "+obj.swaps);
            }
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}