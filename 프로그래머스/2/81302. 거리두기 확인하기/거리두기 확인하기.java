import java.util.*;
class Solution {
    char[][] cPlaces = new char[5][5];
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        
        for(int p = 0 ; p < places.length ; p++) {
            String[] place = places[p];
            boolean result = true;
            
            cPlaces = new char[5][5];
            for (int i = 0 ; i < 5 ; i++) {
                cPlaces[i] = place[i].toCharArray();
            }
            
            for (int i = 0 ; i < 5 && result ; i++) {
                for (int j = 0 ; j < 5 ; j++) {
                    if (cPlaces[i][j] == 'P') {
                        result = bfs(i, j);
                        if(!result) break;
                    }
                }
            }
            
            answer[p] = result ? 1: 0;
        }
        
        return answer;
    }
    
    boolean bfs(int r, int c) {
        Deque<int[]> queue = new ArrayDeque<>();
        boolean[][] visited = new boolean[5][5];

        queue.offerLast(new int[]{r, c, 0});
        visited[r][c] = true;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int R = now[0];
            int C = now[1];
            int dist = now[2];
            
            if (cPlaces[R][C] == 'P' && dist > 0 && dist <= 2) {
                return false;
            }
            
            if (dist == 2) continue;
            
            for(int i = 0 ; i < 4 ; i++) {
                int x = R + dr[i];
                int y = C + dc[i];
                
                if (x >= 0 && x < 5 && y >= 0 && y < 5) {
                    if (visited[x][y] || cPlaces[x][y] == 'X') continue;

                    visited[x][y] = true;
                    queue.offerLast(new int[]{x, y, dist + 1});
                }
            }
        }

        return true;
    }
}