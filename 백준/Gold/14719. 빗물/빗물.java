import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    public static void main(String[] args) throws IOException {
        Solution sol = new Solution();
        sol.solution();
    }
}

class Solution {
    public void solution() throws IOException {
        int answer = 0;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        String[] mn = br.readLine().split(" ");
        int M = Integer.parseInt(mn[0]); int N = Integer.parseInt(mn[1]);

        String[] tmp = br.readLine().split(" ");
        int[] input = new int[N];

        int max = 0;
        for(int i = 0 ; i < N ; i++) {
            input[i] = Integer.parseInt(tmp[i]);
            if (input[max] <= input[i]) {
                max = i;
            }
        }

        int t = 0; int min = 0;
        for (int i = 1 ; i <= max ; i++) {
            if (input[min] > input[i])
                t += input[min] - input[i];
            
            if (input[min] <= input[i]) {
                answer += t;
                t = 0;
                min = i;
            } 
        }

        t = 0; min = N-1;
        for (int i = N-2 ; i >= max ; i--) {
            if (input[min] > input[i])
                t += input[min] - input[i];
            
            if (input[min] <= input[i]) {
                answer += t;
                t = 0;
                min = i;
            } 
        }

        System.out.println(answer);
    }
}