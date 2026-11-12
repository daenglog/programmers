import java.util.*;
class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        
        Arrays.sort(routes, (a, b) -> {
            return Integer.compare(a[1], b[1]);
        });
        
        int end = Integer.MIN_VALUE;
            
        for(int[] route: routes) {
            if(route[0] > end) {
                end = route[1];
                answer++;
            }
        }
            
        
        return answer;
    }
}