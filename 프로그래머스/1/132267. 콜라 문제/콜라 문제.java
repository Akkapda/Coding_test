class Solution {
    public int solution(int a, int b, int n) {
        int emptyBottle = 0;
        int total = 0;
        while(true) {
            //콜라를 마심
            emptyBottle += n;
            //마신거 교환
            n = (emptyBottle / a) * b;
            //교환한 콜라 카운트
            total += (emptyBottle / a) * b;
            //교환하고 남은 빈 병
            emptyBottle = emptyBottle % a;
            //교환 못하면 break;
            if (n + emptyBottle < a) {
                break;
            }
        }
        int answer = total;
        return answer;
    }
}