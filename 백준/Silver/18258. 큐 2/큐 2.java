import java.io.*;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        Deque<Integer> queue = new LinkedList<>();
        StringTokenizer st;
        String action = "";


        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            action = st.nextToken();
            int temp = 0;
            if (st.hasMoreTokens()) {
                temp = Integer.parseInt(st.nextToken());
            }

            //push
            if ("push".equals(action)) {
                queue.add(temp);
            } else if ("pop".equals(action)) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.remove() + "\n");
                }
            } else if ("size".equals(action)) {
                bw.write(queue.size() + "\n");
            } else if ("empty".equals(action)) {
                if (queue.isEmpty()) {
                    bw.write(1 + "\n");
                } else {
                    bw.write(0 + "\n");
                }
            } else if ("front".equals(action)) {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.peek() + "\n");
                }
            } else {
                if (queue.isEmpty()) {
                    bw.write(-1 + "\n");
                } else {
                    bw.write(queue.getLast() + "\n");
                }
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
