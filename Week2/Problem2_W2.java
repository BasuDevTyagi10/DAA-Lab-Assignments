package Week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Problem2_W2 {
    public static void main(String[] args) throws IOException{
        try {
            Scanner sc = new Scanner(new File("./Week2/input2.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int arr[] = new int[n];
                int i,j=0,k; boolean isPresent=false;
                for(i=0;i<n;i++) arr[i] = sc.nextInt();
                for(k=n-1;k>=0;k--){
                    i=0;
                    j=k-1;
                    while(i<j){
                        if(arr[i]+arr[j] == arr[k]){
                            isPresent=true;
                            break;
                        } else if(arr[i]+arr[j] > arr[k]) j--;
                        else if(arr[i]+arr[j] < arr[k]) i++;
                    }
                    if(isPresent){
                        i = i+1; j = j+1; k = k+1;
                        break;
                    }
                }
                if(isPresent) System.out.println(i+", "+j+", "+k);
                else System.out.println("No sequence found.");
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
