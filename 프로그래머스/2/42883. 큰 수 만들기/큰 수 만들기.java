import java.util.*;
class Solution {
    public String solution(String number, int k) {
        StringBuilder sb = new StringBuilder();
        
        Deque<Integer> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < number.length() ; i++) {
            int now = number.charAt(i) - '0';
            
            while(!stack.isEmpty() && k > 0 && stack.peekLast() < now) {
                stack.pollLast();
                k--;
            }
            
            stack.offerLast(now);
        }
        
        while (k > 0) {
            stack.pollLast();
            k--;
        }

        
        while(!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }
        
        return sb.toString();
    }
}