import java.util.*;
class Solution {
    Deque<String> queue = new ArrayDeque<>();
    public long solution(String expression) {
        long answer = 0;
        
        String tmp = "";
        for(char c : expression.toCharArray()) {
            if (c == '-' || c == '*' || c == '+') {
                queue.offerLast(tmp);
                tmp = "";
                queue.offerLast(c + "");
            } else {
                tmp += c;
            }
        }
        queue.offerLast(tmp);
        
        answer = Math.max(answer, func("*+-"));
        answer = Math.max(answer, func("*-+"));
        answer = Math.max(answer, func("+-*"));
        answer = Math.max(answer, func("+*-"));
        answer = Math.max(answer, func("-*+"));
        answer = Math.max(answer, func("-+*"));
        
        return answer;
    }
    
    Deque<String> calc(Deque<String> tmp, char target) {
        Deque<String> stack = new ArrayDeque<>();
        
        stack.offerLast(tmp.pollFirst());
        while (!tmp.isEmpty()) {
            String now = tmp.pollFirst();
            
            if(stack.peekLast().equals(target+"")) {
                stack.pollLast();
                long tL = Long.parseLong(now);
                if (target == '-') {
                    tL = Long.parseLong(stack.pollLast()) - tL;
                } else if (target == '+') {
                    tL = Long.parseLong(stack.pollLast()) + tL;
                } else {
                    tL = Long.parseLong(stack.pollLast()) * tL;
                }
                now = tL+"";
            }
            stack.offerLast(now);
        }
        
        return stack;
    }
    
    Long func(String targets) {
        Deque<String> tmp = new ArrayDeque<>(queue);
        
        for(char target : targets.toCharArray()) 
            tmp = calc(tmp, target);
        
        return Math.abs(Long.parseLong(tmp.pollLast()));
    }
}