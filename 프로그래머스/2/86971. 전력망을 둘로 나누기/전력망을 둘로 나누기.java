import java.util.*;
class Solution {
    HashMap<Integer, ArrayList<Integer>> map = new HashMap<>();
    public int solution(int n, int[][] wires) {
        int answer = n;
        
        for(int i = 1 ; i <= n ; i++) {
            map.put(i, new ArrayList<>());
        }
        
        for(int[] wire : wires) {
            ArrayList<Integer> tmp = map.get(wire[0]);
            ArrayList<Integer> tmp1 = map.get(wire[1]);
            tmp.add(wire[1]); tmp1.add(wire[0]);
            map.put(wire[0], tmp); map.put(wire[1], tmp1);
        }
        
        for(int[] wire : wires) {
            int res = bfs(wire[0], n, wire);
            int res1 = bfs(wire[1], n, wire);
            
            answer = Math.min(answer, Math.abs(res - res1));
        }
        
        
        return answer;
    }
    
    int bfs(int start, int n, int[] wire) {
        int res = 1;
        
        Deque<Integer> queue = new ArrayDeque<>();
        boolean[] visited = new boolean[n+1];
        
        queue.offerLast(start);
        visited[start] = true;
        
        while (!queue.isEmpty()) {
            int now = queue.pollFirst();
            
            for(int next : map.get(now)) {
                if(visited[next]) continue;
                if((now == wire[0] && next == wire[1])||(now == wire[1] && next == wire[0])) continue;
                
                queue.offerLast(next);
                visited[next] = true;
                res++;
            }
        }
        
        return res;
    }
}