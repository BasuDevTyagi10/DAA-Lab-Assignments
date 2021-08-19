package Week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_W4 {
    void swap(int arr[], int x, int y){
        int temp = arr[x];
        arr[x] = arr[y];
        arr[y] = temp;
    }
    int partition(int[] arr, int low, int high){
        int pivot = arr[high], pivotloc = low;
        for (int i = low; i <= high; i++) {
            if (arr[i] < pivot) {
                swap(arr,i,pivotloc);
                pivotloc++;
            }
        }
        swap(arr, high, pivotloc);
        return pivotloc;
    }
    int kthSmallest(int[] arr, int low, int high, int k){
        int partition = partition(arr, low, high);
        if (partition == k - 1)
            return arr[partition];
        else if (partition < k - 1)
            return kthSmallest(arr, partition + 1, high, k);
        else
            return kthSmallest(arr, low, partition - 1, k);
    }
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./Week4/input3.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                Problem3_W4 obj = new Problem3_W4();
                int n = sc.nextInt();
                int arr[] = new int[n];
                for(int i=0;i<n;i++) arr[i] = sc.nextInt();
                int k = sc.nextInt();
                if(k<n){
                    System.out.println(obj.kthSmallest(arr, 0, n-1, k));
                }
            }
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}