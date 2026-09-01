class Solution {
    public int minMoves(String[] classroom, int energy) {
        int m = classroom.length;
        int n = classroom[0].length();
        
        int startR = -1, startC = -1;
        int litterCount = 0;
        int[][] litterId = new int[m][n];
        for (int[] row : litterId) {
            Arrays.fill(row, -1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = classroom[i].charAt(j);
                if (c == 'S') {
                    startR = i;
                    startC = j;
                } else if (c == 'L') {
                    litterId[i][j] = litterCount++;
                }
            }
        }
        if (litterCount == 0) {
            return 0;
        }

        int targetMask = (1 << litterCount) - 1;
        Queue<int[]> queue = new LinkedList<>();
        int[][][] bestEnergy = new int[m][n][1 << litterCount];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(bestEnergy[i][j], -1);
            }
        }
        queue.offer(new int[]{startR, startC, energy, 0});
        bestEnergy[startR][startC][0] = energy;

        int moves = 0;
        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] curr = queue.poll();
                int r = curr[0];
                int c = curr[1];
                int e = curr[2];
                int mask = curr[3];

                if (mask == targetMask) {
                    return moves;
                }

                if (e == 0) {
                    continue; 
                }

                for (int[] dir : directions) {
                    int nr = r + dir[0];
                    int nc = c + dir[1];

                    if (nr >= 0 && nr < m && nc >= 0 && nc < n && classroom[nr].charAt(nc) != 'X') {
                        char nextCell = classroom[nr].charAt(nc);
                        int nextMask = mask;
                        int nextEnergy = e - 1;
                        if (nextCell == 'L') {
                            nextMask |= (1 << litterId[nr][nc]);
                        } 
                        else if (nextCell == 'R') {
                            nextEnergy = energy;
                        }
                        if (nextEnergy > bestEnergy[nr][nc][nextMask]) {
                            bestEnergy[nr][nc][nextMask] = nextEnergy;
                            queue.offer(new int[]{nr, nc, nextEnergy, nextMask});
                        }
                    }
                }
            }
            moves++;
        }

        return -1;
    }
}