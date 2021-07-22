package Week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Problem1_W2 {
    static int firstOccurence(int arr[], int lower, int upper, int x, int n){
        if(upper >= lower){
            int mid = (lower + upper)/2; 
            if((mid == 0 || x>arr[mid-1]) && arr[mid] == x)
                return mid;
            else if(x > arr[mid])
                return firstOccurence(arr, (mid+1), upper, x, n);
            else
                return firstOccurence(arr, lower, (mid-1), x, n);
        }
        return -1;
    }
    static int lastOccurence(int arr[], int lower, int upper, int x, int n){
        if(upper >= lower){
            int mid = (lower + upper)/2;
            if((mid == n-1 || x<arr[mid+1]) && arr[mid] == x )
                return mid;
            else if(x < arr[mid])
                return lastOccurence(arr, lower, (mid -1), x, n);
            else
                return lastOccurence(arr, (mid + 1), upper, x, n);     
        }
        return -1;
    }
    static int countOccurences(int arr[], int x, int n){
        int first,last;
        first = firstOccurence(arr, 0, n-1, x, n);
        if(first == -1)
            return first;
        last = lastOccurence(arr, first, n-1, x, n);    
        return last-first+1;
    }
    public static void main(String[] args) throws IOException{
        try{
            Scanner sc = new Scanner(new File("./Week2/input1.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int arr[] = new int[n];
                int i;
                for(i=0;i<n;i++) arr[i] = sc.nextInt();
                int key = sc.nextInt();
                int count = countOccurences(arr, key, n);
                if(count==-1) System.out.println("Key not present");
                else System.out.println(key+" - "+count);

            }
            sc.close();
        } catch(FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
