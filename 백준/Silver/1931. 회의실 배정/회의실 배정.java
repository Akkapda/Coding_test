import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static class Meetings implements Comparable<Meetings> {
        int start;
        int end;

        //객체배열
        public Meetings(int start, int end) {
            this.start = start;
            this.end = end;
        }
        //sort를 위한 compareTo 메소드 정의
        @Override
        public int compareTo(Meetings o) {
            if (this.end == o.end) {
                return this.start - o.start; // 종료 시간이 같을 경우, 시작 시간에 따라 정렬
            }
            return this.end - o.end;
        }
    }

    public static void main(String[] args) throws IOException {
        int n = Integer.parseInt(br.readLine());
        int start = 0, end = 0;
        StringTokenizer st;
        Meetings[] meetings = new Meetings[n];
        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            start = Integer.parseInt(st.nextToken());
            end = Integer.parseInt(st.nextToken());
            meetings[i] = new Meetings(start, end);
        }

        //end를 기준으로 배열정리
        //예제에선 이미 end를 기준으로 정렬이 되어있다.
        Arrays.sort(meetings);

        //정렬이 되어있으므로 가장 빨리 끝나는 end부터 시작 -> 이미 한 회의를 정한것이므로 cnt 1부터 시작
        int cnt = 1;

        int lastMeeting = meetings[0].end;

        for (int i = 1; i < n; i++) {
            if (meetings[i].start >= lastMeeting) {
                cnt++;
                lastMeeting = meetings[i].end;
            }
        }

        bw.write(cnt + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
