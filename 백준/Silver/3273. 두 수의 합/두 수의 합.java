import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int x = Integer.parseInt(br.readLine());

        Arrays.sort(array);
        int answer = 0;
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int tmp = array[left] + array[right];
            if (tmp < x) {
                left++;
            } else if (tmp > x) {
                right--;
            } else {
                answer++;
                left++;
                right--;
            }
        }
        System.out.println(answer);

        br.close();
    }
}