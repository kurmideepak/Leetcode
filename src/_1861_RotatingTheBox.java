public class _1861_RotatingTheBox {

    // Copy and paste the below code inside your solution class


    public char[][] rotateTheBox(char[][] boxGrid) {
        int m = boxGrid.length;
        int n = boxGrid[0].length;

        for (int row = 0; row < m; row++) {
            int emptyPos = n - 1;

            for (int col = n - 1; col >= 0; col--) {

                if (boxGrid[row][col] == '*') {
                    emptyPos = col - 1;
                }

                else if (boxGrid[row][col] == '#') {

                    if (col != emptyPos) {
                        boxGrid[row][emptyPos] = '#';
                        boxGrid[row][col] = '.';
                    }

                    emptyPos--;
                }
            }
        }

        char[][] result = new char[n][m];

        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                result[col][m - 1 - row] = boxGrid[row][col];
            }
        }

        return result;
    }










}
