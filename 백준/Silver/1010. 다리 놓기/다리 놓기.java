import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //이항계수2 예제의 코딩 활용

        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            BigInteger n = new BigInteger(st.nextToken());
            BigInteger k = new BigInteger(st.nextToken());

            //두 수중 큰 수를 n 으로 입력
            if (n.intValue() > k.intValue()) {
                bw.write(Binomial_Coef(n, k) + "\n");
            }
            else bw.write(Binomial_Coef(k, n) + "\n");
        }

        br.close();
        bw.flush();
        bw.close();
    }

    public static BigInteger Binomial_Coef(BigInteger n, BigInteger k) {
        BigInteger bigInteger1 = new BigInteger("1");
        BigInteger bigInteger2 = new BigInteger("1");
        BigInteger bigInteger3 = new BigInteger("1");
        BigInteger num = n.subtract(k);
        BigInteger sub = new BigInteger("1");
        //n 팩토리얼
        while(n.intValue() > 1) {
            bigInteger1 = bigInteger1.multiply(n);
            n = n.subtract(sub);
        }
        //n-k 팩토리얼
        while(num.intValue() > 1) {
            bigInteger2 = bigInteger2.multiply(num);
            num = num.subtract(sub);
        }
        //k 팩토리얼
        while(k.intValue() > 1) {
            bigInteger3 = bigInteger3.multiply(k);
            k = k.subtract(sub);
        }

        return bigInteger1.divide(bigInteger2.multiply(bigInteger3));
    }
}
