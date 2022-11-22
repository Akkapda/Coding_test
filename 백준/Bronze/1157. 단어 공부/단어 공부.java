import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //a = 97, A = 65
        String str = br.readLine();

        int[] alpha = new int[26];
        
        //alpha[]의 index = 알파벳, 데이터값 = 개수
        for(int i = 0; i < str.length(); i++) {
            if ((int)str.charAt(i) > 96 && (int)str.charAt(i) < 123) {
                alpha[(int)str.charAt(i) - 97] += 1;
            }
            else if ((int)str.charAt(i) > 64 && (int)str.charAt(i) < 91) {
                alpha[(int)str.charAt(i) - 65] += 1;
            }
        }
        
        //temp1 = 최대개수인 알파벳, temp2 = ?스위치(동률)
        int temp1 = 0, temp2 = 0;
        for(int i = 1; i < alpha.length; i++) {
            if (alpha[temp1] < alpha[i]) {
                temp1 = i;
                //최대값 갱신되면 temp2 초기화
                temp2 = 0;
            }
            else if (alpha[temp1] == alpha[i]) {
                temp2 = -1;
            }
        }
        
        //temp2가 0이 아니면 (-1 이면) ?출력 (동률)
        if (temp2 == 0) {
            System.out.printf("%c", (char)(temp1 + 65));
        }
        else System.out.printf("?");

        br.close();
    }
}
