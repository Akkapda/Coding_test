import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        int N;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            System.out.println(i);
        }
    }
}