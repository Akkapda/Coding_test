import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
    static int[] answer;
    static int counter = 1;
    public static class Node {
        ArrayList<Integer> way;
        boolean visited = false;

        public Node(ArrayList way) {
            this.way = way;
            this.visited = false;
        }

        public void setNode(int n) {
            this.way.add(n);
        }
        public void sort() {
            Collections.sort(this.way);
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n, m, r;
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        Node[] node = new Node[n];
        answer = new int[n];
        for(int i = 0; i < n; i++) {
            node[i] = new Node(new ArrayList<Integer>());
        }

        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int temp1 = Integer.parseInt(st.nextToken());
            int temp2 = Integer.parseInt(st.nextToken());
            node[temp1 - 1].setNode(temp2 - 1);
            node[temp2 - 1].setNode(temp1 - 1);
        }

        for(int i = 0; i < n; i++) {
            node[i].sort();
        }

        dfs(node, r - 1, 0);

        for(int i = 0; i < answer.length; i++) {
            bw.write(answer[i] + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static void dfs(Node[] node, int start, int end) {
        if(node[start].visited) {
            return;
        }
        node[start].visited = true;
        answer[start] = counter++;
        for(int i = 0; i < node[start].way.size(); i++) {
            dfs(node, (Integer) node[start].way.get(i), end);
        }
    }
}
