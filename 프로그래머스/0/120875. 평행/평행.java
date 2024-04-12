class Solution {
    public double solution(int[][] dots) {
        int answer = 0;
        double slope1_1 = (double) Math.max(Math.abs(dots[0][0] - dots[1][0]), Math.abs(dots[0][1] - dots[1][1]))
                / Math.min(Math.abs(dots[0][0] - dots[1][0]), Math.abs(dots[0][1] - dots[1][1]));
        double slope1_2 = (double) Math.max(Math.abs(dots[2][0] - dots[3][0]), Math.abs(dots[2][1] - dots[3][1]))
                / Math.min(Math.abs(dots[2][0] - dots[3][0]), Math.abs(dots[2][1] - dots[3][1]));
        double slope2_1 = (double) Math.max(Math.abs(dots[0][0] - dots[2][0]), Math.abs(dots[0][1] - dots[2][1]))
                / Math.min(Math.abs(dots[0][0] - dots[2][0]), Math.abs(dots[0][1] - dots[2][1]));
        double slope2_2 = (double) Math.max(Math.abs(dots[1][0] - dots[3][0]), Math.abs(dots[1][1] - dots[3][1]))
                / Math.min(Math.abs(dots[1][0] - dots[3][0]), Math.abs(dots[1][1] - dots[3][1]));
        double slope3_1 = (double) Math.max(Math.abs(dots[0][0] - dots[3][0]), Math.abs(dots[0][1] - dots[3][1]))
                / Math.min(Math.abs(dots[0][0] - dots[3][0]), Math.abs(dots[0][1] - dots[3][1]));
        double slope3_2 = (double) Math.max(Math.abs(dots[1][0] - dots[2][0]), Math.abs(dots[1][1] - dots[2][1]))
                / Math.min(Math.abs(dots[1][0] - dots[2][0]), Math.abs(dots[1][1] - dots[2][1]));

//        System.out.println(slope1_1 + " " + slope1_2 + "\n"
//                + slope2_1 + " " + slope2_2 + "\n" + slope3_1 + " " + slope3_2);
        
        if (slope1_1 == slope1_2 || slope2_1 == slope2_2 || slope3_1 == slope3_2) {
            answer = 1;
        }
        return answer;
    }
}