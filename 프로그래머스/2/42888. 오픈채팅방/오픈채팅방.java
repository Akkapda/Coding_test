import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

class Solution {
    public String[] solution(String[] record) {
        String[] temp = new String[record.length];
        ArrayList<String> ans = new ArrayList<>();
        StringTokenizer st;
        HashMap<String, String> map = new HashMap<>();
        
        for(int i = 0; i < record.length; i++) {
            st = new StringTokenizer(record[i]);
            String act = st.nextToken();
            String uid = st.nextToken();
            String nickname = "";
            if (st.hasMoreTokens()) {
                nickname = st.nextToken();
            }
            if ("Enter".equals(act)) {
                if (map.containsKey(uid)) {
                    map.replace(uid, nickname);
                } else {
                    map.put(uid, nickname);
                }
                temp[i] = uid + " 님이 들어왔습니다.";
            } else if ("Change".equals(act)) {
                map.replace(uid, nickname);
            } else if ("Leave".equals(act)) {
                temp[i] = uid + " 님이 나갔습니다.";
            }
        }

        for(int i = 0; i < temp.length; i++) {
            if (temp[i] != null) {
                st = new StringTokenizer(temp[i]);
                String uid = st.nextToken();
                ans.add(temp[i].replace(uid + " ", map.get(uid)));
            }
        }
        String[] answer = new String[ans.size()];
        ans.toArray(answer);
        return answer;
    }
}