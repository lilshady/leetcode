/**
 * Created by luyuncheng on 2017/4/10.
 */
//52
public class EightQueens {


    public static int totalNQueens(int n) {

        return new NQueens(n).getCount();

    }

    public static void main(String[] args){

        System.out.println(totalNQueens(8));


    }


}

class NQueens {

    private int[] rows;
    private int n;
    private int count;

    public NQueens(int n) {

        this.n = n;

        rows = new int[n];

        for (int i = 0; i < n; ++i)
            rows[i] = -1;

    }

    private boolean isAvailable(int row, int column) {

        for (int i = 0; i < row; i++){

            if (rows[i] == column || Math.abs(rows[i] - column) == row - i)
                return false;
        }

        return true;
    }

    public int getCount() {

        getSolution(0);

        return this.count;


    }

    public void getSolution(int row) {

        if (row == this.n)
            this.count ++;

        else {
            for (int j = 0; j < n; ++j) {


                if (isAvailable(row, j)) {
                    rows[row] = j;
                    getSolution(row + 1);
                }

            }
        }

    }


}
