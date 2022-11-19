import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //n값 입력받기 (과목 갯수)
        int n;
        n = Integer.parseInt(br.readLine());

        //n값은 1000보다 작거나 같다
        if (n > 1000 || n < 0) {
            System.out.printf("n값은 1000보다 작거나 같아야 합니다.");
            return;
        }

        //토큰배열, 성적배열, 후처리배열 선언 후 성적배열에 n개만큼 입력받기
        String str;
        double[] ar1 = new double[n];
        double[] ar2 = new double[n];

        str = br.readLine();
        StringTokenizer st = new StringTokenizer(str);

        for(int i = 0; i < ar1.length; i++) {
            ar1[i] = Integer.parseInt(st.nextToken());
        }

        //temp = 최고값 찾기
        double temp = ar1[0];
        for(int i = 1; i < ar1.length; i++) {
            if (temp < ar1[i]) {
                temp = ar1[i];
            }
        }
        //(모든 성적이 0점이라 temp값이 0이면 종료)
        if (temp == 0) {
            System.out.printf("모든 성적이 0점입니다.\n");
            return;
        }

        //성적처리
        for(int i = 0; i < ar1.length; i++) {
            ar2[i] = ar1[i] / temp * 100;
        }

        //sum을 구해서 평균값 출력하기
        double sum = 0;
        for(int i = 0; i < ar1.length; i++) {
            sum += ar2[i];
        }

        System.out.printf("%.2f \n", sum / n);
        br.close();

    }
}
