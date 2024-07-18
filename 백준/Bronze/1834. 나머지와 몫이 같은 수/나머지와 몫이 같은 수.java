import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        BigInteger n = new BigInteger(br.readLine());
        BigInteger sum = new BigInteger("0");
        BigInteger index = new BigInteger("1");

        for(int i = 1; i < n.intValue(); i++) {
            BigInteger temp = new BigInteger("0");
            temp = temp.add(n);
            temp = temp.multiply(index);
            temp = temp.add(index);
            sum = sum.add(temp);
            index = index.add(index.ONE);
        }

        System.out.println(sum);
    }
}