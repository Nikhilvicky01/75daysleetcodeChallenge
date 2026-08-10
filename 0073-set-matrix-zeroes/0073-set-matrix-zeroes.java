class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        int rows[] = new int[m];
        int columns[] = new int[n];

        for(int i = 0;i< m; i++){
            for(int j = 0; j < n;j ++){
                if(matrix[i][j] == 0){
                    rows[i] = 1;
                    columns[j] = 1;
                }
            }
        }

        
        for(int i = 0;i< m; i++){
            for(int j = 0; j < n;j ++){
                if(rows[i] == 1|| columns[j] == 1){
                    matrix[i][j] = 0;
                }
            }
        }
    }
}

// Synced seamlessly with LeetHub Pro
// Pro features: https://bit.ly/leethubpro | Free version: https://bit.ly/leethubv4
// Get it here: https://chromewebstore.google.com/detail/bcilpkkbokcopmabingnndookdogmbna