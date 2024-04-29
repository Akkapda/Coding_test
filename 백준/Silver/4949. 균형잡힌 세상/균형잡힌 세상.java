import java.io.*;
import java.util.Stack;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        Stack<Character> stack = new Stack<>();

        while(true) {
            String str = br.readLine();
            stack.clear();
            if (".".equals(str)) {
                break;
            } else {
                for(int i = 0; i < str.length(); i++) {
                    char c = str.charAt(i);
                    if (c == '[' || c == '{' || c == '(') {
                        stack.push(c);
                    } else if (stack.isEmpty()) {
                        if (c == ']' || c == '}' || c == ')') {
                            stack.push(c);
                            break;
                        }
                    } else if (c == ']') {
                        if (stack.peek() == '[') {
                            stack.pop();
                        } else stack.push(c);
                    } else if (c == '}') {
                        if (stack.peek() == '{') {
                            stack.pop();
                        } else stack.push(c);
                    } else if (c == ')') {
                        if (stack.peek() == '(') {
                            stack.pop();
                        } else stack.push(c);
                    }
                }
            }
            if (!stack.empty()) {
                bw.write("no\n");
            } else bw.write("yes\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
