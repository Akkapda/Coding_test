import java.util.StringTokenizer;

class Solution {
    public String solution(String polynomial) {
        String answer = "";
        StringTokenizer st = new StringTokenizer(polynomial);
        int xCoef = 0;
        int constCoef = 0;
        while(st.hasMoreTokens()) {
            String temp = st.nextToken();
            if (temp.equals("+")) {
                continue;
            }
            if (temp.contains("x")) {
                temp = temp.replace("x", "");
                if (temp.equals("")) {
                    xCoef++;
                } else {
                    xCoef += Integer.parseInt(temp);
                }
            } else {
                constCoef += Integer.parseInt(temp);
            }
        }

        if (xCoef == 1) {
            if (constCoef == 0) {
                answer = "x";
            } else {
                answer = "x + " + constCoef;
            }
        } else if (xCoef == 0) {
            answer = constCoef + "";
        } else {
            if (constCoef == 0) {
                answer = xCoef + "x";
            } else {
                answer = xCoef + "x + " + constCoef;
            }
        }
        return answer;
    }
}