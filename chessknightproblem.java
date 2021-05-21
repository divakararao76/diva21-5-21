import java.util.*;
class Node
{
    int x, y, dist;
    public Node(int x, int y)
    {
        this.x = x;
        this.y = y;
    }
    public Node(int x, int y, int dist)
    {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node node = (Node) o;
        return x == node.x &&
                y == node.y &&
                dist == node.dist;
    }
 
    @Override
    public int hashCode() {
        return Objects.hash(x, y, dist);
    }
}
 
class Main
{
    private static int[] row = { 2, 2, -2, -2, 1, 1, -1, -1 };
    private static int[] col = { -1, 1, 1, -1, 2, -2, 2, -2 };
    private static boolean isValid(int x, int y, int N)
    {
        if (x < 0 || y < 0 || x >= N || y >= N) {
            return false;
        }
 
        return true;
    }
    public static int BFS(Node src, Node dest, int N)
    {
        Set<Node> visited = new HashSet<>();
        Queue<Node> q = new ArrayDeque<>();
        q.add(src);
        while (!q.isEmpty())
        {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;
            int dist = node.dist;
            if (x == dest.x && y == dest.y) {
                return dist;
            }
            if (!visited.contains(node))
            {
                visited.add(node);
                for (int i = 0; i < 8; i++)
                {
                    int x1 = x + row[i];
                    int y1 = y + col[i];
                    if (isValid(x1, y1, N)) {
                        q.add(new Node(x1, y1, dist + 1));
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
 
    public static void main(String[] args)
    {
        int N = 8;
        Node src = new Node(0, 7);
        Node dest = new Node(7, 0);
        System.out.println("The minimum number of steps required is " +
                BFS(src, dest, N));
    }
}
/*
output
The minimum number of steps required is 6
*/
