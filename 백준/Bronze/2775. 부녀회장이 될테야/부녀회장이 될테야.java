import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] k = new int[t];
        int[] n = new int[t];
        int[] ar1 = new int[14], ar2 = new int[14];

        for(int i = 0; i < t; i++) {
            k[i] = Integer.parseInt(br.readLine());
            n[i] = Integer.parseInt(br.readLine());
        }

        for(int i = 0; i < t; i++) {
            if (k[i] == 0) {
                System.out.println(n);
            }
            else if (n[i] == 1) {
                System.out.println(1);
            }
            else {
                ar2[0] = 1;
                for(int j = 0; j < n[i]; j++) {
                    ar1[j] = j + 1;
                }
                for(int j = 0; j < k[i]; j++) {
                    for(int q = 1; q < n[i]; q++) {
                        ar2[q] = ar2[q - 1] + ar1[q];
                    }
                    for(int q = 1; q < n[i]; q++) {
                        ar1[q] = ar2[q];
                    }
                }
                System.out.println(ar1[n[i] - 1]);
            }
        }
        br.close();
    }
}
