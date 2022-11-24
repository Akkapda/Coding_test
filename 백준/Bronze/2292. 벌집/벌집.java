import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        //방의 개수 cnt
        int cnt = 1;
        //6의 공차를 가진 수열 a를 공차로 가지는 수열 A
        //temp1을 A의 각 항으로 하고 temp2를 6공차를 가진 수열 a로 한다.
        int temp1 = 1, temp2 = 6;



        while(true) {
            if (n == 1) {
                System.out.printf("1");
                break;
            }
            //항의 범위에 존재하는 경우 (현재 항부터 다음 항까지)
            else if (n > temp1 && n <= temp1 + temp2) {
                cnt++;
                System.out.println(cnt);
                break;
            }
            //항의 범위에 존재하지 않는 경우
            //방의 개수를 늘리고 항과 공차를 갱신
            else {
                cnt++;
                temp1 += temp2;
                temp2 += 6;
            }
        }
        br.close();
    }
}
