import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] ar1 = new int[30]; //제출자 입력받을 배열
        int[] ar2 = new int[30]; //모든 학생 출석번호 배열
        int[] ar3 = new int[30]; //미제출자 학생 출석번호 배열
        int cnt = 0;

        //제출자 입력받기
        for (int i = 0; i < 28; i++) {
            ar1[i] = Integer.parseInt(br.readLine());
        }
        //모든 학생 출석번호 입력받기
        for (int i = 0; i < 30; i++) {
            ar2[i] = i + 1;
        }
        //temp1 = 미제출자의 index
        //temp2 선언 후 제출자 배열을 모든 학생배열로 검출
        //제출자 번호가 탐색되면 temp++
        //해당 번호가 없을 시 (temp가 그대로 0일 경우) ar2[i]를 ar3[temp2]로 입력 후 temp1++
        int temp1 = 0;
        for(int i = 0; i < ar2.length; i++) {
            int temp2 = 0;
            for(int j = 0; j < ar1.length; j++) {
                if (ar1[j] == ar2[i]) {
                    temp2++;
                }
            }
            if (temp2 == 0) {
                ar3[temp1++] = ar2[i];
            }
        }
        for(int i = 0; i < temp1; i++) {
            System.out.println(ar3[i]);
        }
        br.close();
    }
}
