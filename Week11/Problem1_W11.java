package Week11;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1_W11 {
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week11/input1.txt"));
            int n = sc.nextInt();
            int matDim[] = new int[n+1];
            for(int i=0,j=0;i<n;i++){
                int a = sc.nextInt();
                int b = sc.nextInt();
                if(i>0){
                    matDim[j] = b;
                    j++;
                }
                else {
                    matDim[j] = a;
                    j++;
                    matDim[j] = b;
                    j++;
                }
            }
            int m[][] = new int[n+1][n+1];
            int i, j, k, L, q;
            for (i = 1; i < n; i++)
                m[i][i] = 0;
            for (L = 2; L < n; L++){
                for (i = 1; i < n - L + 1; i++){
                    j = i + L - 1;
                    if (j == n)
                        continue;
                    m[i][j] = Integer.MAX_VALUE;
                    for (k = i; k <= j - 1; k++){
                        q = m[i][k] + m[k + 1][j] + matDim[i - 1] * matDim[k] * matDim[j];
                        if (q < m[i][j])
                            m[i][j] = q;
                    }
                }
            }         
            System.out.println(m[1][n - 1]);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
