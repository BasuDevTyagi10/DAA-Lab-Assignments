package Week3;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_W3 {
    static void merge(int arr[], int l, int m, int r){
        int n1=m-l+1, n2=r-m;
        int L[] = new int[n1];
        int R[] = new int[n2];
        int i,j,k;
        for (i=0;i<n1;i++) L[i] = arr[l+i];
        for (j=0;j<n2;j++) R[j] = arr[m+1+j];

        i=0;
        j=0;
        k=l;
        while(i<n1 && j<n2){
            if (L[i]<=R[j]) {
                arr[k] = L[i];
                i++;
            }
            else {
                arr[k] = R[j];
                j++;
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
    
    static void mergeSort(int arr[], int l, int r){
        if(l<r){
            int m = l+(r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m+1, r);
            merge(arr, l, m, r);
        }
    }
    
    public static void main(String[] args) {
        try{
            Scanner sc = new Scanner(new File("./Week3/input3.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int arr[] = new int[n];
                int i;
                for(i=0;i<n;i++) arr[i] = sc.nextInt();
                mergeSort(arr, 0, n-1);
                boolean isDuplicate = false;
                for(i=0;i<n-1;i++){
                    if(arr[i] == arr[i+1]){
                        isDuplicate=true;
                        break;
                    }
                }
                if(isDuplicate) System.out.println("YES");
                else System.out.println("NO");

            }
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}