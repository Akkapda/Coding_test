import java.io.*;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();

        StringTokenizer st = new StringTokenizer(s);

        String a = st.nextToken();
        String b = st.nextToken();
        int cnt = 0;

        while(true) {
            //끝자리가 1인지 확인
            //한 자리수는 자를 수 없다
            if (b.length() > 1) {
                if (a.equals(b)) {
                    cnt++;
                    break;
                }
                if (b.charAt(b.length()-1) == '1') {
                        b = b.substring(0, b.length() - 1);
                        cnt++;
                }
                //아니면 나누기
                else {
                    //나누어 떨어질 경우
                    if (Integer.parseInt(b) % 2 == 0) {
                        b = Integer.toString(Integer.parseInt(b) / 2);
                        cnt++;
                    }
                    //안 나누어 떨어지면 조건 불일치
                    else {
                        cnt = -1;
                        break;
                    }
                    //끝까지 왔을 때 ( b가 a가 될 수 없는 조건)
//                    if (Integer.parseInt(a) + 1 == Integer.parseInt(b)) {
//                        cnt = -1;
//                        break;
//                    }
                }
            }
            else {
                if (a.equals(b)) {
                    cnt++;
                    break;
                }
                //나누어 떨어질 경우
                if (Integer.parseInt(b) % 2 == 0) {
                    b = Integer.toString(Integer.parseInt(b) / 2);
                    cnt++;
                }
                //안 나누어 떨어지면 조건 불일치
                else {
                    cnt = -1;
                    break;
                }
                //끝까지 왔을 때 ( b가 a로 될 수 없는 조건)
//                if (Integer.parseInt(a) + 1 == Integer.parseInt(b)) {
//                    cnt = -1;
//                    break;
//                }
            }
        }
        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
