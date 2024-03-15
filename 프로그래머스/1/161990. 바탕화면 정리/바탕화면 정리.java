class Solution {
    public int[] solution(String[] wallpaper) {
        int length = wallpaper.length;;
        int lux = 51, luy = 51, rux = 0, ruy = 0;

        for(int i = 0; i < wallpaper.length; i++) {
            int temp1 = -1;
            temp1 = wallpaper[i].indexOf("#");
            if (luy >= temp1 && temp1 != -1) {
                luy = temp1;
            }
        }
        for(int i = 0; i < wallpaper.length; i++) {
            int temp1 = -1;
            temp1 = wallpaper[i].lastIndexOf("#");
            if (ruy <= temp1 && temp1 != -1) {
                ruy = temp1 + 1;
            }
            if (temp1 != -1) {
                if (lux > i) {
                    lux = i;
                }
                if (rux <= i) {
                    rux = i + 1;
                }
            }
        }
        int[] answer = {lux, luy, rux, ruy};
        return answer;
    }
}