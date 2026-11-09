import java.util.*;
class Solution {
    public int solution(int[] priorities, int location) {
        int answer = 0;
        
        Deque<Integer> deque = new ArrayDeque<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i = 0 ; i < priorities.length ; i++) {
            deque.offerLast(i);
            pq.offer(priorities[i]);
        }
        
        while(!pq.isEmpty()) {
            int max = pq.poll();
            int idx = deque.pollFirst();
            
            if(priorities[idx] == max) {
                answer++;
                if(idx == location)
                    break;
            } else {
                pq.offer(max);
                deque.offerLast(idx);
            }    
        }
        
        return answer;
    }
}