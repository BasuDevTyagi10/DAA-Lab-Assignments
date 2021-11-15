package Week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Problem3_W6 {
    static int V = 0;
    public static boolean checkCycle(int[][] graph, int i, boolean visited[], boolean recStack[]) {
        if(recStack[i]) return true;
        if(visited[i]) return false;

        visited[i] = true;
        recStack[i] = true;

        for(int j=0;j<V;j++)
            if(graph[i][j] == 1)
                if(checkCycle(graph, j, visited, recStack))
                    return true;
        
        recStack[i] = false;

        return false;
        
    }
    public static boolean isCyclic(int[][] graph){
        boolean[] visited = new boolean[V];
        boolean[] recStack = new boolean[V];
         
        for (int i = 0; i < V; i++)

            if (checkCycle(graph, i, visited, recStack))
                return true;
 
        return false;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week6/input3.txt"));
            V = sc.nextInt();
            int g[][] = new int[V][V];
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++)
                    g[i][j] = sc.nextInt();
            System.out.println(isCyclic(g)?"YES":"NO");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
