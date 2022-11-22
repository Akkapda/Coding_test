import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //테스트 개수 받기
        int n = Integer.parseInt(br.readLine());

        //테스트 스트링, 테스트를 스플릿해둘 스트링
        String[] str1 = new String[n];
        String[] str2;

        //테스트 스트링 받기
        for(int i = 0; i < n; i++) {
            str1[i] = br.readLine();
        }

        //테스트 개수만큼 출력
        for(int i = 0; i < n; i++) {
            //테스트 스트링 스플릿해서 str2에 넣기
            str2 = str1[i].split(" ");
            //str2[1]의 길이까지 반복, str2[1].charAt을 str2[0]회 반복출력
            for(int j = 0; j < str2[1].length(); j++) {
                for(int q = 0; q < Integer.parseInt(str2[0]); q++) {
                    System.out.printf("%c", str2[1].charAt(j));
                }
            }
            System.out.println();
        }
        br.close();
    }
}
