import java.util.*;

class Solution {

    class Node {
        int product;
        int[] count;

        Node(int k) {
            product = 1 % k;
            count = new int[k];
        }
    }

    int k;
    Node[] tree;

    Node merge(Node left, Node right) {
        Node res = new Node(k);

        // Product of the complete segment
        res.product = (left.product * right.product) % k;

        // Prefixes completely inside left segment
        for (int r = 0; r < k; r++) {
            res.count[r] += left.count[r];
        }

        // Prefixes which start in left and continue into right
        for (int r = 0; r < k; r++) {
            int newRemainder = (left.product * r) % k;
            res.count[newRemainder] += right.count[r];
        }

        return res;
    }

    void build(int node, int start, int end, int[] nums) {

        if (start == end) {
            int value = nums[start] % k;

            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = start + (end - start) / 2;

        build(node * 2, start, mid, nums);
        build(node * 2 + 1, mid + 1, end, nums);

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    void update(int node, int start, int end, int index, int value) {

        if (start == end) {

            value %= k;

            tree[node] = new Node(k);
            tree[node].product = value;
            tree[node].count[value] = 1;

            return;
        }

        int mid = start + (end - start) / 2;

        if (index <= mid) {
            update(node * 2, start, mid, index, value);
        } else {
            update(node * 2 + 1, mid + 1, end, index, value);
        }

        tree[node] = merge(tree[node * 2], tree[node * 2 + 1]);
    }

    Node query(int node, int start, int end, int left, int right) {

        if (left <= start && end <= right) {
            return tree[node];
        }

        int mid = start + (end - start) / 2;

        if (right <= mid) {
            return query(node * 2, start, mid, left, right);
        }

        if (left > mid) {
            return query(node * 2 + 1, mid + 1, end, left, right);
        }

        Node leftNode =
                query(node * 2, start, mid, left, right);

        Node rightNode =
                query(node * 2 + 1, mid + 1, end, left, right);

        return merge(leftNode, rightNode);
    }

    public int[] resultArray(int[] nums, int k, int[][] queries) {

        this.k = k;

        int n = nums.length;

        tree = new Node[4 * n];

        for (int i = 0; i < tree.length; i++) {
            tree[i] = new Node(k);
        }

        build(1, 0, n - 1, nums);

        int[] answer = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {

            int index = queries[i][0];
            int value = queries[i][1];
            int start = queries[i][2];
            int x = queries[i][3];

            // Permanent update
            update(1, 0, n - 1, index, value);

            // Query [start, n-1]
            Node result =
                    query(1, 0, n - 1, start, n - 1);

            answer[i] = result.count[x];
        }

        return answer;
    }
}