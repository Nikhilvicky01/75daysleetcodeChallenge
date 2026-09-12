import java.util.*;

class Solution {

    static class Interval {
        int left;
        int right;
        int weight;
        int index;

        Interval(int left, int right, int weight, int index) {
            this.left = left;
            this.right = right;
            this.weight = weight;
            this.index = index;
        }
    }

    static class Result {
        long weight;
        List<Integer> indices;

        Result(long weight, List<Integer> indices) {
            this.weight = weight;
            this.indices = indices;
        }
    }

    private Interval[] arr;
    private Result[][] memo;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new Interval[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Interval(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by starting point
        Arrays.sort(arr, (a, b) -> {
            if (a.left != b.left)
                return Integer.compare(a.left, b.left);

            if (a.right != b.right)
                return Integer.compare(a.right, b.right);

            return Integer.compare(a.index, b.index);
        });

        memo = new Result[n][5];

        Result ans = dp(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    private Result dp(int i, int remaining) {

        // No intervals left OR cannot select any more
        if (i == arr.length || remaining == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (memo[i][remaining] != null) {
            return memo[i][remaining];
        }

        // -------------------------
        // OPTION 1: Skip interval
        // -------------------------

        Result skip = dp(i + 1, remaining);

        // -------------------------
        // OPTION 2: Take interval
        // -------------------------

        Interval current = arr[i];

        // Find first interval whose
        // starting point > current.right
        int next = findNext(i + 1, current.right);

        Result nextResult = dp(next, remaining - 1);

        long takeWeight = current.weight + nextResult.weight;

        List<Integer> takeIndices = new ArrayList<>();

        takeIndices.add(current.index);
        takeIndices.addAll(nextResult.indices);

        // Result must be lexicographically sorted
        Collections.sort(takeIndices);

        Result take = new Result(takeWeight, takeIndices);

        // -------------------------
        // Choose better result
        // -------------------------

        Result answer;

        if (take.weight > skip.weight) {

            answer = take;

        } else if (take.weight < skip.weight) {

            answer = skip;

        } else {

            // Same weight:
            // choose lexicographically smaller indices

            if (compare(take.indices, skip.indices) < 0) {
                answer = take;
            } else {
                answer = skip;
            }
        }

        memo[i][remaining] = answer;

        return answer;
    }

    private int findNext(int start, int right) {

        int low = start;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid].left > right) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}