import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;       // 행의 수
        int m = maps[0].length;    // 열의 수
        
        // BFS를 이용한 최단 경로 탐색
        return bfs(maps, n, m);
    }
    
    public int bfs(int[][] maps, int n, int m) {
        int[] moveX = {1, 0, -1, 0}; // 동, 남, 서, 북
        int[] moveY = {0, 1, 0, -1}; 
        
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {0, 0});  // 시작점 (0, 0)
        
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            int x = current[1];
            int y = current[0];
            
            // 목표 지점에 도착했을 때
            if (y == n - 1 && x == m - 1) {
                return maps[y][x];  // 최단 경로 리턴
            }
            
            for (int i = 0; i < 4; i++) {
                int newX = x + moveX[i];
                int newY = y + moveY[i];
                
                if (newX >= 0 && newY >= 0 && newX < m && newY < n && maps[newY][newX] == 1) {
                    maps[newY][newX] = maps[y][x] + 1;
                    queue.offer(new int[] {newY, newX});
                }
            }
        }
        
        // 도달할 수 없는 경우
        return -1;
    }
}