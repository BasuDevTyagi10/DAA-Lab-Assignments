package Week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Problem2_W6 {
    static int V = 0;   // no. of nodes
    public static boolean isBipartite(int g[][], int s) {
        /* 
            Notation :
            0   -   no color
            1   -   red color
            -1  -   blue color
        */
        int color[] = new int[V];
        Queue<Integer> queue = new LinkedList<>();
        int currColor = 1;
        color[s] = currColor;
        queue.add(s);
        while(!queue.isEmpty()){
            int u = queue.poll();
            if(g[u][u] != 0) return false;
            currColor *= -1;
            for (int v=0; v<V; ++v){
                if (g[u][v]!=0 && color[v]==0){
                    color[v] = currColor;
                    queue.add(v);
                }
                if (g[u][v]!=0 && color[u]==color[v])
                    return false;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week6/input2.txt"));
            V = sc.nextInt();
            int g[][] = new int[V][V];
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++)
                    g[i][j] = sc.nextInt();
            System.out.println(isBipartite(g,0)?"YES":"NO");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}