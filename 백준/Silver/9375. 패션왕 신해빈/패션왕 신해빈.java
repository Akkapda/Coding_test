import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        //테스트 개수
        int t = Integer.parseInt(br.readLine());

        for(int i = 0; i < t; i++) {
            //의류 개수
            int n = Integer.parseInt(br.readLine());

            //의류 해시맵
            HashMap<String, String> hashMap = new HashMap<>();

            //의류 입력
            for(int j = 0; j < n; j++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                String str1 = st.nextToken();   //의류
                String str2 = st.nextToken();   //종류
                //해당 종류가 없을 경우
                if (!hashMap.containsKey(str2)) {
                    hashMap.put(str2, "1");   //value = 개수
                }
                //해당 종류가 있을 경우
                else {
                    int temp = Integer.parseInt(hashMap.get(str2)); //해당 종류의 개수값 get
                    temp++; //개수 +1
                    hashMap.replace(str2, Integer.toString(temp));  //재입력
                }
            }

            //value 값들을 받아오기 위한 list
            ArrayList<Integer> arrayList = new ArrayList<>();

            //hashmap 내부의 모든 value값(각 종류의 개수값) list에 입력
            for(String key: hashMap.keySet()) {
                arrayList.add(Integer.parseInt(hashMap.get(key)));
            }
            //모든 경우의 수 구하기
            int result = 1;

            for(int j = 0; j < arrayList.size(); j++) {
                result *= (arrayList.get(j) + 1);   //+ 1 은 해당 종류를 입지 않은 None의 상태
            }
            //결과값에서 알몸 상태의 경우의 수 한개 제외
            result--;
            bw.write(result + "\n");

        }
        br.close();
        bw.flush();
        bw.close();
    }
}
