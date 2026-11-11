import java.util.*;
class Solution {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];
        Arrays.fill(answer, Integer.MAX_VALUE);
        
        int[][] array = new int[rows][columns];
        
        for(int i = 0 ; i < rows; i++) {
            for(int j = 0 ; j < columns ; j++) {
                array[i][j] = i * columns + (j+1);
            }
        }
        
        for(int i = 0 ; i < queries.length ; i++) {
            int x1 = queries[i][0]; int y1 = queries[i][1];
            int x2 = queries[i][2]; int y2 = queries[i][3];
            
            int tmp = array[x1-1][y2-1];
            answer[i] = Math.min(answer[i], tmp);
            // 오른쪽
            for (int idx = y2-1 ; idx  > y1 - 1 ; idx--) {
                array[x1-1][idx] = array[x1-1][idx-1];
                answer[i] = Math.min(answer[i], array[x1-1][idx]);
            }
            
            // 위
            for (int idx = x1-1 ; idx < x2-1 ; idx++) {
                array[idx][y1-1] = array[idx+1][y1-1];
                answer[i] = Math.min(answer[i], array[idx][y1-1]);
            }            
            
            // 왼쪽
            for (int idx = y1-1 ; idx <y2-1 ; idx++) {
                array[x2-1][idx] = array[x2-1][idx+1];
                answer[i] = Math.min(answer[i], array[x2-1][idx]);
            }
            
            // 아래
            for (int idx = x2-1 ; idx >x1-1 ; idx--) {
                array[idx][y2 - 1] = array[idx-1][y2-1]; 
                answer[i] = Math.min(answer[i], array[idx][y2 - 1]);
            }
            
            array[x1][y2-1] = tmp;
        }
        
        
        return answer;
    }
}