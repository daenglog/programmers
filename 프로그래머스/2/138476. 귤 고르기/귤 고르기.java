import java.util.*;
class Solution {
    public int solution(int k, int[] tangerine) {
        int answer = 0;
        
        HashMap<Integer, Integer> map = new HashMap<>();
        
        for(int tan : tangerine) {
            map.put(tan, map.getOrDefault(tan, 0) + 1);
        }
        
        ArrayList<int[]> list = new ArrayList<>();
        for(int key : map.keySet()) {
            list.add(new int[]{key, map.get(key)});
        }
        
        Collections.sort(list, (a, b) -> {
            return Integer.compare(b[1], a[1]);
        });
        
        for(int[] l : list) {
            answer++;
            if (l[1] < k) {
                k -= l[1];
            } else {
                break;
            }
        }
        
        return answer;
    }
}