import java.io.*;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br;
    static BufferedWriter bw;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new InputStreamReader(System.in));
        bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //단위 면적별 참외 수 n
        int n = Integer.parseInt(br.readLine());

        int[] len = new int[6];
        int[] dir = new int[6];

        //참외밭 제원 받기
        for(int i = 0; i < 6; i++) {
            st = new StringTokenizer(br.readLine());

            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
        }

        //참외밭 모양 알기
        //큰 사각형과 제외 될 작은 사각형을 알기 위함
        int[] cnt = new int[4];
        Shape(dir, cnt);
        //큰 사각형의 크기와 작은사각형의 크기 구해서 밭 넓이 구하기
        int area = Cal_Area(cnt, len, dir);

        //계산
        bw.write("" + (area * n));

        br.close();
        bw.flush();
        bw.close();
    }

    public static void Shape(int[] dir, int[] cnt) {
        int s = 0;

        for(int i = 0; i < 6; i++) {
            if (dir[i] == 1) {
                cnt[0]++;
            }
            else if (dir[i] == 2) {
                cnt[1]++;
            }
            else if (dir[i] == 3) {
                cnt[2]++;
            }
            else {
                cnt[3]++;
            }
        }
    }

    public static int Cal_Area(int[] cnt, int[] len, int[] dir) {
        //가장 긴 변(큰 사각형의 변) 두개 a,b구하기
        //1.a와 b 방향 찾기
        //cnt값이 1인 경우 긴 변
        int a = 0, b = 0;
        for(int i = 0; i < cnt.length; i++) {
            if (cnt[i] == 1) {
                if (a == 0)
                    a = i + 1;
                else b = i + 1;
            }
        }
        //해당 인덱스의 길이 = a와 b 의 길이
        //index1,2 는 작은 사각형(제외될 부분) 의 index
        int aL = 0, bL = 0, index1 = 0, index2 = 0;
        for(int i = 0; i < dir.length; i++) {
            if (dir[i] == a) {
                aL = len[i];
                index1 = (i + 3) % 6;
            }
            else if (dir[i] == b) {
                bL = len[i];
                index2 = (i + 3) % 6;
            }
        }
        //큰 사각형 넓이
        int largeS = aL * bL;
        //작은 사각형 넓이
        int smallS = len[index1] * len[index2];

        return largeS - smallS;
    }
}
