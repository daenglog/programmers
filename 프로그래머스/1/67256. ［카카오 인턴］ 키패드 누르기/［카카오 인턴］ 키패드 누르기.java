class Solution {
    public String solution(int[] numbers, String hand) {
        StringBuilder sb = new StringBuilder();
        
        String left = "*";
        String right = "#";
        
        for(int i = 0 ; i < numbers.length; i++) {
            int now = numbers[i] == 0 ? 11 : numbers[i];
            
            if (now % 3 == 1) {
                left = now + "";
                sb.append("L");
            } else if (now % 3 == 0) {
                right = now + "";
                sb.append("R");
            } else {
                if(left.equals("*")) left = "10";
                if(left.equals("0")) left = "11";
                if(right.equals("0")) right = "11";
                if(right.equals("#")) right = "12";
                
                int l = Integer.parseInt(left);
                int r = Integer.parseInt(right);
                
                int tmpL = Math.abs(((now-1)/3 - (l-1)/3)) + Math.abs(l%3 - 2);
                int tmpR = Math.abs(((now-1)/3 - (r-1)/3)) + Math.abs((r%3==0 ? 3 : r%3) - 2);
                
                if (tmpL < tmpR) {
                    left = now+"";
                    sb.append("L");
                } else if (tmpL > tmpR) {
                    right = now+"";
                    sb.append("R");
                } else if (tmpL == tmpR) {
                    if (hand.equals("right")) {
                        right = now+"";
                        sb.append("R");
                    } else {
                        left = now+"";
                        sb.append("L");
                    }
                }
            }
        }
        
        return sb.toString();
    }
}