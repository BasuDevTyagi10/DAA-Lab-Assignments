package Week7;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1_W7 {
    public static int V = 0;
	public static void dijkstraAlgo(int[][] graph, int src){
		int[] distances = new int[V];
		boolean[] processed = new boolean[V];
		int[] parents = new int[V];

		for (int i = 0; i < V; i++){
			distances[i] = Integer.MAX_VALUE;
			processed[i] = false;
		}
		distances[src] = 0;
		parents[src] = -1;
		for (int i = 1; i < V; i++){
			int nearestVertex = -1;
			int shortestDistance = Integer.MAX_VALUE;
			for (int j = 0; j < V; j++){
				if (!processed[j] && distances[j] < shortestDistance){
					nearestVertex = j;
					shortestDistance = distances[j];
				}
			}
			processed[nearestVertex] = true;
			for (int k = 0; k < V; k++){
				int edgeDistance = graph[nearestVertex][k];
				if (edgeDistance > 0 && ((shortestDistance + edgeDistance) < distances[k])){
					parents[k] = nearestVertex;
					distances[k] = shortestDistance + edgeDistance;
				}
			}
		}
		printSolution(src, distances, parents);
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
	public static void main(String[] args){
        try {
            Scanner sc = new Scanner(new File("./Week7/input1&2.txt"));
            V = sc.nextInt();
            int[][] graph = new int[V][V];
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++)
                    graph[i][j] = sc.nextInt();
            int src = sc.nextInt();
            dijkstraAlgo(graph, src-1);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
	}
}