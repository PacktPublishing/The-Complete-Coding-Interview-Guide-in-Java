package coding.challenge;

public class Coins {

    // plain recursion
    int calculateChange(int n) {
        int[] coins = {25, 10, 5, 1};
        return calculateChange(n, coins, 0);
    }

    // plain recursion
    int calculateChange(int amount, int[] coins, int position) {

        if (position >= coins.length - 1) {
            return 1;
        }

        int coin = coins[position];
        int count = 0;
        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChange(remaining, coins, position + 1);
        }

        return count;
    }

    // Memoization
    int calculateChangeMemoization(int n) {
        int[] coins = {25, 10, 5, 1};
        int[][] cache = new int[n + 1][coins.length];
        return calculateChangeMemoization(n, coins, 0, cache);
    }

    // Memoization
    int calculateChangeMemoization(int amount, int[] coins, int position, int[][] cache) {

        if (cache[amount][position] > 0) {
            return cache[amount][position];
        }

        if (position >= coins.length - 1) {
            return 1;
        }

        int coin = coins[position];
        int count = 0;
        for (int i = 0; i * coin <= amount; i++) {
            int remaining = amount - i * coin;
            count += calculateChangeMemoization(remaining, coins, position + 1, cache);
        }

        cache[amount][position] = count;

        return count;
    }
}
