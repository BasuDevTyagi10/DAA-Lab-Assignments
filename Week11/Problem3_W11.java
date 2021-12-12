package Week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class Problem3_W11 {
    static int ways(int[] arr, int i, int N, int[][] dp){
        if(N==0)
            return 1;
        if(i==arr.length)
            return 0;
        if(dp[i][N]>0)
            return dp[i][N];

        if (N >= arr[i]){
            dp[i][N - arr[i]] = ways(arr, i, N - arr[i],dp);
            dp[i+1][N] = ways(arr, i + 1, N,dp);
            return dp[i][N - arr[i]] + dp[i + 1][N];
        }
        return 0;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week11/input3.txt"));
            int n = sc.nextInt();
            int arr[] = new int[n];
            int sum = 0;
            for(int i=0;i<n;i++){
                arr[i] = sc.nextInt();
                sum += arr[i];
            }
            if(sum % 2 != 0){
                System.out.println("no");
                System.exit(0);
            }
            int target = sum/2;
            Arrays.sort(arr);
            int dp[][] = new int[n+1][target+1];
            System.out.println(ways(arr, 0, target, dp) > 0 ? "yes" : "no");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
