
import java.util.ArrayList;

public class main {
    public static void main(String[] args) {

        // ArrayList of Arraylist<Squares> as game board
        ArrayList<ArrayList <Square>> squareMatrix = new ArrayList();
        int[] pos;
        // Add 'w' or 'b' to squares in the matrix
        for (int i = 0; i < 8; i++)
        {
            pos = new int[]{i, 0};
            squareMatrix.add(new ArrayList());
            if (i % 2 != 0)
                squareMatrix.get(i).add(new Square(true, pos));
            else
                squareMatrix.get(i).add(new Square(false, pos));
            for (int j = 1; j < 8; j++)
            {
                pos = new int[]{i, j};
                if (squareMatrix.get(i).get(j - 1).getColor() == 'b')
                    squareMatrix.get(i).add(new Square(true, pos));
                else
                    squareMatrix.get(i).add(new Square(false, pos));
            }
        }

        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                if (j == 0 || j == 1 || j == 6 || j == 7)
                    squareMatrix.get(i).get(j).setHasPiece(true);
            }
        }

        // Print out to console for testing
        /*
        for (int i = 7; i >= 0; i--)
        {
            for (int j = 0; j < 8; j++)
            {
                System.out.print(squareMatrix.get(j).get(i).getColor() + " ");
            }
            System.out.println(" ");
        }
        */

        new ChessBoard(squareMatrix);
    }
}
