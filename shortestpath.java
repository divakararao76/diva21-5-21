import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
class Node
{
    int x, y;
    int level;
    Node(int x, int y, int level)
    {
        this.x = x;
        this.y = y;
        this.level = level;
    }
 
    @Override
    public String toString() {
        return "(" + x + ", " + y + ')';
    }
}
 
class Main
{
    private static int N;
    private static int[] row = { -1, 0, 0, 1 };
    private static int[] col = { 0, -1, 1, 0 };
    private static boolean isValid(int x, int y) {
        return (x >= 0 && x < N) && (y >= 0 && y < N);
    }
    public static int findPath(int matrix[][], int x, int y)
    {
        Queue<Node> q = new ArrayDeque<>();
        Node src = new Node(x, y, 0);
        q.add(src);
        Set<String> visited = new HashSet<>();
        String key = src.x + "," + src.y;
        visited.add(key);
        while (!q.isEmpty())
        {
            Node curr = q.poll();
            int i = curr.x;
            int j = curr.y;
            int level = curr.level;
            if (i == N - 1 && j == N - 1) {
                return level;
            }
            int n = matrix[i][j];
            for (int k = 0; k < 4; k++)
            {
                x = i + row[k] * n;
                y = j + col[k] * n;
                if (isValid(x, y))
                {
                    Node next = new Node(x, y, level + 1);
                    key = next.x + "," + next.y;
                    if (!visited.contains(key))
                    {
                        q.add(next);
                        visited.add(key);
                    }
                }
            }
        }
        return Integer.MAX_VALUE;
    }
 
    public static void main(String[] args)
    {
        int[][] matrix =
        {
            { 4, 4, 6, 5, 5, 1, 1, 1, 7, 4 },
            { 3, 6, 2, 4, 6, 5, 7, 2, 6, 6 },
            { 1, 3, 6, 1, 1, 1, 7, 1, 4, 5 },
            { 7, 5, 6, 3, 1, 3, 3, 1, 1, 7 },
            { 3, 4, 6, 4, 7, 2, 6, 5, 4, 4 },
            { 3, 2, 5, 1, 2, 5, 1, 2, 3, 4 },
            { 4, 2, 2, 2, 5, 2, 3, 7, 7, 3 },
            { 7, 2, 4, 3, 5, 2, 2, 3, 6, 3 },
            { 5, 1, 4, 2, 6, 4, 6, 7, 3, 7 },
            { 1, 4, 1, 7, 5, 3, 6, 5, 3, 4 }
        };
 
        N = matrix.length;
        int dist = findPath(matrix, 0, 0);
        if (dist != Integer.MAX_VALUE) {
            System.out.println("The shortest path length is " + dist);
        }
        else {
            System.out.println("Destination is not found");
        }
    }
}
/*
output:
The shortest path length is 6
*/

/*
#include <iostream>
#include <queue>
#include <map>
using namespace std;
#define N 10

typedef pair<int, int> Node;
int row[] = { -1, 0, 0, 1 };
int col[] = { 0, -1, 1, 0 };
bool isValid(Node pt, map<Node, int> visited)
{
    return (pt.first >= 0) && (pt.first < N) &&
        (pt.second >= 0) && (pt.second < N) && !visited.count(pt);
}
int findPath(int mat[][N], int x, int y)
{
    queue<Node> q;
    Node src = {x, y};
    q.push(src);
    map<Node, int> visited;
    visited[src] = 0;
    while (!q.empty())
    {
        Node node = q.front();
        q.pop();
        int i = node.first;
        int j = node.second;
        int dist = visited[node];
        if (i == N - 1 && j == N - 1) {
            return dist;
        }
         int n = mat[i][j];
        for (int k = 0; k < 4; k++)
        {
            Node next = {(i + row[k] * n), (j + col[k] * n)};
            if (isValid(next, visited))
            {
                q.push(next);
                visited[next] = dist + 1;
            }
        }
    }
    return -1;
}

int main()
{
    int matrix[N][N]=
    {
        { 7, 1, 3, 5, 3, 6, 1, 1, 7, 5 },
        { 2, 3, 6, 1, 1, 6, 6, 6, 1, 2 },
        { 6, 1, 7, 2, 1, 4, 7, 6, 6, 2 },
        { 6, 6, 7, 1, 3, 3, 5, 1, 3, 4 },
        { 5, 5, 6, 1, 5, 4, 6, 1, 7, 4 },
        { 3, 5, 5, 2, 7, 5, 3, 4, 3, 6 },
        { 4, 1, 4, 3, 6, 4, 5, 3, 2, 6 },
        { 4, 4, 1, 7, 4, 3, 3, 1, 4, 2 },
        { 4, 4, 5, 1, 5, 2, 3, 5, 3, 5 },
        { 3, 6, 3, 5, 2, 2, 6, 4, 2, 1 }
    };
    int len = findPath(matrix, 0, 0);
    if (len != -1) {
        cout << "The shortest path length is " << len;
    }
    else {
        cout << "Destination not possible";
    }
 
    return 0;
}
*/
