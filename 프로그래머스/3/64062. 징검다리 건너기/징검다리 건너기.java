class Solution {
    public int solution(int[] stones, int k) {
        int left = 1; int right = 1;
        
        for(int stone : stones) {
            right = Math.max(right, stone);
        }
        
        int answer = 1;
        
        while (left <= right) {
            int mid = (left + right)/2;
            
            if (check(stones, mid, k)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean check(int[] stones, int mid, int k) {
        int count = 0;
        
        for (int i = 0 ; i < stones.length ; i++) {
            if (mid <= stones[i]) {
                count = 0;
            } else {
                count++;
            }
            
            if (count >= k)
                return false;
        }
        
        return true;
    }
}