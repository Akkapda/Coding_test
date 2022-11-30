import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] ar = new int[n];

        for(int i = 0; i < n; i++) {
            ar[i] = Integer.parseInt(br.readLine());
        }

        int temp = 0, pop_cnt = 0, s_cnt = 1;
        Stack<Integer> stack = new Stack<>();
        Queue<Character> queue = new LinkedList<>();
        stack.push(s_cnt++);
        queue.add('+');

        while (pop_cnt < n) {
            if (!stack.isEmpty()) {
                if (stack.peek() == ar[temp]) {
                    stack.pop();
                    queue.add('-');
                    temp++;
                    pop_cnt++;
                }
                else {
                    if (stack.peek() > ar[temp]) {
                        System.out.printf("NO\n");
                        return;
                    }
                    else {
                        stack.push(s_cnt++);
                        queue.add('+');
                    }
                }
            }
            else if (s_cnt > n){
                System.out.printf("NO\n");
                return;
            }
            else if (stack.isEmpty()){
                    stack.push(s_cnt++);
                    queue.add('+');
            }
        }

        int num = queue.size();

        for(int i = 0; i < num; i++) {
            System.out.println(queue.remove());
        }

        br.close();

    }
}
