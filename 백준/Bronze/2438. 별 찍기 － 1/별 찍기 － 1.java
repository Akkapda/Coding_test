import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N;

        N = Integer.parseInt(br.readLine());

        if (N >=1 && N <=100) {
            for(int i = 1; i <= N; i++) {
                for(int j = 0; j < i; j++) {
                    System.out.printf("*");
                }
                System.out.println("");
            }
        }
    }
}
