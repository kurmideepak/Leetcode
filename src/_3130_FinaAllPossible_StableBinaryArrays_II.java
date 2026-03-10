public class _3130_FinaAllPossible_StableBinaryArrays_II {


    // Copy and Paste inside Solution Class in Leetcode


    long[] fact;
    long[] invFact;
    int MOD = 1_000_000_007;

    private long power(long base, long exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }

    private long modInverse(long n) {
        return power(n, MOD - 2);
    }

    private void precompute(int max) {
        fact = new long[max + 1];
        invFact = new long[max + 1];
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= max; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
        }
        invFact[max] = modInverse(fact[max]);
        for (int i = max - 1; i >= 1; i--) {
            invFact[i] = (invFact[i + 1] * (i + 1)) % MOD;
        }
    }

    private long nCr(int n, int r) {
        if (r < 0 || r > n) return 0;
        return fact[n] * invFact[r] % MOD * invFact[n - r] % MOD;
    }

    private long ways(int elements, int limit, int blocks) {
        if (blocks <= 0 || elements < blocks) return 0;
        long totalWays = 0;
        for (int i = 0; i <= blocks && elements - i * limit - 1 >= blocks - 1; i++) {
            long currentWays = nCr(blocks, i) * nCr(elements - i * limit - 1, blocks - 1) % MOD;
            if (i % 2 == 1) {
                totalWays = (totalWays - currentWays + MOD) % MOD;
            } else {
                totalWays = (totalWays + currentWays) % MOD;
            }
        }
        return totalWays;
    }

    public int numberOfStableArrays(int zero, int one, int limit) {
        precompute(Math.max(zero, one) + 1);
        long ans = 0;
        int maxBlocks = Math.min(zero, one) + 1;
        for (int k = 1; k <= maxBlocks; k++) {
            long zeroWays = ways(zero, limit, k);
            if (zeroWays == 0) continue;
            long oneWays = (ways(one, limit, k - 1) + 2 * ways(one, limit, k) % MOD + ways(one, limit, k + 1)) % MOD;
            ans = (ans + zeroWays * oneWays % MOD) % MOD;
        }
        return (int) ans;
    }
}
