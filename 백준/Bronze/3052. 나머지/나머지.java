import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ar1 = new int[10]; //10개의 수를 입력받을 배열
        int[] ar2 = new int[10]; //% x 나머지를 입력받을 배열
        final int x = 42; //x 값
        int cnt = 0; //나머지의 개수를 카운트

        //10개 수 입력받기
        for(int i = 0; i < 10; i++) {
            ar1[i] = Integer.parseInt(br.readLine());
        }

        //나머지 ar2에 입력
        for(int i = 0; i < 10; i++) {
            ar2[i] = ar1[i] % x;
        }

        //첫 나머지는 cnt = 1해두고 반복문에서 제외
        //나머지를 보며 중복시 temp값을 증가
        //temp값이 한번이라도 증가되어 있으면 (중복이 한개라도 있으면) 진행
        //temp값이 0이면 (중복이 한개도 없었으면) cnt 증가
        cnt = 1;
        for(int i = 1; i < 10; i++) {
            int temp = 0;
            for(int j = 0; j < i; j++) {
                if (ar2[j] == ar1[i] % x) {
                    temp++;
                }
            }
            if (temp > 0) {
                continue;
            }
            else {
                cnt++;
            }
        }
        br.close();
        System.out.println(cnt);
    }
}
