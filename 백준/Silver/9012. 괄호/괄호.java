import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        String[] str = new String[n];

        for(int i = 0; i < n; i++) {
            str[i] = br.readLine();
        }

        Stack<Character> stack = new Stack<>();

        bracket_check(stack, str, n);

        br.close();
    }
    public static void bracket_check(Stack<Character> stack, String[] str, int n) {
        for(int i = 0; i < n; i++) {
            stack.clear();
            if (str[i].charAt(0) != ')') {
                stack.push(str[i].charAt(0));

                for(int j = 1; j < str[i].length(); j++) {
                    if (str[i].charAt(j) == '(') {
                        stack.push(str[i].charAt(j));
                    }
                    else {
                        if (stack.empty()) {
                            stack.push(')');
                            break;
                        }
                        else stack.pop();
                    }
                }
                if (stack.isEmpty()) {
                    System.out.printf("YES\n");
                }
                else System.out.printf("NO\n");
            }
            else System.out.printf("NO\n");

        }
    }
}
