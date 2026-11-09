import java.util.*;
class Solution {
    public int solution(String s) {
        int answer = s.length();
        
        for(int l = 1 ; l < s.length() - 1 ; l++) {
            String tmp = "";
            
            for(int i = 0 ; i + l <= s.length() ; i += l) {
                String now = s.substring(i, i+l);
                int count = 1;
                for(int j = i+l ; j + l <= s.length() ; j += l) {
                    String next = s.substring(j, j+l);
                    if (now.equals(next)) {
                        count++;
                        i = j;
                    } else {
                        i = j - l;
                        break;
                    }
                }
                
                tmp += count == 1 ? now : count+now;
                
                if (i + 2*l > s.length() && i + l < s.length()) {
                    tmp += s.substring(i+l, s.length());
                }
            }
            
            answer = Math.min(answer, tmp.length());
        }
        
        return answer;
    }
}