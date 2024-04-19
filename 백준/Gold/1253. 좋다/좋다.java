import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[n];
        for(int i = 0; i < n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        //투포인터로 체크하고
        //정렬했고 배열이 2000개 제한이라 터질일은 크게 없을 듯 -> 이진탐색까진 필요없다.
        //걍 이진탐색하고 전체탐색하기?
        //end 뒤의 것 들을 체크? -> 음수가 더해질 수 있으므로 end보다 작아질 수 있다.

        int answer = 0;

        for(int i = 0 ; i<array.length; i++){
            int start = 0;
            int end = array.length - 1;
            int temp = array[i];

            while(start<end){
                int sum = array[start] + array[end];

                if(sum < temp){
                    start++;
                }
                else if (sum > temp){
                    end--;
                }
                else{
                    if (start == i) {
                        start++;
                    } else if (end == i) {
                        end--;
                    } else {
                        answer++;
                        break;
                    }
                }
            }
        }
        System.out.println(answer);
    }
}
