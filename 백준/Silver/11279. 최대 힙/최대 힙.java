import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int temp;

        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return - Integer.compare(o1,o2);
            }
        });

        for (int i = 0; i < n; i++) {
            temp = Integer.parseInt(br.readLine());
            if (temp == 0) {
                if (maxHeap.isEmpty()) {
                    bw.write('0' + "\n");
                }
                else {
                    bw.write(maxHeap.peek() + "\n");
                    maxHeap.remove(maxHeap.peek());
                }
            }
            else {
                maxHeap.add(temp);
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
