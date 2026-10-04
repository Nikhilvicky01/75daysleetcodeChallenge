class Solution {
    public boolean checkValidString(String s) {

        int minOpen = 0;
        int maxOpen = 0;

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                minOpen++;
                maxOpen++;
            }

            else if (ch == ')') {
                minOpen--;
                maxOpen--;
            }

            else { // '*'
                minOpen--;
                maxOpen++;
            }

            // Minimum cannot be negative
            minOpen = Math.max(0, minOpen);

            // Even maximum possible opens became negative
            // means there is no possible solution
            if (maxOpen < 0) {
                return false;
            }
        }

        // We need possibility of exactly 0 open brackets
        return minOpen == 0;
    }
}