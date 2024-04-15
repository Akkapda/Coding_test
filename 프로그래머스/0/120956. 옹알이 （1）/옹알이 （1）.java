class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        
        int counter;

        //최대 한 번 씩만 등장
        for(int i = 0; i < babbling.length; i++) {
            counter = 0;
            if (babbling[i].contains("aya")) {
                counter += 3;
            }
            if (babbling[i].contains("ye")) {
                counter += 2;
            }
            if (babbling[i].contains("woo")) {
                counter += 3;
            }
            if (babbling[i].contains("ma")) {
                counter += 2;
            }
            //counter와 length가 같다면 발음가능
            if (counter == babbling[i].length()) {
                answer++;
            }
        }
        return answer;
    }
}