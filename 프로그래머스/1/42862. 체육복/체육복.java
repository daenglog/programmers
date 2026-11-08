import java.util.*;
class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        int[] hasClothes = new int[n+1];
        Arrays.fill(hasClothes, 1);
        hasClothes[0] = 0;
        
        for (int l : lost) hasClothes[l]--;
        for (int r : reserve) hasClothes[r]++;
        
        for(int i = 1 ; i <= n ; i++) {
            if (hasClothes[i] != 2) continue;
            
            if (i == 1 && hasClothes[i+1] == 0) {
                hasClothes[i + 1]++;
                hasClothes[i]--;
            } else if (i == n && hasClothes[i-1] == 0) {
                hasClothes[i - 1]++;
                hasClothes[i]--;
            } else if (i > 1 && i < n) {
                if (hasClothes[i-1] == 0) {
                    hasClothes[i-1]++;
                    hasClothes[i]--;
                } else if (hasClothes[i+1] == 0) {
                    hasClothes[i + 1]++;
                    hasClothes[i]--;
                }
            }
        }
        
        for(int i = 1 ; i <= n ; i++) {
            if(hasClothes[i] >= 1)
                answer++;
        }
        
        return answer;
    }
}