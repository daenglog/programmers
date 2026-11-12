import java.util.*;
class Solution {
    public String solution(String p) {
        String answer = "";
        
        //sol2(p);
        
        return sol2(p);
    }
    
    String sol2(String p) {
        if(p.length() == 0) return "";
        
        char[] tmp = p.toCharArray();
        
        int cntL = 0; int cntR = 0;
        int i = 0;
        while(i < tmp.length) {
            if((cntL!=0 && cntR !=0) && cntL == cntR) {
                break;
            }
            if(tmp[i] == '(') cntL++;
            else cntR++;
            
            i++;
        }
        
        String res = p.substring(0, i);
        
        if (check(res)) {
            res += sol2(p.substring(i, p.length()));
        } else {
            String t = "(";
            t += sol2(p.substring(i, p.length()));
            t += ")";
            res = res.substring(1, res.length()-1);
            for(int idx = 0 ; idx < res.length() ; idx++) {
                if(res.charAt(idx) == '(')
                    t += ")";
                else
                    t += "(";
            }
            
            res = t;
        }
        
        return res;
    }
    
    boolean check(String p) {
        boolean flag = true;
        
        char[] tmp = p.toCharArray();
        
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int i = 0 ; i < tmp.length ; i++) {
            if (stack.isEmpty()) {
                if(tmp[i] == ')') {
                    flag = false;
                    break;
                }
                stack.offerLast(tmp[i]);
            } else {
                if (tmp[i] == '(') stack.offerLast(tmp[i]);
                else {
                    if (stack.peekLast() == '(') {
                        stack.pollLast();
                    } else {
                        flag = false;
                        break;
                    }
                }
            }
            
        }
        return flag;
    }
}