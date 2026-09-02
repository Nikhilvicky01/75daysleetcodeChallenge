import java.util.*;

class Solution {

    public int minMoves(String[] classroom, int energy) {

        int m = classroom.length;
        int n = classroom[0].length();

        int startRow = 0;
        int startCol = 0;

        int[][] litterIndex = new int[m][n];

        for (int[] row : litterIndex) {
            Arrays.fill(row, -1);
        }

        int litterCount = 0;

        // Find S and assign an index to every L
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {

                char cell = classroom[i].charAt(j);

                if (cell == 'S') {
                    startRow = i;
                    startCol = j;
                }

                if (cell == 'L') {
                    litterIndex[i][j] = litterCount;
                    litterCount++;
                }
            }
        }

        // All litter is initially uncollected
        int initialMask = (1 << litterCount) - 1;

        // IMPORTANT: No litter means already clean
        if (initialMask == 0) {
            return 0;
        }

        // {row, col, remainingEnergy, mask}
        Queue<int[]> queue = new LinkedList<>();

        queue.offer(new int[]{
            startRow,
            startCol,
            energy,
            initialMask
        });

        boolean[][][][] visited =
            new boolean[m][n][energy + 1][1 << litterCount];

        visited[startRow][startCol][energy][initialMask] = true;

        int moves = 0;

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        while (!queue.isEmpty()) {

            int size = queue.size();

            for (int s = 0; s < size; s++) {

                int[] current = queue.poll();

                int row = current[0];
                int col = current[1];
                int remainingEnergy = current[2];
                int mask = current[3];

                // Cannot make another move
                if (remainingEnergy == 0) {
                    continue;
                }

                for (int d = 0; d < 4; d++) {

                    int newRow = row + dr[d];
                    int newCol = col + dc[d];

                    // Outside the classroom
                    if (newRow < 0 || newRow >= m ||
                        newCol < 0 || newCol >= n) {
                        continue;
                    }

                    char cell = classroom[newRow].charAt(newCol);

                    // Obstacle
                    if (cell == 'X') {
                        continue;
                    }

                    // Moving costs 1 energy
                    int newEnergy = remainingEnergy - 1;
                    int newMask = mask;

                    // Reset energy
                    if (cell == 'R') {
                        newEnergy = energy;
                    }

                    // Collect litter
                    if (cell == 'L') {

                        int index = litterIndex[newRow][newCol];

                        newMask = newMask & ~(1 << index);
                    }

                    // All litter collected
                    if (newMask == 0) {
                        return moves + 1;
                    }

                    // Already visited this exact state
                    if (visited[newRow][newCol][newEnergy][newMask]) {
                        continue;
                    }

                    visited[newRow][newCol][newEnergy][newMask] = true;

                    queue.offer(new int[]{
                        newRow,
                        newCol,
                        newEnergy,
                        newMask
                    });
                }
            }

            moves++;
        }

        return -1;
    }
}