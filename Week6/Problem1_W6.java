package Week6;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

public class Problem1_W6 {
    public static boolean dfs(int graphMat[][], int source, int destination){
        boolean visited[] = new boolean[graphMat.length];
        visited[source-1] = true;

        Stack<Integer> stack = new Stack<>();
        stack.push(source-1);

        while(!stack.isEmpty()){
            int current = stack.pop();

            if(current+1 == destination) return true;

            for(int i=0;i<graphMat.length;i++){
                if(graphMat[current][i] == 1 && !visited[i]){
                    visited[i] = true;
                    stack.push(i);
                }
            }
        }

        return false;
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week6/input1.txt"));

            int v = sc.nextInt();
            int adjMat[][] = new int[v][v];
            int i,j;
            for(i=0;i<v;i++)
                for(j=0;j<v;j++)
                    adjMat[i][j] = sc.nextInt();
            int source = sc.nextInt();
            int destination = sc.nextInt();

            System.out.println(dfs(adjMat, source, destination) ? "Yes Path Exists" : "No Such Path Exists");
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
