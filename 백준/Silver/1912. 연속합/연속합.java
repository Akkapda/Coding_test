import java.io.*;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());


        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        //계속 더하다가 0보다 작아지면 앞에 버리기
        int answer = array[0];
        int sum = 0;

        for(int i = 0; i < array.length; i++) {
            //일단 더하고
            sum += array[i];
            answer = Math.max(sum, answer);
            //음수가 되면 의미가 없는 더하기이므로 버림
            if (sum < 0) {
                sum = 0;
            }
            //근데 음수는 아니지만 줄어들었을 가능성을 배제하기 위해 최대값찾기
        }
        System.out.println(answer + "");
    }
}
