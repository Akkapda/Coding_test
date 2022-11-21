import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ar1 = new int[26];

        for(int i = 0; i < ar1.length; i++) {
            ar1[i] = -1;
        }

        String str = br.readLine();

        int num;
        for(int i = 0; i < str.length(); i++) {
            //a = 97 -> 0
            num = str.charAt(i) - 97;
            if (ar1[num] == -1)
                ar1[num] = i;
        }

        for(int i = 0; i < ar1.length; i++) {
            System.out.printf("%d ", ar1[i]);
        }
        br.close();

    }
}
