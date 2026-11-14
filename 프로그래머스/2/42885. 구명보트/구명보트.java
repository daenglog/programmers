import java.util.*;
class Solution {
    public int solution(int[] people, int limit) {
        int answer = 0;
        
        Arrays.sort(people);
        
        int min = 0; int max = people.length-1;
        
        while(min<=max) {
            int sum = people[min] + people[max];
            
            if(sum <= limit) {
                min++;
                max--;
                answer++;
            } else {
                max--;
                answer++;
            }
        }
        
        return answer;
    }
}