import java.util.HashMap;

class Solution {
    public boolean solution(String[] phone_book) {
        boolean answer = true;
        HashMap<String, String> map = new HashMap<>();
        //일단 그냥 뽑아서?
        //119면 1 1, 9
        for(int i = 0; i < phone_book.length; i++) {
            map.put(phone_book[i], phone_book[i]);
        }

        //뽑아서 자른다음 있는지 확인
        for(String key: map.keySet()) {
            for(int i = 1; i <= key.length(); i++) {
                String temp = key.substring(0, i);
                if (map.containsKey(temp) && map.get(temp) != key) {
                    answer = false;
                }
            }
        }
        return answer;
    }
}