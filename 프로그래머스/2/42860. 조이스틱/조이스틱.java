class Solution {
    public int solution(String name) {
        int n = name.length();
        int answer = 0;
        int move = n - 1; // 오른쪽으로만 이동

        for (int i = 0; i < n; i++) {
            // 위·아래로 알파벳 변경
            int diff = name.charAt(i) - 'A';
            answer += Math.min(diff, 26 - diff);

            // i 다음의 연속된 A를 건너뛴 위치
            int next = i + 1;
            while (next < n && name.charAt(next) == 'A') {
                next++;
            }

            // 오른쪽으로 i까지 갔다가 돌아서 왼쪽으로 이동
            move = Math.min(move, i * 2 + n - next);

            // 왼쪽으로 먼저 갔다가 돌아서 오른쪽 i까지 이동
            move = Math.min(move, (n - next) * 2 + i);
        }

        return answer + move;
    }
}