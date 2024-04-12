#include <stdio.h>
#include <stdbool.h>
#include <stdlib.h>

int solution(int n) {
    int answer = 0;
    int devider = 10;
    while(n > 0) {
        answer += n % devider;
        n = n / devider;
    }
    return answer;
}