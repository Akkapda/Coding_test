import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Queue queue = new LinkedList();

        for(int i = 1; i <= n; i++) {
            queue.add(i);
        }

        while (queue.size() > 1) {
            card2(queue);
        }

        System.out.println(queue.remove());

        br.close();
    }

    public static void card2(Queue queue) {
        queue.remove();
        queue.add(queue.remove());
    }
}
