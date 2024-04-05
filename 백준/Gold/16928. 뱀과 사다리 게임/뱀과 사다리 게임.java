import java.io.*;
import java.util.*;

public class Main {
    static Map<Integer, Integer> ladder = new HashMap<>();
    static Map<Integer, Integer> snake = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            ladder.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        for(int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            snake.put(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }
        //사다리나 뱀을 만나면 무조건 타야한다.
        //카운트가 레벨인 너비탐색
        //map을 써서 사다리랑 뱀을 만들면?
        //key 값 넣어서 value를 받아오는 식으로 하고
        //그냥 사다리와 뱀을 타지 않는 최대치를 구하기도 쉬워진다.

        int currentPosition = 0;
        int count = 0;
        Queue<Integer> queue = new LinkedList();
        queue.add(1);

        while(currentPosition < 100) {
            int num = queue.size();
            for(int i = 0; i < num; i++) {
                //현재 채워진 큐까지 체크
                int temp = 0;
                currentPosition = queue.poll();
                if(100 - currentPosition <= 6) {
                    //현재위치에서 주사위 굴리기 만으로 100에 도달
                    currentPosition = 100;
                    count++;
                    break;
                }
                //일단 앞의 6칸 체크
                for(int j = 6; j > 0; j--) {
                    int nextPosition = currentPosition + j;
                    if (ladder.containsKey(nextPosition)) {
                        //사다리를 탈 수 있음
                        queue.add(ladder.get(nextPosition));
                    } else if (snake.containsKey(nextPosition)) {
                        //뱀을 탈 수 있음
                        queue.add(snake.get(nextPosition));
                    } else {
                        //둘 다 타지 않는 선에서 최대로 갈 수 있는 거리
                        if (nextPosition > temp) {
                            temp = nextPosition;
                            queue.add(temp);
                        }
                    }
                }
            }
            if (currentPosition < 100) {
                //위에서 100까지 도달하지 못했다.
                count++;
            }
        }

        System.out.println(count);
    }
}
