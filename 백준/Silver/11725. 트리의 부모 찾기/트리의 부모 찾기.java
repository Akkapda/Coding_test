import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Node {
        ArrayList<Integer> children = new ArrayList<>();
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        Node[] treeNode = new Node[n + 1];

        for (int i = 1; i <= n; i++) {
            treeNode[i] = new Node();
        }

        StringTokenizer st;
        for (int i = 0; i < n - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int node1 = Integer.parseInt(st.nextToken());
            int node2 = Integer.parseInt(st.nextToken());

            treeNode[node1].children.add(node2);
            treeNode[node2].children.add(node1);
        }

        int[] parent = new int[n + 1];
        dfs(treeNode, parent, 1, 0);

        for (int i = 2; i <= n; i++) {
            bw.write(parent[i] + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    public static void dfs(Node[] treeNode, int[] parent, int currentNode, int parentNode) {
        parent[currentNode] = parentNode;
        for (int child : treeNode[currentNode].children) {
            if (child != parentNode) {
                dfs(treeNode, parent, child, currentNode);
            }
        }
    }
}