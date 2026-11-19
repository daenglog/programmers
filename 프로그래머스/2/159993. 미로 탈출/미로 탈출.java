import java.util.*;
class Solution {
    char[][] map;
    int M; int N;
    public int solution(String[] maps) {
        int answer = 0;
        
        M = maps.length; N = maps[0].length();
        map = new char[M][N];
        
        int startX = -1; int startY = -1;
        int leverX = -1; int leverY = -1;
        int exitX = -1; int exitY = -1;
        for(int i = 0 ; i < M ; i++) {
            map[i] = maps[i].toCharArray();
            for(int j = 0 ; j < N ; j++) {
                if(map[i][j] == 'S') {
                    startX = i; startY = j;
                } else if(map[i][j] == 'L') {
                    leverX = i; leverY = j;
                } else if(map[i][j] == 'E') {
                    exitX = i; exitY = j;
                }
            }
        }
        
        int tmp = bfs(startX, startY, leverX, leverY, 0);
        
        if(tmp == Integer.MAX_VALUE) return -1;
        answer = bfs(leverX, leverY, exitX, exitY, tmp);
        
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }
    
    int bfs(int sX, int sY, int eX, int eY, int init) {
        Deque<int[]> queue =new ArrayDeque<>();
        int[][] dist = new int[M][N];
        for(int i = 0 ; i < M ; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        
        
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        
        queue.offerLast(new int[]{sX, sY});
        dist[sX][sY] = init;
        
        while (!queue.isEmpty()) {
            int[] now = queue.pollFirst();
            int r = now[0];
            int c = now[1];
            
            if (r == eX && c == eY) break;
            int cnt = dist[r][c];
            
            for(int i = 0 ; i < 4 ; i++) {
                int x = r + dr[i];
                int y = c + dc[i];
                
                if(x>=0 && x<M && y>=0 && y<N && dist[x][y] > cnt + 1) {
                    if(map[x][y] == 'X') continue;
                    queue.offerLast(new int[]{x, y});
                    dist[x][y] = cnt+1;
                }
            }
        }
        
        return dist[eX][eY];
    }
}