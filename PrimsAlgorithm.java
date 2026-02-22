import java.util.*;

public class PrimsAlgorithm {
    private static final int V = 5; // number of vertices

    // Find vertex with minimum key value not yet included in MST
    int minKey(int[] key, boolean[] mstSet) {
        int min = Integer.MAX_VALUE, minIndex = -1;
        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }

    // Print MST
    void printMST(int[] parent, int[][] graph) {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
        }
    }

    // Prim’s MST
    void primMST(int[][] graph) {
        int[] parent = new int[V]; // store MST
        int[] key = new int[V];    // key values
        boolean[] mstSet = new boolean[V]; // included vertices

        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;     // start from vertex 0
        parent[0] = -1; // root has no parent

        for (int count = 0; count < V - 1; count++) {
            int u = minKey(key, mstSet);
            mstSet[u] = true;

            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }

        printMST(parent, graph);
    }

    public static void main(String[] args) {
        PrimsAlgorithm pa = new PrimsAlgorithm();
        int[][] graph = {
            {0, 2, 0, 6, 0},
            {2, 0, 3, 8, 5},
            {0, 3, 0, 0, 7},
            {6, 8, 0, 0, 9},
            {0, 5, 7, 9, 0}
        };
        pa.primMST(graph);
    }
}
