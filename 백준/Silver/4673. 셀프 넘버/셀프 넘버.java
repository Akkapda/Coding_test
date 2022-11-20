public class Main {
    public static void main(String[] args) {

        boolean[] a = new boolean[10000];

        for(int i = 0; i < 10000; i++) {
            a[i] = false;
        }
        self_number(a);
        for(int i = 0; i < 10000; i++) {
            if (a[i] == false) {
                System.out.println(i);
            }
        }
    }
    public static void self_number(boolean[] a) {
        int temp = 0;
        for(int i = 0; i < 10000; i++) {
            temp = 0;
            if (i < 10) {
                temp = i + i;
                a[temp] = true;
            }
            else if (i >= 10 && i < 100) {
                temp = i + (i / 10) + (i % 10);
                a[temp] = true;
            }
            else if (i >= 100 && i < 1000) {
                temp = i + (i / 100) + ((i % 100) / 10) + (i % 10);
                a[temp] = true;
            }
            else {
                temp = i + (i / 1000) + ((i % 1000) / 100) + ((i % 100) / 10) + (i % 10);
                if (temp < 10000) {
                    a[temp] = true;
                }
            }
        }
    }
}
