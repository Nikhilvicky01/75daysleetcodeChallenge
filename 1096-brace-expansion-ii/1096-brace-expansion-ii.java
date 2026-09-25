import java.util.*;

class Solution {

    public List<String> braceExpansionII(String expression) {
        Set<String> result = solve(expression, 0, expression.length() - 1);

        List<String> ans = new ArrayList<>(result);
        Collections.sort(ans);

        return ans;
    }

    private Set<String> solve(String s, int l, int r) {

        Set<String> result = new HashSet<>();

        int balance = 0;
        boolean hasComma = false;

        // Check for top-level comma
        for (int i = l; i <= r; i++) {

            if (s.charAt(i) == '{') {
                balance++;
            } 
            else if (s.charAt(i) == '}') {
                balance--;
            } 
            else if (s.charAt(i) == ',' && balance == 0) {

                hasComma = true;

                result.addAll(solve(s, l, i - 1));
                result.addAll(solve(s, i + 1, r));
            }
        }

        // If top-level comma exists
        if (hasComma) {
            return result;
        }

        // No comma -> concatenation
        Set<String> current = new HashSet<>();
        current.add("");

        int i = l;

        while (i <= r) {

            Set<String> part;

            // If current part is a {...}
            if (s.charAt(i) == '{') {

                int start = i;
                balance = 0;

                while (i <= r) {

                    if (s.charAt(i) == '{') {
                        balance++;
                    } 
                    else if (s.charAt(i) == '}') {
                        balance--;
                    }

                    if (balance == 0) {
                        break;
                    }

                    i++;
                }

                part = solve(s, start + 1, i - 1);

            } 
            else {

                // Single character
                part = new HashSet<>();
                part.add(String.valueOf(s.charAt(i)));
            }

            // Concatenate current with part
            Set<String> next = new HashSet<>();

            for (String a : current) {
                for (String b : part) {
                    next.add(a + b);
                }
            }

            current = next;

            i++;
        }

        return current;
    }
}