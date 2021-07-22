package Week2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Problem3_W3 {
    public static void main(String[] args) throws IOException{
        try {
            Scanner sc = new Scanner(new File("./Week2/input3.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                int arr[] = new int[n];
                int i,j;
                for(i=0;i<n;i++) arr[i] = sc.nextInt();
                int K = sc.nextInt();
                int count = 0;
                for(i=0;i<n-1;i++){
                    for(j=i+1;j<n;j++)
                        if(arr[i] - arr[j] == K || arr[j] - arr[i] == K)
                            count++;
                }
                System.out.println(count);
            }
            sc.close();
        } catch (FileNotFoundException e){
            System.out.println("File Not Found");
        }
    }
}
