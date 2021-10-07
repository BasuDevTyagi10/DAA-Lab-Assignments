package Week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2_W6 {
    static int v = 0;
    public static boolean isBipartite(int g[][], int s) {
        return false;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week6/input2.txt"));
            int t = sc.nextInt();
            while(t-- > 0){
                v = sc.nextInt();
                int g[][] = new int[v][v];
                System.out.println(isBipartite(g,0)?"YES":"NO");
            }
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}