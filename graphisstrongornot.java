
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
    private static void DFS(Graph graph, int v, boolean[] visited)
    {
        visited[v] = true;
        for (int u: graph.adjList.get(v))
        {
            if (!visited[u]) {
                DFS(graph, u, visited);
            }
        }
    }
    public static boolean check(Graph graph, int N)
    {
        for (int i = 0; i < N; i++)
        {
            boolean[] visited = new boolean[N];
            DFS(graph, i, visited);
            for (boolean b: visited)
            {
                if (!b) {
                    return false;
                }
            }
        }
 
        return true;
    }
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                new Edge(0, 4), new Edge(1, 0), new Edge(1, 2),
                new Edge(2, 1), new Edge(2, 4), new Edge(3, 1),
                new Edge(3, 2) , new Edge(4, 3)
        );
        final int N = 5;
        Graph graph = new Graph(edges, N);
        if (check(graph, N)) {
            System.out.println("The graph is strongly connected");
        }
        else {
            System.out.println("The graph is not strongly connected");
        }
    }
}
/*
The graph is strongly connected
*/
