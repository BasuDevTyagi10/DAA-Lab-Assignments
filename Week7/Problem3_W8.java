package Week7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_W8 {
    public static int V = 0;
    public static final int INF = Integer.MAX_VALUE;
    public static int shortestPath(int graph[][], int u, int v, int k){
        if (k == 0 && u == v) return 0;
        if (k == 1 && graph[u][v] != INF) return graph[u][v];
        if (k <= 0) return INF;

        int res = INF;
        for (int i = 0; i < V; i++){
            if (graph[u][i] != INF && u != i && v != i){
                int rec_res = shortestPath(graph, i, v, k-1);
                if (rec_res != INF)
                    res = Math.min(res, graph[u][i] + rec_res);
            }
        }
        return res;
    }
 
    public static void main (String[] args)
    {
        try {
            Scanner sc = new Scanner(new File("./Week7/input3.txt"));
            V = sc.nextInt();
            int[][] graph = new int[V][V];
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++){
                    int x = sc.nextInt();
                    graph[i][j] = (x == -1) ? INF : x;
                }
            int src = sc.nextInt();
            int dest = sc.nextInt();
            int k = sc.nextInt();
            System.out.println(shortestPath(graph, src-1, dest-1, k));

        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
