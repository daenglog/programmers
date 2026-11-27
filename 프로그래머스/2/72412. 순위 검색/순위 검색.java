import java.util.*;
class Solution {
    
    HashMap<String, ArrayList<Integer>> map = new HashMap<>();
    
    public int[] solution(String[] info, String[] query) {
        int[] answer = new int[query.length];
        
        List<Info> list = new ArrayList<>();
        
        for (String i : info) {
            String[] tmp = i.split(" ");
            list.add(new Info(new String[]{tmp[0], tmp[1], tmp[2], tmp[3]}, Integer.parseInt(tmp[4])));
        }
        
        for(Info l : list) {
            makeScore(0, l.tmp(), "", l.score());
        }
        
        for (String key : map.keySet()) {
            ArrayList<Integer> tmp = map.get(key);
            Collections.sort(tmp);
            map.put(key, tmp);
        }
        
        for (int idx = 0; idx < query.length ; idx++) {
            String q = query[idx];
            q = q.replaceAll(" and ", " ");
            String[] strQ = q.split(" ");
            String key = strQ[0] + strQ[1] + strQ[2] + strQ[3];
            int base = Integer.parseInt(strQ[4]);
            
            if (map.containsKey(key)) {
                ArrayList<Integer> scores = map.get(strQ[0] + strQ[1] + strQ[2] + strQ[3]);
                
                int left = 0; int right = scores.size();
                int sizeI = scores.size();
                while (left <= right) {
                    int mid = (left+right)/2;
                    
                    if (mid >= scores.size()) break;
                    
                    if (scores.get(mid) >= base) {
                        sizeI = Math.min(sizeI, mid);
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                answer[idx] = scores.size() - sizeI;
            }
        }
        
        
        return answer;
    }
    
    void makeScore(int idx, String[] info, String str, int score) {
        if(idx == 4) {
            ArrayList<Integer> al = map.getOrDefault(str, new ArrayList<>());
            al.add(score);
            map.put(str, al);
            return;
        }
        makeScore(idx+1, info, str+info[idx], score);
        makeScore(idx+1, info, str+"-", score);
    }
}

record Info(
    String[] tmp,
    int score
){}