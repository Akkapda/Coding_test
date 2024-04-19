import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int start = 1, end = 1;
        int sum = 0;
        int answer = 0;

        while(start <= end) {
            sum = 0;
            for(int i = start; i <= end; i++) {
                sum += i;
            }
            if (sum < n) {
                end++;
            } else if (sum > n) {
                start++;
            } else {
                answer++;
                end++;
            }
        }
        System.out.println(answer);
    }
}