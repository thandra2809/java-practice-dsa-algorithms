package org.namastedev.binarysearch;

public class GuessNumberHigherOrLowerLC374 {
    static void main() {

    }

    public static int guessNumber(int n) {
        int l = 1;
        int r = n;
        int response = 0;
        while (l <= r) {
            int mid = l + (r - l) / 2;

            //  response = guess(mid);   // this is just a guess API

            if (response == 0) {
                return mid;
            } else if (response < 0) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }


        }
        return -1;
    }
}
