import java.util.Arrays;

class Solution {
    public int[] solution(int l, int r) {
        String str = "";
        for(int i = 5; i <= r; i += 5) {
            if (i >= l) {
                String temp = Integer.toString(i);
                if (!temp.matches(".*[1-46-9].*")) {
                    str = str.concat(i + " ");
                }
            }
        }
        if (str.equals("")) {
            int[] answer = {-1};
            return answer;
        } else {
            int[] answer = Arrays.stream(str.split(" "))
                    .mapToInt(Integer::parseInt)
                    .toArray();
            return answer;
        }
    }
}