class Solution {
    public int solution(int n) {
        int answer = 0;
        
        int start = 0; int end = 0;
        int sum = 0;
        
        while (start < n+1) {
            if (sum < n) {
                end++;
                sum += end;
            } else if (sum > n) {
                start++;
                sum -= start;
            } else {
                answer++;
                start++;
                sum -= start;
            }
        }
        
        return answer;
    }
}