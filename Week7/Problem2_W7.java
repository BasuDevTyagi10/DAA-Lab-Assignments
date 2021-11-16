package Week7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem2_W7 {
    public static int V = 0;
    public static void bellmanFordAlgo(int[][] graph, int src) {
        int[] parent = new int[V];
        int[] distance = new int[V];
        for(int i=0;i<V;i++) distance[i] = Integer.MAX_VALUE;

        parent[src] = -1;
        distance[src] = 0;

        boolean negative_cycle = false;
        for(int i=0;i<V-1;i++){
            negative_cycle = false;
            for(int j=0;j<V;j++){
                if(graph[i][j] > 0){
                    if(distance[i] + graph[i][j] < distance[j]){
                        distance[j] = distance[i] + graph[i][j];
                        parent[j] = i;
                        negative_cycle = true;
                    }
                }
            }
        }
        if(negative_cycle)
            System.out.println("Negative Cycle Exists!");
        else{
            printSolution(src, distance, parent);
        }
        
    }
    public static void printSolution(int src, int[] distances, int[] parents){
		for (int i = 0; i < V; i++){
			if (i != src){
				printPath(i, parents);
                System.out.print(": "+distances[i]);
			} else {
                System.out.print((i+1)+" : 0");
            }
            System.out.println();
		}
	}
	public static void printPath(int currentVertex,int[] parents){
		if (currentVertex == -1) return;
		System.out.print((currentVertex+1) + " ");
		printPath(parents[currentVertex], parents);
	}
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week7/input1&2.txt"));
            V = sc.nextInt();
            int[][] graph = new int[V][V];
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++)
                    graph[i][j] = sc.nextInt();
            int src = sc.nextInt();
            bellmanFordAlgo(graph, src-1);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
