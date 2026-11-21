import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] c = new int[n+1];
        Arrays.fill(c, 1);
        c[0] = 0;
        
        for(int r : reserve) {
            c[r]++;
        }
        
        for(int l : lost) {
            c[l]--;
        }
        
        for(int i = 1 ; i <= n ; i++) {
            if (c[i] != 0) continue;
            
            if (i == 1) {
                if (c[i+1] == 2) {
                    c[i]++;
                    c[i+1]--;
                }
            } else if (i == n) {
                if (c[i-1] == 2) {
                    c[i]++;
                    c[i-1]--;
                }
            } else if (i > 1 && i < n) {
                if (c[i-1] == 2) {
                    c[i]++;
                    c[i-1]--;
                } else if (c[i+1] == 2) {
                    c[i]++;
                    c[i+1]--;
                }
            }
        }
        
        for(int i = 1 ; i<=n ; i++) {
            if(c[i] != 0)
                answer++;
        }
        
        return answer;
    }
}