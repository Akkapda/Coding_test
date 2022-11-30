import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int num, sum = 0;

        for(int i = 0; i < k; i++) {
            num = Integer.parseInt(br.readLine());
            if (num == 0) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            }
            else stack.push(num);
        }
        
        int n = stack.size();

        for(int i = 0; i < n; i++) {
            sum += stack.pop();
        }

        System.out.println(sum);
        br.close();
    }
}
