import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (a, b) -> Integer.compare(a[1], b[1]));
        
        int end = -1;
        
        for(int i = 0 ; i < targets.length ; i++) {
            int[] target = targets[i];
            
            if (target[0] >= end) {
                end = target[1];
                answer++;
            }
        }
        
        return answer;
    }
}