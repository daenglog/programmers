import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        Arrays.sort(routes, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        int answer = 0;
        
        int end = Integer.MIN_VALUE;
        
        for (int i = 0; i < routes.length ; i++) {
            int[] r = routes[i];
            
            if (r[0] > end) {
                answer++;
                end = r[1];
            }
        }
        
        return answer;
    }
}