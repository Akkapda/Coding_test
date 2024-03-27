import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] dp = new int[n];
        boolean[] flag;

        //4는 2로 나눴을 때 2가 된다. 1을 빼면 3 -> 2의 counter에 1을 더한다
        //5는 2와 3으로 안나눠진다 -> 1을 빼면 4가 되므로 4의 경우 2와 1을 더해 3이다.
        //6은 2와 3으로 나누어지고 1을 뺄 수 있다.
        // -> 2로 나누면 3 = 1이고 3으로 나누면 2 = 1 1 빼면 5 =3 -> 최적값 = 2
        //9는 3으로 나누어지고 1을 뺄 수 있다.
        //-> 3으로 나누면 3 = 1 즉, 2 (8은 2로 세번 나누어야함)
        //10은 2로 나누어지고 1을 뺄 수 있다.
        //-> 2로 나누면 5 = 3,  1 빼면 9 = 2 1빼는게 이득
        dp[0] = 0; //1
        if (n == 2) {
            dp[1] = 1;
        } else if (n == 3) {
            dp[2] = 1;
        } else if(n != 1){
            dp[1] = 1;
            dp[2] = 1;
            for(int i = 4; i <= n; i++) {
                flag = new boolean[2];
                int temp1 = 0;
                int temp2 = 0;
                int temp3 = 0;
                if (i % 3 == 0) {
                    //3으로 나누어 지는가?
                    flag[0] = true;
                }
                if (i % 2 == 0) {
                    //2로 나누어 지는가?
                    flag[1] = true;
                }
                //1을 빼는건 무조건 가능하다.(1은 불가능하지만 bottom-up이기 때문에)

                if (flag[0]) {
                    //3으로 나누어지는 경우
                    temp1 = i / 3;
                }
                if (flag[1]) {
                    //2로 나누어지는 경우
                    temp2 = i / 2;
                }
                //1을 빼는 연산은 무조건 함
                temp3 = i - 1;
                //0이 아닌 것들만 사용한다. -> temp들의 초기값을 0으로 해뒀기 때문.
                //여기까지 0 이라는 것은 나누어지지 않아서 0으로 남아있는 것이다.
                if (temp1 == 0 && temp2 == 0) {
                    //둘 다 안나누어짐
                    dp[i - 1] = dp[temp3 - 1] + 1;
                } else if(temp1 == 0) {
                    //3으로 안나누어졌다.
                    dp[i - 1] = Math.min(dp[temp2 - 1], dp[temp3 - 1]) + 1;
                } else if (temp2 == 0) {
                    //2로 안나누어졌다
                    dp[i - 1] = Math.min(dp[temp1 - 1], dp[temp3 - 1]) + 1;
                } else {
                    //다 되는 경우
                    dp[i - 1] = Math.min(dp[temp1 - 1], dp[temp2 - 1]) + 1;
                }
            }
        }

        bw.write( dp[n - 1] + "\n");

        bw.flush();
        bw.close();
        br.close();
    }
}
