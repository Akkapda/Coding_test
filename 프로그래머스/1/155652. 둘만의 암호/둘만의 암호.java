class Solution {
    public String solution(String s, String skip, int index) {
        // 97 122 a - z
        String answer = "";
        for(int i = 0; i < s.length(); i++) {
            //각 자리별로 체크
            int count = index;
            char c = s.charAt(i);
            //index만큼 넘기기(스킵될 수 있으니 while로)
            while(count > 0) {
                c++;
                count--;
                //z 넘어가면 리셋
                if (c > 122) {
                    c = 97;
                }
                //스킵체크
                for(int j = 0; j < skip.length(); j++) {
                    if (c == skip.charAt(j)) {
                        count++;
                        break;
                    }
                }
            }
            //다 됐으면 answer에 더하기
            answer = answer.concat(Character.toString(c));
        }
        return answer;
    }
}