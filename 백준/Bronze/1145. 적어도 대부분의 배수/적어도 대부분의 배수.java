import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] arr = new int[5];
        for (int i = 0; i < 5; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        int start = 1;
        while(true) {
            int count = 0;
            for(int i = 0; i < 5; i++) {
                if (start % arr[i] == 0) {
                    count++;
                }
            }
            if (count > 2) {
                break;
            }
            start++;
        }

        System.out.println(start);
    }
}
