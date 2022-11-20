import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        //케이스 갯수, 케이스 받기
        int c;

        c = Integer.parseInt(br.readLine());

        String[] str1 = new String[c];
        for(int i = 0; i < c; i++) {
            str1[i] = br.readLine();
        }
        
        //평균을 구한 후 비율 구하기
        int sum = 0, cnt = 0, n;
        double avr, ratio;
        String[] str2;

        for(int i = 0; i < c; i++) {
            //감시배열에 케이스 입력, n은 학생 수
            str2 = str1[i].split(" ");
            n = Integer.parseInt(str2[0]);
            //평균 구하기
            for(int j = 1; j < str2.length; j++) {
                sum += Integer.parseInt(str2[j]);
            }
            avr = (double) sum / n;
            
            //비율 구하기, cnt는 평균을 넘긴 학생 수
            for(int j = 1; j < str2.length; j++) {
                if (Integer.parseInt(str2[j]) > avr) {
                    cnt++;
                }
            }
            ratio = (double) cnt / (double) n * 100.0;
            System.out.printf("%.3f", ratio);
            System.out.println("%");
            //다음 케이스를 위해 sum과 cnt 0으로 초기화
            sum = 0;
            cnt = 0;
        }
        br.close();
    }
}
