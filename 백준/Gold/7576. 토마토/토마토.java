import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {
    static int[][] tomatoBox;
    static int day = 0;
    static Queue<Integer> checkQueue = new LinkedList<>();
    static int counter = 0;

    public static void main(String[] args) throws IOException{
        //토마토를 하루마다 익게함
        //동서남북 방향으로 익게함
        //모든 토마토가 익는데 걸리는 일 수 출력
        //모든 토마토가 익지 못하면 -1 출력
        //1은 익은 토마토, 0은 익지 않은 토마토, -1은 토마토가 없는 칸
        //큐나 스택같은걸 써서 시간을 줄인다. (이미 주변에 변화를 준 토마토는 체크할 필요가 없다)
        //따라서 변화를 한 토마토의 위치를 큐에 넣고 큐에서 빼면서 주변을 체크한다.
        int m , n;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        tomatoBox = new int[n][m];

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                tomatoBox[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        firstCheck();
        while(true) {
            if (afterCheck()) {
                if (checkBox()) {
                    bw.write(day + "\n");
                    break;
                }
                else {
                    bw.write("-1\n");
                    break;
                }
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
    public static boolean checkBox() {
        for(int i = 0; i < tomatoBox.length; i++) {
            for(int j = 0; j < tomatoBox[i].length; j++) {
                if(tomatoBox[i][j] == 0) {
                    return false;
                }
            }
        }
        return true;
    }
    public static void firstCheck() {
        for(int i = 0; i < tomatoBox.length; i++) {
            for(int j = 0; j < tomatoBox[i].length; j++) {
                if(tomatoBox[i][j] == 1) {
                    checkQueue.add(i);
                    checkQueue.add(j);
                    counter++;
                }
            }
        }
    }
    public static boolean afterCheck() {
        int temp = counter;
        counter = 0;
        for(int i = 0; i < temp; i++) {
            int boxI = checkQueue.poll();
            int boxJ = checkQueue.poll();
            if(boxI - 1 >= 0 && tomatoBox[boxI - 1][boxJ] == 0) {
                checkQueue.add(boxI - 1);
                checkQueue.add(boxJ);
                tomatoBox[boxI - 1][boxJ] = 1;
                counter++;
            }
            if(boxI + 1 < tomatoBox.length && tomatoBox[boxI + 1][boxJ] == 0) {
                checkQueue.add(boxI + 1);
                checkQueue.add(boxJ);
                tomatoBox[boxI + 1][boxJ] = 1;
                counter++;
            }
            if(boxJ - 1 >= 0 && tomatoBox[boxI][boxJ - 1] == 0) {
                checkQueue.add(boxI);
                checkQueue.add(boxJ - 1);
                tomatoBox[boxI][boxJ - 1] = 1;
                counter++;
            }
            if(boxJ + 1 < tomatoBox[0].length && tomatoBox[boxI][boxJ + 1] == 0) {
                checkQueue.add(boxI);
                checkQueue.add(boxJ + 1);
                tomatoBox[boxI][boxJ + 1] = 1;
                counter++;
            }
        }
        if(counter > 0) {
            day++;
            return false;
        }
        return true;
    }
}
