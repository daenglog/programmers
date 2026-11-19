class Solution {
    public long solution(int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long left = 1; long right = 400_000_000_000_000L;
        long answer = right;
        
        while (left <= right) {
            long mid = (left + right) / 2;
            
            if (check(mid, a, b, g, s, w, t)) {
                right = mid - 1;
                answer = Math.min(answer, mid);
            } else {
                left = mid + 1;
            }
        }
        
        return answer;
    }
    
    boolean check(long time, int a, int b, int[] g, int[] s, int[] w, int[] t) {
        long total = 0;
        long gold = 0;
        long silver = 0;

        for (int i = 0; i < g.length; i++) {
            long count = time / (2L * t[i]);

            if (time % (2L * t[i]) >= t[i]) {
                count++;
            }

            long capacity = count * w[i];

            total += Math.min(capacity, (long) g[i] + s[i]);
            gold += Math.min(capacity, g[i]);
            silver += Math.min(capacity, s[i]);
        }

        return gold >= a && silver >= b && total >= (long) a + b;
    }
}