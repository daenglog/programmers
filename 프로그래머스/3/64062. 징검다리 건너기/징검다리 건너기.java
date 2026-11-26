class Solution {
    public int solution(int[] stones, int k) {
        int answer = 0;
        
        int left = 1; int right = 1;
        for(int stone : stones) {
            right = Math.max(right, stone);
        }
        
        while (left <= right) {
            int mid = (left+right)/2;
            
            if (check(mid, stones, k)) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        
        return answer;
    }
    
    boolean check(int mid, int[] stones, int k) {
        int count = 0;
        
        for(int stone : stones) {
            if (stone >= mid) {
                count = 0;
            } else {
                count++;
            }
            
            if (count >= k) {
                return false;
            }
        }
        
        return true;
    }
}