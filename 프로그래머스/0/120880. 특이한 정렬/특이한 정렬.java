import java.util.Arrays;
import java.util.Comparator;

class Solution {
    public int[] solution(int[] numlist, int n) {
        int[] answer = new int[numlist.length];
        Integer[] numListInteger = new Integer[numlist.length];
        for (int i = 0; i < numlist.length; i++) {
            numListInteger[i] = numlist[i];
        }
        System.out.println();
        Arrays.sort(numListInteger, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                Integer a = Math.abs(o1 - n);
                Integer b = Math.abs(o2 - n);
                if (a.equals(b)) {
                    return o2.compareTo(o1);
                } else {
                    return a - b;
                }
            }
        });
        for (int i = 0; i < numlist.length; i++) {
            answer[i] = numListInteger[i];
        }
        return answer;
    }
}