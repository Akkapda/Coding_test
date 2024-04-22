import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        boolean startFlag = false;
        boolean minusFlag = false;
        int left = 0, right = 0;
        int answer = 0;
        for(int i = 0; i < str.length(); i++) {
            char temp = str.charAt(i);
            if (startFlag) {
                //0을 제외하고 시작
                if (minusFlag) {
                    //-가 한 번이라도 나왔음
                    if (temp == '-' || temp == '+') {
                        right = i;
                        answer -= Integer.parseInt(str.substring(left, right));
                        left = i + 1;
                        startFlag = false;
                    } else if (i == str.length() - 1) {
                        answer -= Integer.parseInt(str.substring(left, i + 1));
                    }
                } else {
                    //-가 한 번도 안나옴
                    if (temp == '-') {
                        //-가 처음 나옴 -> 다음부턴 다 빼면 됨
                        minusFlag = true;
                        right = i;
                        answer += Integer.parseInt(str.substring(left, right));
                        left = i + 1;
                        startFlag = false;
                    } else if (temp == '+'){
                        //+가 나왔을 때
                        right = i;
                        answer += Integer.parseInt(str.substring(left, right));
                        startFlag = false;
                    } else if (i == str.length() - 1) {
                        answer += Integer.parseInt(str.substring(left, i + 1));
                    }
                }
            } else {
                //앞쪽이 0인경우
                if (temp != '0' && temp != '-' && temp != '+') {
                    if (i == str.length() - 1) {
                        if (minusFlag) {
                            answer -= Integer.parseInt(str.substring(left, i + 1));
                        } else {
                            answer += Integer.parseInt(str.substring(left, i + 1));
                        }
                    }
                    startFlag = true;
                    left = i;
                }
            }
        }
        System.out.println(answer);
    }
}
