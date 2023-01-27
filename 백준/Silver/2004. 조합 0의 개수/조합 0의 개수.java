import java.io.*;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        //N, M 입력
        long n = Long.parseLong(st.nextToken());
        long m = Long.parseLong(st.nextToken());

        //5의 승수와 2의 승수를 계산
        //2와 5 를 짝지으면 10이 되는 것을 이용
        //2와 5의 승수 중 작은 것을 출력
        int five = getFivePow(n) - getFivePow(n - m) - getFivePow(m);
        int two = getTwoPow(n) - getTwoPow(n - m) - getTwoPow(m);

        bw.write(Math.min(five, two) + "");

        br.close();
        bw.flush();
        bw.close();
    }

    public static int getFivePow(long num) {
        //5의 승수 계산
        int cnt = 0;
        while (num >= 5) {
            cnt += num / 5;
            num /= 5;
        }

        return cnt;
    }

    public static int getTwoPow(long num) {
        //2의 승수 계산
        int cnt = 0;
        while (num >= 2) {
            cnt += num / 2;
            num /= 2;
        }

        return cnt;
    }
}