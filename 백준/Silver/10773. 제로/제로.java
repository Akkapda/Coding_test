import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int k = Integer.parseInt(br.readLine());

        Stack<Integer> stack = new Stack<>();
        int answer = 0;
        for(int i = 0; i < k; i++) {
            int temp = Integer.parseInt(br.readLine());
            if (temp == 0 && !stack.isEmpty()) {
                answer -= stack.pop();
            } else {
                stack.push(temp);
                answer += temp;
            }
        }

        System.out.println(answer);
    }
}
