import java.util.*;
class Solution {
    public int solution(String[][] book_time) {
        Arrays.sort(book_time, (a, b) -> {
            return a[0].compareTo(b[0]);
        });
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        for(String[] book : book_time) {
            String[] startTm = book[0].split(":");
            String[] endTm = book[1].split(":");
            
            int start = Integer.parseInt(startTm[0]) * 60 + Integer.parseInt(startTm[1]);
            int end = Integer.parseInt(endTm[0]) * 60 + Integer.parseInt(endTm[1]);
            
            if (!pq.isEmpty() && pq.peek() <= start) {
                pq.poll();
            }
            
            pq.offer(end+10);
        }
            
        
        return pq.size();
    }
}