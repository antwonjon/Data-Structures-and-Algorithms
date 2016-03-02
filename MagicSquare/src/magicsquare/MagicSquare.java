
package magicsquare;

public class MagicSquare {

    int size;
    int highest; 

    MagicSquare(int size) {
        this.size = size;
        this.highest = size * size;
    }
    
    //I can take no credit for this work, I needed desperate help and I found a resource online and pretty much copied it down verbatim. I understand how it works now and for that I am grateful.

    public boolean isMagic(int[][] sq) {
        int sum = 0;
        for (int i = 0; i < sq.length; i++) {
            sum += sq[i][0];
        }

        int diag1 = 0, diag2 = 0;
        
        for (int i = 0; i < sq.length; i++) {
            int hor = 0, vert = 0;
            for (int j = 0; j < sq[i].length; j++) {
                if (sq[i][j] == 0) {
                    return false;
                }
                hor += sq[i][j];
                vert += sq[j][i];
            }
            if (hor != sum || vert != sum) {
                return false;
            }
            diag1 += sq[i][i];
            diag2 += sq[2 - i][i];
        }
        if (diag1 != sum || diag2 != sum) {
            return false;
        }
        
        return true;
    }

    public void put(int number, int place, int[][] sq) {
        sq[place / sq.length][place % sq.length] = number;
    }

    public void remove(int place, int[][] sq) {
        sq[place / sq.length][place % sq.length] = 0;
    }

    public void print(int[][] sq) {
        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq[i].length; j++) {
                System.out.print(sq[i][j] + "  ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public int[] getFreeNumbers(int[][] sq) {
        boolean[] used = new boolean[highest + 1];
        int n = highest;
        for (int i = 0; i < sq.length; i++) {
            for (int j = 0; j < sq[i].length; j++) {
                if (sq[i][j] != 0) {
                    used[sq[i][j]] = true;
                    n--;
                }
            }
        }
        int[] result = new int[n];
        int result_i = 0;
        for (int i = 1; i < used.length; i++) {
            if (!used[i]) {
                result[result_i++] = i;
            }
        }
        return result;
    }

    public void solve() {
        int[][] square = new int[this.size][this.size];
        solve(0, square);
    }

    public void solve(int n, int[][] square) {
        if (n == highest) { 
            if (isMagic(square)) {
                System.out.println("Solution: ");
                print(square);
            }
        } else {    
            int[] numbers = getFreeNumbers(square);
            for (int i = 0; i < numbers.length; i++) {
                
                put(numbers[i], n, square);
               
                solve(n + 1, square);
                
                remove(n, square);
            }
        }
    }

    public static void main(String[] args) {
        int size = 3;
        MagicSquare ms = new MagicSquare(size);
        ms.solve();
    }
}
