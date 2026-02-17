
public class GraphColoring {
    private int V;              // Number of vertices
    private int numOfColors;    // Number of colors
    private int[] color;        // Color assigned to each vertex
    private int[][] graph;      // Graph adjacency matrix

    // Function to assign colors
    public void graphColor(int[][] g, int noc) {
        V = g.length;
        numOfColors = noc;
        color = new int[V];
        graph = g;

        try {
            solve(0);
            System.out.println("No solution exists.");
        } catch (Exception e) {
            System.out.println("Solution exists: Following are the assigned colors");
            for (int i = 0; i < V; i++) {
                System.out.println("Vertex " + (i+1) + " ---> Color " + color[i]);
            }
        }
    }

    // Recursive function to solve coloring
    private void solve(int v) throws Exception {
        if (v == V) throw new Exception("Solution found");

        for (int c = 1; c <= numOfColors; c++) {
            if (isSafe(v, c)) {
                color[v] = c;
                solve(v + 1);
                color[v] = 0; // backtrack
            }
        }
    }

    // Check if assigning color is safe
    private boolean isSafe(int v, int c) {
        for (int i = 0; i < V; i++) {
            if (graph[v][i] == 1 && c == color[i]) return false;
        }
        return true;
    }

    // Driver code
    public static void main(String[] args) {
        GraphColoring gc = new GraphColoring();

        // Example graph (Adjacency Matrix)
        int[][] graph = {
            {0, 1, 1, 1},
            {1, 0, 1, 0},
            {1, 1, 0, 1},
            {1, 0, 1, 0}
        };

        int numOfColors = 3; // Try with 3 colors
        gc.graphColor(graph, numOfColors);
    }
}