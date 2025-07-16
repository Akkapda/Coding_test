class Solution {
    public String solution(String my_string, String overwrite_string, int s) {
        String answer = "";
        int n = 0;
        for(int i = 0; i < my_string.length(); i++) {
            if (i >= s && i < overwrite_string.length() + s) {
                answer = answer + overwrite_string.charAt(n++);
            }
            else {
                answer = answer + my_string.charAt(i);
            }
        }
        return answer;
    }
}