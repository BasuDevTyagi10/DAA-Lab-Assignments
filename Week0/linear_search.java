package Week0;
/**
 Question-1:
 Given an array of nonnegative integers, design a linear algorithm and implement it using a program
 to find whether a given key element is present in the array or not.
 Also, find the total number of comparisons for each input case.
 (Time Complexity = O(n), where n is the size of input).
 Input Format:
 n - no. of test cases
 next n lines:
 x - size of array
 a1 a2 a3 .... asize - x spaced non-negative integers
 key - key element to find
 Output Format:
 YES or NO - if key is present or absent
 comparisions - no. of comparisons made
 */
import java.io.*;
import java.util.*;
public class linear_search {
    public static void main(String[] args) throws IOException{
        try {
            Scanner sc = new Scanner(new File("./Week0/input.txt"));
            int n = sc.nextInt();
            while(n>0){
                int size = sc.nextInt();
                int arr[] = new int[size];
                for(int i=0;i<size;i++)
                    arr[i] = sc.nextInt();
                int key = sc.nextInt();
                boolean found = false;
                int comparisions=0;
                for(int i=0;i<size;i++){
                    comparisions++;
                    if(arr[i] == key){
                        found = true;
                        break;
                    }
                }
                if(found) System.out.println("YES");
                else System.out.println("NO");
                System.out.println(comparisions);
                n--;
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}