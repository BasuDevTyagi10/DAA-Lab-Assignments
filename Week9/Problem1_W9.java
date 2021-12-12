package Week9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Problem1_W9 {
    public static int V = 0, INF = 99999;
    static void floydWarshall(int[][] graph){
        int i,j,k;
        int matrix[][] = new int[V][V];
        for (i = 0; i < V; i++)
            for (j = 0; j < V; j++)
                matrix[i][j] = graph[i][j];

        for (k = 0; k < V; k++) {
            for (i = 0; i < V; i++) {
                for (j = 0; j < V; j++) {
                    if (matrix[i][k] + matrix[k][j] < matrix[i][j])
                        matrix[i][j] = matrix[i][k] + matrix[k][j];
                }
            }
        }
        printMatrix(matrix);
    }
    static void printMatrix(int matrix[][]) {
        System.out.println("Shortest Distance Matrix: ");
        for (int i = 0; i < V; ++i) {
            for (int j = 0; j < V; ++j) {
                if (matrix[i][j] == INF)
                    System.out.print("INF ");
                else
                    System.out.print(matrix[i][j] + "  ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        try {
            Scanner sc = new Scanner(new File("./Week9/input1.txt"));
            V = sc.nextInt();
            int[][] graph = new int[V][V];
            for(int i=0;i<V;i++)
                for(int j=0;j<V;j++)
                    try {
                        graph[i][j] = sc.nextInt();
                    } catch (InputMismatchException e) {
                        sc.next();
                        graph[i][j] = INF;
                    }
            floydWarshall(graph);
            sc.close();
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
    }
}
