class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int compare1 = 0, compare2 = 0;
        compare1 = common[1] - common[0];
        compare2 = common[2] - common[1];
        if (compare1 == compare2) {
            answer = common[common.length - 1] + compare1;
        } else{
            compare1 = common[1] / common[0];
            compare2 = common[2] / common[1];
            if (compare1 == compare2) {
                answer = common[common.length - 1] * compare2;
            }
        }
        return answer;
    }
}