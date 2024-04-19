import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        int[] material = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for(int i = 0; i < n; i++) {
            material[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(material);
        int start = 0;
        int end = n - 1;
        int answer = 0;
        while(start < end) {
            int temp = material[start] + material[end];
            if (temp < m) {
                start++;
            } else if (temp > m) {
                end--;
            } else {
                answer++;
                end--;
            }
        }
        System.out.println(answer);
    }
}