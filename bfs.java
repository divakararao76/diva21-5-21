import java.util.*;
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
            adjList.get(dest).add(src);
        }
    }
}
 
class Main
{
    public static void BFS(Graph graph, int v, boolean[] discovered)
    {
        Queue<Integer> q = new ArrayDeque<>();
        discovered[v] = true;
        q.add(v);
        while (!q.isEmpty())
        {
            v = q.poll();
            System.out.print(v + " ");
            for (int u: graph.adjList.get(v))
            {
                if (!discovered[u])
                {
                    discovered[u] = true;
                    q.add(u);
                }
            }
        }
    }
 
    public static void main(String[] args)
    {
        List<Edge> edges = Arrays.asList(
                new Edge(1, 2), new Edge(1, 3), new Edge(1, 4),
                new Edge(2, 5), new Edge(2, 6), new Edge(5, 9),
                new Edge(5, 10), new Edge(4, 7), new Edge(4, 8),
                new Edge(7, 11), new Edge(7, 12)
        );
 
        final int N = 15;
        Graph graph = new Graph(edges, N);
        boolean[] discovered = new boolean[N];
        for (int i = 0; i < N; i++)
        {
            if (discovered[i] == false)
            {
                BFS(graph, i, discovered);
            }
        }
    }
}


/*
output
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 

*/
