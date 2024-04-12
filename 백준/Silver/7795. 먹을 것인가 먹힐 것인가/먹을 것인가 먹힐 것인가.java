import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static boolean flag;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for(int i = 0; i < t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            int[] aGroup = new int[n];
            int[] bGroup = new int[m];

            //A
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < n; j++) {
                aGroup[j] = Integer.parseInt(st.nextToken());
            }

            //B
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < m; j++) {
                bGroup[j] = Integer.parseInt(st.nextToken());
            }
            //정렬
            Arrays.sort(aGroup);
            Arrays.sort(bGroup);
            int sum = 0;
            for(int j = 0; j < aGroup.length; j++) {
                int temp = binary(0, bGroup.length - 1, aGroup[j], bGroup);
                if (temp != 0) {
                    if (flag) {
                        sum += temp;
                    } else if (!flag){
                        sum += temp + 1;
                    }
                } else {
                    if (!flag) {
                        sum++;
                    }
                }
            }
            bw.write(sum + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }

    public static int binary(int left, int right, int num, int[] array) {
        int middle = 0;
        flag = true;

        while(left <= right) {
            middle = (left + right) / 2;
            if (array[middle] > num) {
                right = middle - 1;
            } else if (array[middle] < num) {
                left = middle + 1;
            } else right--;
        }

        if (array[middle] < num) {
            //middle을 먹을 수 있음.
            flag = false;
        }
        return middle;
    }
}
