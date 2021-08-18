package Week4;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1_W4 {
    int comparisions = 0, inversions = 0;
    void merge(int arr[], int left, int mid, int right){
        int n1 = mid-left+1, n2=right-mid;
        int L[] = new int[n1];
        int R[] = new int[n2];
        int i,j,k;
        for (i=0;i<n1;i++) L[i] = arr[left+i];
        for (j=0;j<n2;j++) R[j] = arr[mid+1+j];

        i=0; j=0; k=left;
        while(i<n1 && j<n2){
            if (L[i]<=R[j]) {
                arr[k] = L[i];
                i++;
                comparisions++;
            } else {
                arr[k] = R[j];
                j++;
                comparisions++;
                inversions += (mid + 1) - (left + i);
            }
            k++;
        }
        while(i<n1){
            arr[k] = L[i];
            i++;
            k++;
        }
        while(j<n2){
            arr[k] = R[j];
            j++;
            k++;
        }
    }
    void sort(int arr[], int l, int r){
        if(l<r){
            int m = l+(r-l)/2;
            sort(arr, l, m);
            sort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./Week4/input1.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int arr[] = new int[n];
                Problem1_W4 obj = new Problem1_W4();
                int i;
                for(i=0;i<n;i++) arr[i] = sc.nextInt();
                obj.sort(arr, 0, n-1);

                // Printing Result
                for(i=0;i<n;i++) System.out.print(arr[i]+" ");
                System.out.println("\ncomparisions = "+obj.comparisions);
                System.out.println("inversions = "+obj.inversions);
            }
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}