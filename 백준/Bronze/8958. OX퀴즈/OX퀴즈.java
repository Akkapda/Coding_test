import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 케이스 갯수
        int n = Integer.parseInt(br.readLine());

        //테스트 케이스, 감시 케이스 문자열, O 정답카운터, sum 합
        String[] str1 = new String[n];
        char[] str2 = new char[80];
        int o = 0, sum = 0;

        //테스트 케이스 입력받기
        for(int i = 0; i < n; i++) {
            str1[i] = br.readLine();
        }

        //테스트 케이스를 감시 케이스에 입력하여 OX 추리기
        for(int i = 0; i < n; i++) {
            //감시 케이스에 입력
            int j = 0;
            while (j < str1[i].length()) {
                str2[j] = str1[i].charAt(j);
                j++;
            }

            //감시케이스에서 OX 검출
            //각 케이스 시작 시 O 카운터 초기화
            o = 0;
            for(int q = 0; q < str1[i].length(); q++) {
                //O : ++ 후 sum에 합
                if (str2[q] == 'O') {
                    o++;
                    sum += o;
                }
                //X : 카운터 초기화
                else if (str2[q] == 'X') {
                    o = 0;
                }
            }
            //sum 출력 후 초기화
            System.out.println(sum);
            sum = 0;
        }
        br.close();
    }
}
