import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //알파벳 체크를 위한 불린배열
        boolean[] b_array = new boolean[26];

        int n = Integer.parseInt(br.readLine());
        int cnt = n; //cnt는 모든 케이스 수 (후에 해당되지 않는 케이스만큼 개수 제거)

        String[] s_array = new String[n];
        
        //케이스 입력
        for(int i = 0; i < n; i++) {
            s_array[i] = br.readLine();
        }

        for(int i = 0; i < n; i++) {
            //b_array 초기화
            for(int j = 0; j < 26; j++) {
                b_array[j] = false;
            }
            //첫번째 알파벳을 true로 check
            b_array[(int)s_array[i].charAt(0) - 97] = true;
            for(int j = 1; j < s_array[i].length(); j++) {
                //연속되지 않은 알파벳이 온 경우
                if (s_array[i].charAt(j) != s_array[i].charAt(j - 1)) {
                    //check되지 않은 알파벳은 true로 check
                    if (b_array[(int)s_array[i].charAt(j) - 97] == false) {
                        b_array[(int)s_array[i].charAt(j) - 97] = true;
                    }
                    //이미 check된 알파벳이 온 경우 = 해당 케이스가 아니므로 cnt에서 제외후 break
                    else {
                        cnt--;
                        break;
                    }
                }
            }
        }
        System.out.println(cnt);
        br.close();
    }
}
