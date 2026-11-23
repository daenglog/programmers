import java.util.*;
class Solution {
    public int solution(int[] A, int[] B) {
        int answer = 0;
        
        int N = A.length;
        
        Arrays.sort(A);
        Arrays.sort(B);
        
        int aIdx = 0; // 아직 이기지 못한 A의 가장 작은 수

        for (int bIdx = 0; bIdx < N; bIdx++) {
            if (A[aIdx] < B[bIdx]) {
                answer++;
                aIdx++;
            }
        }
        
        return answer;
    }
}