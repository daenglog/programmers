import java.util.*;

class Solution {
    int[] answer = new int[2];
    public int[] solution(int[][] users, int[] emoticons) {
        price = new int[emoticons.length][5];
        makePrice(emoticons);
        
        visited = new boolean[emoticons.length][5];
        dfs(0, "", price.length, users);
        
        return answer;
    }
    
    void check(String str, int[][] users) {
        char[] idxs = str.toCharArray();
        
        int plusService = 0; int total = 0;
        for (int i = 0 ; i < users.length ; i++) {
            int percent = users[i][0] % 10 == 0 ? users[i][0]/10 : users[i][0]/10+1;
            
            int tmp = 0 ; 
            for (int m = 0 ; m < idxs.length ; m++) {
                int n = idxs[m] - '0';
                
                if (n >= percent) {
                    tmp+=price[m][n];
                }
            }
            
            if (tmp >= users[i][1]) {
                plusService++;
            } else {
                total += tmp;
            }
        }
        
        if (answer[0] < plusService) {
            answer[0] = plusService;
            answer[1] = total;
        } else if (answer[0] == plusService) {
            answer[1] = Math.max(answer[1], total);
        }
    }   
    
    boolean[][] visited;
    void dfs(int idx, String str, int L, int[][] users) {
        if(idx == L) {
            check(str, users);
            return;
        }
        
        for(int i = 1 ; i < 5 ; i++) {
            if(visited[idx][i]) continue;
            visited[idx][i] = true;
            dfs(idx+1, str+i, L, users);
            visited[idx][i] = false;
        }
    }
    
    int[][] price;
    void makePrice(int[] emoticons) {
        for (int idx = 0; idx < emoticons.length; idx++) {
            for (int i = 1; i <= 4; i++) {
                price[idx][i] = emoticons[idx] * (100 - i * 10) / 100;
            }
        }
    }
}