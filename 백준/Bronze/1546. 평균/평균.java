import java.io.*;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        double sum = 0;
        double max = 0;

        while(st.hasMoreTokens()) {
            int temp = Integer.parseInt(st.nextToken());
            if (max < temp) {
                max = temp;
            }
            sum += temp;
        }

        double avg = (sum / n) / max * 100;

        System.out.println(avg);
    }
}