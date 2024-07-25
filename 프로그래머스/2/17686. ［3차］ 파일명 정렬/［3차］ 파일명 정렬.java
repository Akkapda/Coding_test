import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static String[] solution(String[] files) {
        String[] answer = new String[files.length];
        Map<Integer, String[]> details = new HashMap<>();
        Integer[] entry = new Integer[files.length];
        //나누기
        for(int i = 0; i < files.length; i++) {
            //헤드찾기
            int head = 0;
            int tail = files[i].length() - 1;
            boolean found = false;
            for(int j = 0; j < files[i].length(); j++) {
                char c = files[i].charAt(j);
                if(c >= '0' && c <= '9') {
                    if (!found) {
                        head = j;
                        found = true;
                    }
                } else {
                    if(found) {
                        tail = j;
                        break;
                    }
                }
            }
            String[] sa = new String[3];
            sa[0] = files[i].substring(0, head);
            if (tail == files[i].length() - 1) {
                sa[1] = files[i].substring(head);
            } else {
                sa[1] = files[i].substring(head, tail);
                sa[2] = files[i].substring(tail);
            }
            details.put(i, sa);
            entry[i] = i;
        }
        Arrays.sort(entry, (o1, o2) -> {
            if (details.get(o1)[0].toLowerCase().equals(details.get(o2)[0].toLowerCase())) {
                String s1 = details.get(o1)[1];
                String s2 = details.get(o2)[1];
                if (Integer.parseInt(s1) == (Integer.parseInt(s2))) {
                    return 0;
                } else {
                    return Integer.parseInt(s1) - Integer.parseInt(s2);
                }
            } else {
                return details.get(o1)[0].toLowerCase().compareTo(details.get(o2)[0].toLowerCase());
            }
        });
        for(int i = 0; i < entry.length; i++) {
            answer[i] = files[entry[i]];
        }
        return answer;
    }
}