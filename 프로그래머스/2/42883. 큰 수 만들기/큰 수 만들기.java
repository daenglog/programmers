import java.util.*;

class Solution {
    public String solution(String number, int k) {
        Deque<Integer> stack = new ArrayDeque<>();
        
        int cnt = 0;
        for (int i = 0 ; i < number.length() ; i++) {
            int now = number.charAt(i) - '0';
            
            while (!stack.isEmpty() && cnt < k) {
                int peek = stack.peekLast();
                
                if (peek < now) {
                    stack.pollLast();
                    cnt++;
                } else {
                    break;
                }
            }
            stack.offerLast(now);
        }
        
        while (cnt < k) {
            stack.pollLast();
            cnt++;
        }
        
        StringBuilder sb = new StringBuilder();
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        
        return sb.toString();
    }
}