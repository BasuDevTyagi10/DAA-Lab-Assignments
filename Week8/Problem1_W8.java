package Week8;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem1_W8 {
    public static int V = 0;
    public static int getMinNode(int[] weight, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < V; i++)
            if (mstSet[i] == false && weight[i] < min) {
                min = weight[i];
                min_index = i;
            }
        return min_index;
    }
    public static void minCost(int[][] graph) {
        int parent[] = new int[V];
        int weight[] = new int[V];
        boolean mstSet[] = new boolean[V];
        for (int i = 0; i < V; i++) {
            weight[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }
        weight[0] = 0;
        parent[0] = -1;
        for(int i=0;i<V-1;i++){
            int min_node = getMinNode(weight, mstSet);
            mstSet[min_node] = true;
            for(int j=0;j<V;j++){
                if(graph[min_node][j] != 0 && mstSet[j] == false && graph[min_node][j] < weight[j]){
                    parent[j] = min_node;
                    weight[j] = graph[min_node][j];
                }
            }
        }
        System.out.println();
        int sum = 0;
        for(int i=0;i<weight.length;i++) sum += weight[i];
        System.out.println(sum);

    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week8/input.txt"));
            V = sc.nextInt();
            int[][] graph = new int[V][V];
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++)
                    graph[i][j] = sc.nextInt();
            minCost(graph);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
