import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public static void main(String[] args) throws IOException {
        //도현이 집 개수 n
        //공유기 개수 c
        //c개를 무조건 설치해야하는데 가장 가까운 공유기의 거리가 가장 먼 경우를 알아야함
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        //n개의 집의 좌표를 받음
        int cordination[] = new int[n];
        for(int i = 0; i < n; i ++) {
            cordination[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(cordination);
        //c개를 무조건 설치해야 하니까 이분탐색조건이 중요하다.
        //최대거리를 두고 최대거리보다 작아지면 갱신하는 경우는 인접 공유기의 최소거리를 구하게 됨
        //인접한 공유기의 최대 거리를 구하려면?
        //인접한 공유기의 거리를 0으로두고 크면 갱신시키는 방식이지만,
        //이걸 이분탐색으로 어케하냐
        //공유기 사이 거리의 최대값과 최소값을 정한다.
        //최소 = 1 최대 = 정렬했으니까 0인덱스 ~ 끝 인덱스 값.
        int minDistance = 0;
        int maxDistance = cordination[cordination.length - 1] - cordination[0];
        //여기에 middle 을 구하고
        int middle;
        //그 거리만큼 띄워서 공유기를 둔다.
        int currentAP; //첫 집에 무조건 공유기를 두고
        int nextAP; //다음에 공유기를 둘 자리를 여기다 씀.
        int maxAP; //공유기 설치 개수
        //이 때 between값을 구해서 최대거리를 갱신시킨다.
        //여기서 1. 가장 인접한 공유기 2. 의 최대거리이므로
        //between은 낮은걸로 갱신, 최대거리는 큰거로 갱신해야함 -> between은 초기값이 최대거리, 최대거리는 초기값이 0.
        int between;
        int answer = 0; //얘는 최종 답안으로 쓸거라 미리 초기화를 시키고 while문 안에서 하면 안됨.
        //while문 돌리고
        while(minDistance <= maxDistance) {
            //초기값 설정해야하는 변수들 초기화해줌
            //첫 집에 무조건 두기때문에 c - 1개만큼 설치해야함.
            middle = (minDistance + maxDistance) / 2;
            nextAP = cordination[0] + middle;
            between = maxDistance;
            maxAP = c - 1;
            currentAP = 0;
            //for문 index로 돌리고
            //첫번째 자리에 무조건 공유기를 둔다.
            for(int i = 1; i < n; i++) {
                //이번 index에 mmiddle만큼 떨어졌거나 그보다 멀다면
                if (cordination[i] - cordination[currentAP] >= middle) {
                    //공유기를 두고 between을 구한 다음 갱신시킨다.
                    maxAP--;
                    if (between > cordination[i] - cordination[currentAP]) {
                        between = cordination[i] - cordination[currentAP];
                    }
                    currentAP = i;
                }
                //불필요한 것 같음
//                else if (i == n - 1 && maxAP == 1) {
//                    maxAP--;
//                    if (between > cordination[i] - cordination[currentAP]) {
//                        between = cordination[i] - cordination[currentAP];
//                    }
//                }

            }
            //다 돌았을 때 설치를 못함 -> 마지막까지 middle만큼 멀어지지 않았음
            if (maxAP > 0) {
                maxDistance = middle - 1;
            } else {
                minDistance = middle + 1;
                if (answer < between) {
                    answer = between;
                }
            }
        }
        bw.write(answer + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
