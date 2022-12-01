import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collections;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = 0;

        String str = br.readLine();
        String[] strArray = new String[str.length()];

        for(int i = 0; i < str.length(); i++) {
            strArray[i] = Character.toString(str.charAt(i));
        }

        Arrays.sort(strArray, Collections.reverseOrder());

        str = "";
        str = String.join("", strArray);

        BigInteger bigInteger1 = new BigInteger(str);
        BigInteger bigInteger2 = new BigInteger("30");
        BigInteger bigInteger3 = bigInteger1.remainder(bigInteger2);

        if (bigInteger3.intValue() > 0) {
            System.out.println(-1);
            return;
        }

        System.out.println(str);

        br.close();
    }

}
