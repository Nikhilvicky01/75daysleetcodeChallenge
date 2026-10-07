class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();

        int left = 0;
        int right = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                left++;
            } 
            else if (c == ')') {
                if (left > 0) {
                    left--;
                } 
                else {
                    right++;
                }
            }
        }

        backtrack(s, 0, left, right, 0, "", set);

        ans.addAll(set);
        return ans;
    }

    private void backtrack(String s, int index,
                           int leftRemove, int rightRemove,
                           int balance, String current,
                           Set<String> set) {

        if (index == s.length()) {
            if (leftRemove == 0 &&
                rightRemove == 0 &&
                balance == 0) {
                set.add(current);
            }
            return;
        }

        char ch = s.charAt(index);
        if (ch == '(' && leftRemove > 0) {
            backtrack(
                s,
                index + 1,
                leftRemove - 1,
                rightRemove,
                balance,
                current,
                set
            );
        }

        if (ch == ')' && rightRemove > 0) {
            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove - 1,
                balance,
                current,
                set
            );
        }

        if (ch == '(') {
            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance + 1,
                current + ch,
                set
            );
        }

        else if (ch == ')') {
            if (balance > 0) {
                backtrack(
                    s,
                    index + 1,
                    leftRemove,
                    rightRemove,
                    balance - 1,
                    current + ch,
                    set
                );
            }
        }

        else {
            backtrack(
                s,
                index + 1,
                leftRemove,
                rightRemove,
                balance,
                current + ch,
                set
            );
        }
    }
}