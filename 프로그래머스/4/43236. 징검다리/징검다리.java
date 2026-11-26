import java.util.*;
class Solution {
    public int solution(int distance, int[] rocks, int n) {
        int answer = 0;
        
        Arrays.sort(rocks);
        
        int left = 1; int right = distance;
        
        while (left <= right) {
            int mid = (left+right)/2;
            
            if(check(distance, rocks, n, mid)) {
                answer = Math.max(answer, mid);
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        
        return answer;
    }
    
    boolean check(int distance, int[] rocks, int n, int mid) {
        int prev = 0;
        int removed = 0;

        for (int rock : rocks) {
            // 간격이 mid보다 작으면 돌 제거
            // 아니면 prev를 현재 돌 위치로 변경
            if (rock - prev < mid) {
                removed++;
            } else {
                prev = rock;
            }
        }

        // 마지막 돌에서 도착점까지 간격이 mid보다 작으면 removed 증가
        if (distance - prev < mid) {
            removed++;
        }
        
        // 제거 개수가 n 이하면 true
        if (removed <= n) return true;
        
        return false;
    }
}