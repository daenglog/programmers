import java.util.*;
class Solution {
    public String[] solution(String[] files) {
        String[] answer = new String[files.length];
        
        ArrayList<FileName> list = new ArrayList<>();
        
        for (int i = 0 ; i < files.length ; i++) {
            String file = files[i];
            String[] tmp = {"", "", ""};
            int idx = 0;
            
            for(char f : file.toCharArray()) {
                if(idx == 0 && f >= '0' && f <= '9') {
                    idx = 1;
                } else if(idx == 1 && (f<'0'||f>'9')) {
                    idx = 2;
                }
                tmp[idx] += f;
            }
            
            list.add(new FileName(tmp[0], tmp[1], tmp[2], i));
        }
        
        Collections.sort(list, (o1, o2) -> {
            int res1 = o1.head().toLowerCase().compareTo(o2.head().toLowerCase());
            
            if (res1 == 0) {
                int res2 = Integer.compare(Integer.parseInt(o1.number()), Integer.parseInt(o2.number()));
                
                if (res2 == 0)
                    return Integer.compare(o1.seq(), o2.seq());
                
                return res2;
            }
            
            return res1;
        });
        
        
        for(int i = 0 ; i < answer.length ; i++) {
            FileName fn = list.get(i);
            answer[i] = fn.head() + fn.number() + fn.tail();
        }
        
        
        return answer;
    }
}

record FileName(
    String head,
    String number,
    String tail,
    int seq
) {}