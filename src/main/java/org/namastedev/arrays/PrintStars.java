package org.namastedev.arrays;

public class PrintStars {
    static void main() {

        for (int i = 0; i < 4; i++) {
            StringBuilder row = new StringBuilder(" ");
            for (int j = 0; j < 4; j++) {
                row.append("  *");
            }
            System.out.println(row.toString());
        }
    }
}
