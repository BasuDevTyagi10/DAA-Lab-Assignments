package Week8;

public class Problem3_W8 {
    public static int V = 5;
    static int findMaxVertex(boolean visited[], int weights[]){
        int index = -1;
        int maxW = Integer.MIN_VALUE;
        for (int i = 0; i < V; i++) {
            if (visited[i] == false && weights[i] > maxW){
                maxW = weights[i];
                index = i;
            }
        }
        return index;
    }
    static void maximumSpanningTree(int[][] graph){
        boolean[] visited = new boolean[V];
        int[] weights = new int[V];
        int[] parent = new int[V];
        for (int i = 0; i < V; i++) {
            visited[i] = false;
            weights[i] = Integer.MIN_VALUE;
        }
        weights[0] = Integer.MAX_VALUE;
        parent[0] = -1;
        for (int i = 0; i < V - 1; i++) {
            int maxVertexIndex = findMaxVertex(visited, weights);
            visited[maxVertexIndex] = true;
            for (int j = 0; j < V; j++) {
                if (graph[j][maxVertexIndex] != 0 && visited[j] == false) {
                    if (graph[j][maxVertexIndex] > weights[j]) {
                        weights[j] = graph[j][maxVertexIndex];
                        parent[j] = maxVertexIndex;
                    }
                }
            }
        }
        int MST = 0;
        for (int i = 1; i < V; i++)
            MST += graph[i][parent[i]];

        System.out.println(MST);
    }
    public static void main(String[] args)
    {
        int[][] graph = { { 0, 2, 0, 6, 0 },
                        { 2, 0, 3, 8, 5 },
                        { 0, 3, 0, 0, 7 },
                        { 6, 8, 0, 0, 9 },
                        { 0, 5, 7, 9, 0 } };
        maximumSpanningTree(graph);
    }
}