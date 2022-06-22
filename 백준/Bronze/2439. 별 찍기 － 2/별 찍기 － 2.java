import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            for(int j = 0; j < N - i; j++) {
                System.out.printf(" ");
            }
            for(int q = 0; q < i; q++) {
                System.out.printf("*");
            }
            System.out.println("");
        }
    }
}
