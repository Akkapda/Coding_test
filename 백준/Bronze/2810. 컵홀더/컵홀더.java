import java.io.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int person = Integer.parseInt(br.readLine());
        String seat = br.readLine();
        int cupHolder = 2;
        char prev = seat.charAt(0);
        int coupleCNT = 0;
        for(int i = 1; i < person; i++) {
            char current = seat.charAt(i);
            if (prev == 'S') {
                cupHolder++;
            } else {
                coupleCNT++;
                if (coupleCNT == 2) {
                    //커플석 끝
                    cupHolder++;
                    coupleCNT = 0;
                }
            }
            prev = seat.charAt(i);
        }
        if (person < cupHolder) {
            System.out.println(person);
        } else {
            System.out.println(cupHolder);
        }
        br.close();
    }
}