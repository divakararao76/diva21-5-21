import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Edge
{
    int source, dest;
 
    public Edge(int source, int dest)
    {
        this.source = source;
        this.dest = dest;
    }
}
 class Graph
{
    List<List<Integer>> adjList = null;
    Graph(List<Edge> edges, int N)
    {
        adjList = new ArrayList<>();
 
        for (int i = 0; i < N; i++) {
            adjList.add(new ArrayList<>());
        }
        for (Edge edge: edges)
        {
            int src = edge.source;
            int dest = edge.dest;
 
            adjList.get(src).add(dest);
        }
    }
}
 
class Main
{
    public static void DFS(Graph graph, byte[][] C, int root, int descendant)
    {
        for (int child: graph.adjList.get(descendant))
        {
            if (C[root][child] == 0)
            {
                C[root][child] = 1;
                DFS(graph, C, root, child);
            }
        }
    }
 
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 2), new Edge(1, 0), new Edge(3, 1)
        );
        final int N = 4;
        Graph graph = new Graph(edges, N);
        byte C[][] = new byte[N][N];
        for (int v = 0; v < N; v++)
        {
            C[v][v] = 1;
            DFS(graph, C, v, v);
            System.out.println(Arrays.toString(C[v]));
        }
    }
}
/*
output
[1, 0, 1, 0]
[1, 1, 1, 0]
[0, 0, 1, 0]
[1, 1, 1, 1]
*/
