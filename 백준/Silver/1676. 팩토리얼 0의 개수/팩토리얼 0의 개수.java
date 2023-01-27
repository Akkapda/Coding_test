import java.io.*;
import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        BigInteger n = new BigInteger(br.readLine());

        String result = Factorial(n).toString();

        int cnt = 0;    //0 카운터

        for(int i = result.length() - 1; i > 0; i--) {
            if (result.charAt(i) == '0') {
                cnt++;  //result의 맨 끝 index부터 탐색해서 '0'인경우 카운팅
            }
            else break; //0이 아닌 char가 감지되면 break
        }

        bw.write(cnt + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static BigInteger Factorial(BigInteger n) {
        BigInteger result = new BigInteger("1");    //팩토리얼 결과값
        BigInteger sub = new BigInteger("1");   //--역할을 해줄 subtract요소
        while (n.intValue() > 1) {
            result = result.multiply(n);    //결과값에 곱하고
            n = n.subtract(sub);            //n--
        }

        return result;
    }
}
