import java.util.*;

class Solution {
    
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        for(String i : info) {
            String[] tmp = i.split(" ");
            dfs(0, tmp, "");
        }
        
        for(String key : map.keySet()) {
            ArrayList<Integer> list = map.get(key);
            Collections.sort(list);
            map.put(key, list);
        }
        
        for(int i = 0 ; i < query.length ; i++) {
            String q = query[i];
            q = q.replaceAll(" and ", " ");
            String[] tmp = q.split(" ");
            answer[i] = check(tmp);
        }
        
        return answer;
    }
    
    int check(String[] tmp) {
        String key = " " + tmp[0] + " " + tmp[1] + " " + tmp[2] + " " + tmp[3];
        int limit = Integer.parseInt(tmp[4]);
        
        ArrayList<Integer> search = map.get(key);
        
        if (search == null) return 0;
        
        int left = 0; int right = search.size() - 1;
        while(left <= right) {
            int mid = (left + right) / 2;
            
            if (search.get(mid) >= limit) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        
        return search.size() - left;
    }
    
    void dfs(int idx, String[] tmp, String str) {
        if(idx == 4) {
            ArrayList<Integer> list = map.getOrDefault(str, new ArrayList<>());
            list.add(Integer.parseInt(tmp[4]));
            map.put(str, list);
            return;
        }
        
        dfs(idx+1, tmp, str+" "+tmp[idx]);
        dfs(idx+1, tmp, str+" -");
    }
}
        