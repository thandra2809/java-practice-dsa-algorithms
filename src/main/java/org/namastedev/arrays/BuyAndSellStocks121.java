package org.namastedev.arrays;

public class BuyAndSellStocks121 {
    static void main() {
        int[] prices = new int[]{7,1,5,3,6,4};

        int minimumPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - minimumPrice > maxProfit) {
                maxProfit = prices[i] - minimumPrice;
            }
            if(prices[i]<minimumPrice){
                minimumPrice = prices[i];
            }
        }

        System.out.println(minimumPrice);
        System.out.println(maxProfit);

    }
}
