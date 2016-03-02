/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package coinchange;

/**
 *
 * @author AJ
 */
public class CoinChange {

    public static void main(String[] args) {
        Integer[] coins = {1, 5, 6, 8};
        Integer maxChange = 16;
        Integer[][] optimal = makeChange(coins, maxChange);
        print(optimal, coins, maxChange);
    }

    public static Integer[][] makeChange(Integer[] coins, Integer maxChange) {
        Integer[][] optimal = new Integer[coins.length][maxChange + 1];

        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= maxChange; j++) {
                if (i == 0) {
                    optimal[i][j] = j * coins[i];
                } else {
                    if (j >= coins[i]) {
                        if (optimal[i][j - coins[i]] >= optimal[i - 1][j]) {
                            optimal[i][j] = optimal[i - 1][j];
                        } else {
                            optimal[i][j] = optimal[i][j - coins[i]] + 1;
                        }
                    } else {
                        optimal[i][j] = optimal[i - 1][j];
                    }

                }
            }
        }
        return optimal;
    }

    public static void print(Integer[][] optimal, Integer[] coins, Integer maxChange) {
        System.out.println("Last Row: ");
        for (int i = 0; i < coins.length; i++) {
            for (int j = 0; j <= maxChange; j++) {
                System.out.print(optimal[i][j]);
            }
            System.out.println("");
        }
        System.out.println("");

    }
}
