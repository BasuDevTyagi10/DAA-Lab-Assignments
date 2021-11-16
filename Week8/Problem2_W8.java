package Week8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2_W8 {
    public static int V = 0;
    public static int find(int i,int[] parent) {
        System.out.println(i);
        while (parent[i] != i)
            i = parent[i];
        return i;
    }
    public static void union1(int i, int j, int[] parent) {
        int a = find(i,parent);
        int b = find(j,parent);
        parent[a] = b;
    }
    public static void kruskalAlgo(int[][] graph){
        int mincost = 0;
        int parent[] = new int[V];
        for(int i=0;i<V;i++) parent[i] = i;
        int edge_count = 0;
        while (edge_count < V - 1){
            int min = Integer.MAX_VALUE, a = -1, b = -1;
            for (int i = 0; i < V; i++){
                for (int j = 0; j < V; j++){
                    if (find(i,parent) != find(j,parent) && graph[i][j] < min){
                        min = graph[i][j];
                        a = i;
                        b = j;
                    }
                }
            }    
            union1(a, b, parent);
        }
        System.out.printf("\n Minimum cost= %d \n", mincost);
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week8/input.txt"));
            V = sc.nextInt();
            int[][] graph = new int[V][V];
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++)
                    graph[i][j] = sc.nextInt();
            kruskalAlgo(graph);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }    
}
