class Solution {
    public long solution(int n, int[] times) {
        
        long left = 1;
        long right = (long)times[0] * n;
        long answer = right;

        while (left <= right) {
            long mid = (left+right)/2;
            
            long count = 0;
            for(int t : times) {
                if(mid < t) continue;
                count += mid/t;
            }
            
            if (count >= n) {
                answer = Math.min(answer, mid);
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        
        return answer;
    }
}