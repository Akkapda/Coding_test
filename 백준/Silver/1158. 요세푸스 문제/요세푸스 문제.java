import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue queue = new LinkedList();
        int i = 1;

        while (i <= n) {
            queue.add(i++);
        }

        System.out.printf("<");
        while (!queue.isEmpty()) {
            josephus(queue, k);
            if (!queue.isEmpty()) {
                System.out.printf(", ");
            }
        }
        System.out.printf(">");

        br.close();
    }
    public static void josephus(Queue queue, int k) {
        for(int i = 0; i < k - 1; i++) {
            queue.add(queue.remove());
        }
        System.out.printf("%d", queue.remove());
    }
}
