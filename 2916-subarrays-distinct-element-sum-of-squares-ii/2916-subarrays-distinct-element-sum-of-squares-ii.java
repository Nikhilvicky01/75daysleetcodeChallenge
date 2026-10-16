class Solution {
    static final long MOD = 1_000_000_007L;
    long[] sum, sq, lazy;

    public int sumCounts(int[] nums) {
        int n = nums.length;
        sum = new long[4 * n];
        sq = new long[4 * n];
        lazy = new long[4 * n];

        int[] last = new int[100001];
        java.util.Arrays.fill(last, -1);

        long ans = 0;
        for (int j = 0; j < n; j++) {
            update(1, 0, n - 1, last[nums[j]] + 1, j);
            last[nums[j]] = j;
            ans = (ans + sq[1]) % MOD;   // sum of cnt[i]^2 over all i (i > j are still 0)
        }
        return (int) ans;
    }

    void apply(int node, int len, long v) {
        sq[node] = (sq[node] + 2 * v % MOD * sum[node] + (long) len * v % MOD * v) % MOD;
        sum[node] = (sum[node] + (long) len * v) % MOD;
        lazy[node] += v;
    }

    void push(int node, int l, int r) {
        if (lazy[node] != 0) {
            int mid = (l + r) / 2;
            apply(node * 2, mid - l + 1, lazy[node]);
            apply(node * 2 + 1, r - mid, lazy[node]);
            lazy[node] = 0;
        }
    }

    // add +1 on [ql, qr]
    void update(int node, int l, int r, int ql, int qr) {
        if (ql <= l && r <= qr) {
            apply(node, r - l + 1, 1);
            return;
        }
        push(node, l, r);
        int mid = (l + r) / 2;
        if (ql <= mid) update(node * 2, l, mid, ql, qr);
        if (qr > mid) update(node * 2 + 1, mid + 1, r, ql, qr);
        sum[node] = (sum[node * 2] + sum[node * 2 + 1]) % MOD;
        sq[node] = (sq[node * 2] + sq[node * 2 + 1]) % MOD;
    }
}