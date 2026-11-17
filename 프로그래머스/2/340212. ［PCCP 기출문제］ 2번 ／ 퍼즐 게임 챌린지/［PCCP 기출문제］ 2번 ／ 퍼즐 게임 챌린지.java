class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int min = 1; int max = 100000;
        int answer = max;
        
        while (min <= max) {
            int level = (min+max)/2;
            
            long res = check(diffs, times, limit, level);
            
            if (res > limit) {
                min = level+1;
            } else {
                answer = Math.min(answer, level);
                max = level-1;
            }
        }
        
        return answer;
    }
    
    long check(int[] diffs, int[] times, long limit, int level) {
        long result = times[0];
        
        for(int i = 1 ; i < diffs.length ; i++) {
            int count = diffs[i] <= level ? 0 : diffs[i] - level;
            
            if (count == 0) {
                result += times[i];
            } else {
                result += (times[i] + times[i-1]) * count + times[i];
            }
        }
        
        return result;
    }
}