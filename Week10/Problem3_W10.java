package Week10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem3_W10 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week10/input3.txt"));
            int n = sc.nextInt();
            int arr[] = new int[n];
            for(int i=0;i<n;i++) arr[i] = sc.nextInt();
            int maj = arr[0];
            int count = 1;
            for(int i=1;i<n;i++){
                if(count == 0){
                    maj = arr[i];
                    count++;
                } else{
                    if(arr[i] == maj) count++;
                    else count--;
                }
            }
            
            count=0;
            for(int i = 0; i < n; i++)
                if(arr[i]==maj) count++;
            
            System.out.println((count>n/2)?"yes":"no");

            Arrays.sort(arr);
            if(n%2!=0) System.out.println(arr[n/2]);
            else{
                int n1 = n/2;
                int n2 = n/2 - 1;
                int ans=arr[n1]+arr[n2];
                System.out.println(ans/2);
            }

            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
