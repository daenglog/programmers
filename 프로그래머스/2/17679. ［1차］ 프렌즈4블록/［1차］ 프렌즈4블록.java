import java.util.*;
class Solution {
    char[][] cBoard;
    public int solution(int m, int n, String[] board) {
        int answer = 0;
        cBoard = new char[m][n];
        
        for(int i = 0 ; i < m ; i++) {
            cBoard[i] = board[i].toCharArray();
        }
        
        while(true) {
            int res = checkBoard(m, n);
            
            if(res == 0) break;
            answer+=res;
            changeBoard(m, n);
        }
        
        return answer;
    }
    
    int checkBoard(int m, int n) {
        boolean[][] check = new boolean[m][n];
        
        for(int i = 0 ; i < m-1 ; i++) {
            for(int j = 0 ; j < n-1 ; j++) {
                if(cBoard[i][j] == '.') continue;
                if(cBoard[i][j] != cBoard[i][j+1]) continue;
                if(cBoard[i][j] != cBoard[i+1][j]) continue;
                if(cBoard[i][j] != cBoard[i+1][j+1]) continue;
                
                check[i][j] = true;
                check[i][j+1] = true;
                check[i+1][j] = true;
                check[i+1][j+1] = true;
            }
        }
        
        int count = 0;
        for(int i = 0 ; i < m ; i++) {
            for(int j = 0 ; j < n ; j++) {
                if(check[i][j]) {
                    count++;
                    cBoard[i][j] = '.';
                }
            }
        }
        return count;
    }
    
    void changeBoard(int m, int n) {
        Deque<Character> stack = new ArrayDeque<>();
        
        for(int j = 0 ; j < n ; j++) {
            stack.clear();
            for(int i = 0 ; i < m ; i++) {
                if(cBoard[i][j] == '.') continue;
                stack.offerLast(cBoard[i][j]);
            }
            
            if(stack.isEmpty()) continue;
            
            for(int i = m-1 ; i >= 0 ; i--) {
                if(stack.isEmpty())
                    cBoard[i][j] = '.';
                else
                    cBoard[i][j] = stack.pollLast();
            }
            
        }
    }
}