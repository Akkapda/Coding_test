class Solution {
    public String solution(String code) {
        String answer = "";
        boolean mode = true;
        for(int i = 0; i < code.length(); i++) {
            String temp = Character.toString(code.charAt(i));
            if (mode) {
                if (temp.equals("1")) {
                    mode = !mode;
                    continue;
                } else if (i % 2 == 0)  {
                    answer = answer.concat(temp);
                }
            } else {
                if (temp.equals("1")) {
                    mode = !mode;
                    continue;
                } else if (i % 2 == 1)  {
                    answer = answer.concat(temp);
                }
            }
        }
        if (answer.equals("")) {
            answer = "EMPTY";
        }
        return answer;
    }
}