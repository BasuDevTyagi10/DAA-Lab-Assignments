package Week5;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1_W5 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week5/input1.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                int n = sc.nextInt();
                char arr[] = new char[n];
                int i;
                for(i=0;i<n;i++) arr[i] = sc.next().charAt(0);
                int count[] = new int[256];
                for(i=0;i<n;i++) count[arr[i]]++;
                int maxCount = count[0];
                char maxChar = '\u0000';
                for(i=1;i<256;i++){
                    if(count[i]>maxCount){
                        maxCount = count[i];
                        maxChar = (char)i;
                    }
                }
                if(maxCount>1)
                    System.out.println(maxChar+" - "+maxCount);
                else
                    System.out.println("No Duplicates Present");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
    
}